package uz.click.clickuzreports.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uz.click.clickuzreports.security.ClickUzAuthentication;
import uz.click.clickuzreports.dto.response.CustomResponseEntity;

@FeignClient("click-uz-settings")
public interface TokenProxy {
    @GetMapping("/verify")
    CustomResponseEntity<ClickUzAuthentication> verify(@RequestParam String token);
}
