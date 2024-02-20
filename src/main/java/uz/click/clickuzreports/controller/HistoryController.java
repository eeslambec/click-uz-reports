package uz.click.clickuzreports.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.click.clickuzreports.dto.response.CustomResponseEntity;
import uz.click.clickuzreports.entity.History;
import uz.click.clickuzreports.service.HistoryService;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/history")
public class HistoryController {
    private final HistoryService historyService;
    @PostMapping("/create")
    public CustomResponseEntity<?> create(@RequestBody History history){
        return CustomResponseEntity.ok(historyService.create(history));
    }
    @GetMapping("/{id}")
    public CustomResponseEntity<?> getById(@PathVariable Long id){
        return CustomResponseEntity.ok(historyService.getById(id));
    }

    @GetMapping("/amount/{amount}")
    public CustomResponseEntity<?> getByAmount(@PathVariable BigDecimal amount){
        return CustomResponseEntity.ok(historyService.getByAmount(amount));
    }

    @GetMapping("/time/{time}")
    public CustomResponseEntity<?> getByTime(@PathVariable LocalDateTime time) {
        return CustomResponseEntity.ok(historyService.getAllByTime(time));
    }

    @GetMapping("/all")
    public CustomResponseEntity<?> getAll(){
        return CustomResponseEntity.ok(historyService.getAll());
    }

    @GetMapping("/cardNumber/receiver/{number}")
    public CustomResponseEntity<?> getByReceiverCardNumber(@PathVariable String number){
        return CustomResponseEntity.ok(historyService.getByReceiverCardNumber(number));
    }
    @GetMapping("/cardNumber/{number}")
    public CustomResponseEntity<?> getByCardNumber(@PathVariable String number){
        return CustomResponseEntity.ok(historyService.getByCardNumber(number));
    }
    @GetMapping("/cardNumber/sender/{number}")
    public CustomResponseEntity<?> getBySenderCardNumber(@PathVariable String number){
        return CustomResponseEntity.ok(historyService.getBySenderCardNumber(number));
    }
}
