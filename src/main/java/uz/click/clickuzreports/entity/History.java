package uz.click.clickuzreports.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import uz.click.clickuzreports.entity.enums.Status;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long receiverCardId;
    private Long senderCardId;
    private String cardNumber;
    private BigDecimal amount;
    private Long serviceId;
    private LocalDateTime transactionDateTime;
    @Enumerated(EnumType.STRING)
    private Status status;

    public History(Payment payment) {
        this.senderCardId = payment.getCardId();
        this.amount = payment.getAmount();
        this.transactionDateTime = payment.getPaymentTime();
        this.serviceId = payment.getServiceId();
        this.status = payment.getStatus();
    }
    public History(Transfer transfer){
        this.senderCardId = transfer.getSenderCardId();
        this.receiverCardId = transfer.getReceiverCardId();
        this.amount = transfer.getAmount();
        this.transactionDateTime = transfer.getTransferDate();
        this.status = transfer.getStatus();
    }
}
