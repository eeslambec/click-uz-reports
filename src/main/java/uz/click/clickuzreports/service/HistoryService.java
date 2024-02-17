package uz.click.clickuzreports.service;

import org.springframework.stereotype.Service;
import uz.click.clickuzreports.dto.PaymentHistoryDto;
import uz.click.clickuzreports.dto.TransferHistoryDto;
import uz.click.clickuzreports.entity.History;

import java.math.BigDecimal;
import java.time.Month;
import java.util.List;

@Service
public interface HistoryService {
    History createPaymentHistory(PaymentHistoryDto paymentHistoryDto);
    History createTransferHistory(TransferHistoryDto transferHistoryDto);
    History getById(Long id);
    List<History> getByAmount(BigDecimal amount);
    List<History> getAllByMonth(Month month);
    List<History> getByDayOfTheMonth(int dayOfTheMonth);
    List<History> getByReceiverCardNumber(String number);
    List<History> getBySenderCardNumber(String number);
    History
}