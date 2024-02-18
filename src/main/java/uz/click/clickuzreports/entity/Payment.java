package uz.click.clickuzreports.entity;

import jakarta.persistence.*;
import lombok.*;
import uz.click.clickuzreports.entity.enums.Status;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Payment {
    private Long id;
    private Long serviceId;
    private Long cardId;
    private BigDecimal amount;
    @Enumerated(EnumType.STRING)
    private Status status;
    private LocalDateTime paymentTime;

}
