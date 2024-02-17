package uz.click.clickuzreports;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        if (localDateTime.getDayOfMonth() == 16){
            System.out.println(localDateTime.getMonthValue());
        }
    }
}
