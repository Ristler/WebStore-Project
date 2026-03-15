package fi.metropolia.danielju.webstore.repositories;

import fi.metropolia.danielju.webstore.entity.OutOfStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutOfStockRepository extends JpaRepository<OutOfStock, Integer> {
}

