package uz.click.clickuzreports.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.click.clickuzreports.dto.PaymentHistoryDto;
import uz.click.clickuzreports.dto.TransferHistoryDto;
import uz.click.clickuzreports.entity.History;
import uz.click.clickuzreports.entity.Payment;
import uz.click.clickuzreports.entity.Transfer;
import uz.click.clickuzreports.exception.InvalidArgumentException;
import uz.click.clickuzreports.exception.NotFoundException;
import uz.click.clickuzreports.exception.NullOrEmptyException;
import uz.click.clickuzreports.proxy.PaymentProxy;
import uz.click.clickuzreports.proxy.TransferProxy;
import uz.click.clickuzreports.repository.HistoryRepository;
import uz.click.clickuzreports.service.HistoryService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HistoryServiceImpl implements HistoryService {
    private final HistoryRepository historyRepository;
    private final PaymentProxy paymentProxy;
    private final TransferProxy transferProxy;

    @Override
    public History createPaymentHistory(PaymentHistoryDto paymentHistoryDto) {
        if (paymentHistoryDto.getServiceId() == null)
            throw new NullOrEmptyException("Service ID");
        if (paymentHistoryDto.getAmount() == null)
            throw new NullOrEmptyException("Amount");
        if (paymentHistoryDto.getTransactionDateTime() == null)
            throw new NullOrEmptyException("Transaction date time");
        if (paymentHistoryDto.getSenderCardNumber() == null ||
                paymentHistoryDto.getSenderCardNumber().isBlank() ||
                paymentHistoryDto.getSenderCardNumber().isEmpty())
            throw new NullOrEmptyException("Sender card number");
        ResponseEntity<Payment> bySenderCardNumber = paymentProxy.getBySenderCardNumber(paymentHistoryDto.getSenderCardNumber());
        if (bySenderCardNumber.getBody() == null)
            throw new NotFoundException("Payment by sender card number");
        Payment payment = bySenderCardNumber.getBody();
        return historyRepository.save(new History(payment));
    }

    @Override
    public History createTransferHistory(TransferHistoryDto transferHistoryDto) {
        if (transferHistoryDto.getAmount() == null)
            throw new NullOrEmptyException("Amount");
        if (transferHistoryDto.getStatus() == null)
            throw new NullOrEmptyException("Status");
        if (transferHistoryDto.getTransactionDateTime() == null)
            throw new NullOrEmptyException("Transfer date time");
        if (transferHistoryDto.getCardNumber() == null || transferHistoryDto.getCardNumber().isEmpty() || transferHistoryDto.getCardNumber().isBlank())
            throw new NullOrEmptyException("Card number");

        ResponseEntity<Transfer> bySenderCardNumber = transferProxy.getBySenderCardNumber(transferHistoryDto.getCardNumber());
        if (bySenderCardNumber.getBody() == null)
            throw new NotFoundException("Transfer by card number");
        Transfer transfer = bySenderCardNumber.getBody();
        return historyRepository.save(new History(transfer));
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
        return historyRepository.findAllByCardNumber(number);
    }

    @Override
    public List<History> getBySenderCardNumber(String number) {
        if (number == null || number.isEmpty() || number.isBlank())
            throw new NullOrEmptyException("CArd number");
        return historyRepository.findAllByCardNumber(number);
    }
}
