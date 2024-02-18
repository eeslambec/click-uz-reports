package uz.click.clickuzreports.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ServiceCategory {
    FAVORITE("","",""),
    MOBILE_OPERATORS("","",""),
    INTERNET_PACKAGES("","",""),
    INTERNET_PROVIDERS("","",""),
    TV("","",""),
    TELEPHONY("","",""),
    LOAN_REPAYMENT("","",""),
    UTILITY_PAYMENTS("","",""),
    HOSTING_AND_DOMAINS("","",""),
    INTERNET_SERVICES("","",""),
    CHARITY("","",""),
    TAXES("","",""),
    PUBLIC_SERVICES_AND_DMV("","",""),
    EDUCATION("","",""),
    HEALTH("","",""),
    ENTERTAINMENT_AND_LEISURE("","",""),
    INSURANCE("","",""),
    TAXI("","",""),
    INTERNATIONAL_SERVICES("","",""),
    PAYMENT_TO_BANK_ACCOUNT("","",""),
    TRANSPORT_AND_PARKING("","",""),
    RETAIL("","",""),
    CAFE_AND_RESTAURANTS("","",""),
    GAS_STATIONS("","",""),
    ENTERTAINMENT("","",""),
    MEDICINE_AND_DRUGSTORES("","",""),
    BEAUTY_SPORTS("","",""),
    FOR_KIDS("", "", ""),
    TOURISM_TRAVELING("","",""),
    SERVICES("","","");
    private final String uz;
    private final String en;
    private final String ru;
}
