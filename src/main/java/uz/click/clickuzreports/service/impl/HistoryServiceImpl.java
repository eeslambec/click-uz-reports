package uz.click.clickuzreports.service.impl;

import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import uz.click.clickuzreports.entity.History;
import uz.click.clickuzreports.exception.FileCannotCreatedException;
import uz.click.clickuzreports.exception.InvalidArgumentException;
import uz.click.clickuzreports.exception.NotFoundException;
import uz.click.clickuzreports.exception.NullOrEmptyException;
import uz.click.clickuzreports.repository.HistoryRepository;
import uz.click.clickuzreports.service.HistoryService;

import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HistoryServiceImpl implements HistoryService {
    private final HistoryRepository historyRepository;
    public XSSFWorkbook workbook = new XSSFWorkbook();
    public XSSFSheet  sheet = workbook.createSheet("History");
    private final Row headerRow = sheet.createRow(0);

    public String[] header = {"id", "receiverCardNumber", "senderCardNumber", "amount", "serviceId", "transactionDateTime", "status"};
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
            throw new NullOrEmptyException("Card number");
        return historyRepository.findAllByReceiverCardNumber(number);
    }

    @Override
    public void download(String month, int year) {
        List<History> all = historyRepository.findAll();
        List<History> byMonth = new ArrayList<>();
        for (History history : all) {
            if (history.getTransactionDateTime().getMonth().toString().equals(month)
                    && history.getTransactionDateTime().getYear() == year)
                byMonth.add(history);
        }
        for (int i = 0; i < byMonth.size(); i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(header[i]);
        }
        for (int i = 0; i < byMonth.size(); i++) {
            Row row = sheet.createRow(i + 1);
            row.createCell(0).setCellValue(byMonth.get(i).getId());
            row.createCell(1).setCellValue(byMonth.get(i).getReceiverCardNumber());
            row.createCell(2).setCellValue(byMonth.get(i).getSenderCardNumber());
            row.createCell(3).setCellValue(byMonth.get(i).getAmount().intValue());
            row.createCell(4).setCellValue(byMonth.get(i).getServiceId());
            row.createCell(5).setCellValue(byMonth.get(i).getTransactionDateTime());
            row.createCell(6).setCellValue(byMonth.get(i).getStatus().toString());
        }

        FileOutputStream out;
        try {
            out = new FileOutputStream(new File("/media/eeslambec/6004ABC004AB9814/projects/files/history.xlsx"));
            workbook.write(out);
            out.close();
        }
        catch (Exception e) {
            throw new FileCannotCreatedException();
        }
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
