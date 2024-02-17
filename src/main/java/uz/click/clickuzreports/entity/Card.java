package uz.click.clickuzreports.entity;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import uz.click.clickuzreports.entity.enums.CardType;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Card {
    private Long id;
    private String name;
    private String cardNumber;
    private String expiryDate;
    @Enumerated(EnumType.STRING)
    private CardType type;
    private boolean isMain;
    private Byte cvv;
    private BigDecimal balance;
}
