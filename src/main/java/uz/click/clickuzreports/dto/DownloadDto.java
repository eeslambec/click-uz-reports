package uz.click.clickuzreports.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DownloadDto {
    private String cardNumber;
    private String month;
    private Integer year;
}
