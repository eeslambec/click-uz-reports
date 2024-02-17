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
    private BigDecimal amount;
    private String serviceName;
    private LocalDateTime transactionDateTime;
    @Enumerated(EnumType.STRING)
    private Status status;
}
