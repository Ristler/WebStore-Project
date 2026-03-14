package fi.metropolia.danielju.webstore.repositories;
import fi.metropolia.danielju.webstore.entity.SupplierAddresses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierAddressesRepository extends JpaRepository<SupplierAddresses, Integer> {
}
