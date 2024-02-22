package uz.click.clickuzreports.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.click.clickuzreports.entity.History;
import uz.click.clickuzreports.exception.InvalidArgumentException;
import uz.click.clickuzreports.exception.NotFoundException;
import uz.click.clickuzreports.exception.NullOrEmptyException;
import uz.click.clickuzreports.repository.HistoryRepository;
import uz.click.clickuzreports.service.HistoryService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HistoryServiceImpl implements HistoryService {
    private final HistoryRepository historyRepository;
    @Override
    public History create(History history) {
        if (history.getId() != null)
            throw new InvalidArgumentException("Id");
        if (history.getServiceId() == null)
            throw new NullOrEmptyException("Service Id");
        if (history.getAmount() == null)
            throw new NullOrEmptyException("Amount");
        if (history.getTransactionDateTime() == null)
            throw new NullOrEmptyException("Transaction time");
        if (history.getSenderCardNumber() == null)
            throw new NullOrEmptyException("Sender card number");
        if (history.getServiceId() == 1 && history.getReceiverCardNumber() == null)
            throw new NullOrEmptyException("Receiver card number");
        return historyRepository.save(history);
    }
    @Override
    public History getById(Long id) {
        if (id == null)
            throw new NullOrEmptyException("Id");
        return historyRepository.findById(id).orElseThrow(
                () -> new NotFoundException("History")
        );
    }

    @Override
    public List<History> getByAmount(BigDecimal amount) {
        if (amount == null)
            throw new NullOrEmptyException("Amount");
        return historyRepository.findAllByAmount(amount);
    }

    @Override
    public List<History> getAllByTime(LocalDateTime historyTime) {
        if (historyTime == null)
            throw new NullOrEmptyException("History time");
        if (historyTime.isAfter(LocalDateTime.now()))
            throw new InvalidArgumentException("Date time");
        return historyRepository.findAllByTransactionDateTime(historyTime);
    }

    @Override
    public List<History> getAll() {
        return historyRepository.findAll();
    }

    @Override
    public List<History> getByReceiverCardNumber(String number) {
        if (number == null || number.isBlank() || number.isEmpty())
            throw new NullOrEmptyException("Card number");
        return historyRepository.findAllBySenderCardNumber(number);
    }

    @Override
    public List<History> getBySenderCardNumber(String number) {
        if (number == null || number.isEmpty() || number.isBlank())
            throw new NullOrEmptyException("CArd number");
        return historyRepository.findAllByReceiverCardNumber(number);
    }

    @Override
    public void download(String month, String year) {

    }
    @Override
    public List<History> getByCardNumber(String number) {
        if (number == null || number.isEmpty() || number.isBlank())
            throw new NullOrEmptyException("Card number");
        List<History> histories = historyRepository.findAllBySenderCardNumber(number);
        histories.addAll(historyRepository.findAllByReceiverCardNumber(number));
        return histories;
    }
}
