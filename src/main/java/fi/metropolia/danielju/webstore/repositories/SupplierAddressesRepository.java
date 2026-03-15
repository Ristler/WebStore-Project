package fi.metropolia.danielju.webstore.repositories;
import fi.metropolia.danielju.webstore.entity.Supplier;
import fi.metropolia.danielju.webstore.entity.SupplierAddresses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import jakarta.transaction.Transactional;

import java.util.Optional;

public interface SupplierAddressesRepository extends JpaRepository<SupplierAddresses, Integer> {
    Optional<SupplierAddresses> findBySupplier(Supplier supplier);

    SupplierAddresses findBySupplier_Id(int supplierId);

    @Modifying
    @Transactional
    @Query("DELETE FROM SupplierAddresses sa WHERE sa.supplier.id = ?1")
    int deleteBySupplierId(int supplierId);

}