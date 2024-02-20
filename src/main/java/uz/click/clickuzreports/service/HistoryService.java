package uz.click.clickuzreports.service;

import org.springframework.stereotype.Service;
import uz.click.clickuzreports.entity.History;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public interface HistoryService {
    History create(History history);
    History getById(Long id);
    List<History> getByAmount(BigDecimal amount);
    List<History> getAllByTime(LocalDateTime historyTime);
    List<History> getAll();
    List<History> getByReceiverCardNumber(String number);
    List<History> getBySenderCardNumber(String number);
    List<History> getByCardNumber(String number);
}