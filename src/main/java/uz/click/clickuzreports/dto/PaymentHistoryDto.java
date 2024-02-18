package uz.click.clickuzreports.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import uz.click.clickuzreports.entity.enums.Status;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class PaymentHistoryDto {
    private Long serviceId;
    private BigDecimal amount;
    private LocalDateTime transactionDateTime;
    private String senderCardNumber;
    private Status status;
}
