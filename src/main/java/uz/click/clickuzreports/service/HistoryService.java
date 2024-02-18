package uz.click.clickuzreports.service;

import org.springframework.stereotype.Service;
import uz.click.clickuzreports.dto.PaymentHistoryDto;
import uz.click.clickuzreports.dto.TransferHistoryDto;
import uz.click.clickuzreports.entity.History;
import uz.click.clickuzreports.entity.Payment;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

@Service
public interface HistoryService {
    History createPaymentHistory(PaymentHistoryDto paymentHistoryDto);
    History createTransferHistory(TransferHistoryDto transferHistoryDto);
    History getById(Long id);
    List<History> getByAmount(BigDecimal amount);
    List<History> getAllByTime(LocalDateTime historyTime);
    List<History> getAll();
    List<History> getByReceiverCardNumber(String number);
    List<History> getBySenderCardNumber(String number);
}