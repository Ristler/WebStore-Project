package fi.metropolia.danielju.webstore.service;

import fi.metropolia.danielju.webstore.dto.SupplierWithAddressDTO;
import fi.metropolia.danielju.webstore.entity.Supplier;
import fi.metropolia.danielju.webstore.entity.SupplierAddresses;
import fi.metropolia.danielju.webstore.repositories.SupplierAddressesRepository;
import fi.metropolia.danielju.webstore.repositories.SupplierRepository;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
public class SupplierService {
    private final SupplierRepository supplierRepository;
    private final SupplierAddressesRepository supplierAddressesRepository;

    public SupplierService(SupplierRepository supplierRepository, SupplierAddressesRepository supplierAddressesRepository) {
        this.supplierRepository = supplierRepository;
        this.supplierAddressesRepository = supplierAddressesRepository;
    }

    @Transactional
    public Supplier createSupplierWithAddress(SupplierWithAddressDTO dto) {
        Supplier supplier = new Supplier(
            dto.name,
            dto.contactName,
            dto.phone,
            dto.email
        );
        Supplier savedSupplier = supplierRepository.save(supplier);
        SupplierAddresses address = new SupplierAddresses(
            savedSupplier,
            dto.streetAddress,
            dto.postalCode,
            dto.city,
            dto.country
        );
        supplierAddressesRepository.save(address);
        return savedSupplier;
    }
}

