package uz.click.clickuzreports.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.click.clickuzreports.entity.History;

public interface HistoryRepository extends JpaRepository<Long, History> {
}
