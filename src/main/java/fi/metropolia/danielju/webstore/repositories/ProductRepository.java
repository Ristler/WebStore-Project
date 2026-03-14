package fi.metropolia.danielju.webstore.repositories;
import fi.metropolia.danielju.webstore.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
