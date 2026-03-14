package fi.metropolia.danielju.webstore.repositories;
import fi.metropolia.danielju.webstore.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
}
