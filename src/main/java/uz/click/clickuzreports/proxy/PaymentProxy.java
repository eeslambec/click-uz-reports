package uz.click.clickuzreports.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import uz.click.clickuzreports.entity.Payment;

import java.util.List;

@FeignClient("click-uz-payment")
public interface PaymentProxy {

    @GetMapping("")
    ResponseEntity<Payment> getById(@PathVariable Long id);

    @GetMapping("")
    ResponseEntity<Payment> getBySenderCardNumber(@PathVariable String cardNumber);

    @GetMapping("")
    ResponseEntity<List<Payment>> getAll();
}
