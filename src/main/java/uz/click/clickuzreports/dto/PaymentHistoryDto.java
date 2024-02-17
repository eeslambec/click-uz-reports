package uz.click.clickuzreports.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import uz.click.clickuzreports.entity.enums.Status;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class PaymentHistoryDto {
    private String organizationName;
    private String bankAccountNumber;
    private BigDecimal amount;
    private LocalDateTime transactionDateTime = LocalDateTime.now();
    private Status status = Status.FAILED;
}
