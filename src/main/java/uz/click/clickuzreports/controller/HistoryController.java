package uz.click.clickuzreports.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.click.clickuzreports.dto.PaymentHistoryDto;
import uz.click.clickuzreports.dto.TransferHistoryDto;
import uz.click.clickuzreports.service.HistoryService;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/history")
public class HistoryController {
    private final HistoryService historyService;

    @PostMapping("/payment")
    public ResponseEntity<?> paymentHistory(@RequestBody PaymentHistoryDto paymentHistoryDto){
        return ResponseEntity.ok(historyService.createPaymentHistory(paymentHistoryDto));
    }

    @PostMapping("/transfer")
    public ResponseEntity<?> transferHistory(@RequestBody TransferHistoryDto transferHistoryDto){
        return ResponseEntity.ok(historyService.createTransferHistory(transferHistoryDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return ResponseEntity.ok(historyService.getById(id));
    }

    @GetMapping("/amount/{amount}")
    public ResponseEntity<?> getByAmount(@PathVariable BigDecimal amount){
        return ResponseEntity.ok(historyService.getByAmount(amount));
    }

    @GetMapping("/time/{time}")
    public ResponseEntity<?> getByTime(@PathVariable LocalDateTime time) {
        return ResponseEntity.ok(historyService.getAllByTime(time));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(historyService.getAll());
    }

    @GetMapping("/receiver-card/{number}")
    public ResponseEntity<?> getByReceiverCardNumber(@PathVariable String number){
        return ResponseEntity.ok(historyService.getByReceiverCardNumber(number));
    }

    @GetMapping("/sender-card/{number}")
    public ResponseEntity<?> getBySenderCardNumber(@PathVariable String number){
        return ResponseEntity.ok(historyService.getBySenderCardNumber(number));
    }
}
