package uz.click.clickuzreports.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.click.clickuzreports.entity.History;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface HistoryRepository extends JpaRepository<History, Long> {
    List<History> findAllByAmount(BigDecimal amount);
    List<History> findAllByTransactionDateTime(LocalDateTime history);
    List<History> findAllBySenderCardNumber(String cardNumber);
    List<History> findAllByReceiverCardNumber(String cardNumber);
}
