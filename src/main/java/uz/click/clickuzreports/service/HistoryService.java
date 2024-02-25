package uz.click.clickuzreports.service;

import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;
import uz.click.clickuzreports.dto.DownloadDto;
import uz.click.clickuzreports.entity.History;

import java.io.InputStream;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public interface HistoryService {
    History create(History history);
    History getById(Long id);
    List<History> getByAmount(BigDecimal amount);
    List<History> getAllByTime(LocalDateTime historyTime);
    List<History> getAll();
    List<History> getByReceiverCardNumber(String number);
    List<History> getBySenderCardNumber(String number);
    List<History> getByCardNumber(String number);
    String download(DownloadDto downloadDto);
}