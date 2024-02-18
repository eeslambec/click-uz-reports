package uz.click.clickuzreports;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ClickUzReportsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClickUzReportsApplication.class, args);
	}

}
