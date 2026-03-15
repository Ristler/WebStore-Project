package fi.metropolia.danielju.webstore.service;

import fi.metropolia.danielju.webstore.entity.Supplier;
import fi.metropolia.danielju.webstore.entity.SupplierAddresses;
import fi.metropolia.danielju.webstore.repositories.SupplierAddressesRepository;
import fi.metropolia.danielju.webstore.repositories.SupplierRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SupplierAddressesService {
    private final SupplierAddressesRepository addressesRepository;
    private final SupplierRepository supplierRepository;

    public SupplierAddressesService(SupplierAddressesRepository addressesRepository, SupplierRepository supplierRepository) {
        this.addressesRepository = addressesRepository;
        this.supplierRepository = supplierRepository;
    }

    public SupplierAddresses createAddress(int supplierId, SupplierAddresses address) {
        Supplier supplier = supplierRepository.findById(supplierId)
                .orElseThrow(() -> new IllegalArgumentException("Supplier not found with id: " + supplierId));
        address.setSupplier(supplier);
        return addressesRepository.save(address);
    }

    public Optional<SupplierAddresses> getAddressBySupplierId(int supplierId) {
        return Optional.ofNullable(addressesRepository.findBySupplier_Id(supplierId));
    }

    public SupplierAddresses updateAddressBySupplierId(int supplierId, SupplierAddresses updatedAddress) {
        SupplierAddresses address = addressesRepository.findBySupplier_Id(supplierId);
        if (address == null) {
            throw new IllegalArgumentException("Address not found for supplier id: " + supplierId);
        }
        address.setStreetAddress(updatedAddress.getStreetAddress());
        address.setPostalCode(updatedAddress.getPostalCode());
        address.setCity(updatedAddress.getCity());
        address.setCountry(updatedAddress.getCountry());
        return addressesRepository.save(address);
    }

    public void deleteAddressBySupplierId(int supplierId) {
        SupplierAddresses address = addressesRepository.findBySupplier_Id(supplierId);
        if (address != null) {
            addressesRepository.delete(address);
        }
    }
}
