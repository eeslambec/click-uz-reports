package uz.click.clickuzreports.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import uz.click.clickuzreports.entity.Transfer;

@FeignClient("click-uz-transfer")
public interface TransferProxy {
    @GetMapping("")
    ResponseEntity<Transfer> getById(@PathVariable Long id);


    @GetMapping("")
    ResponseEntity<Transfer> getByReceiverCardNumber(@PathVariable String number);

    @GetMapping("")
    ResponseEntity<Transfer> getBySenderCardNumber(@PathVariable String number);
}