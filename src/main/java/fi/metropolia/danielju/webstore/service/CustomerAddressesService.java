package fi.metropolia.danielju.webstore.service;

import fi.metropolia.danielju.webstore.entity.Customer;
import fi.metropolia.danielju.webstore.entity.CustomerAddresses;
import fi.metropolia.danielju.webstore.repositories.CustomerAddressesRepository;
import fi.metropolia.danielju.webstore.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerAddressesService {
    private final CustomerAddressesRepository addressesRepository;
    private final CustomerRepository customerRepository;

    public CustomerAddressesService(CustomerAddressesRepository addressesRepository, CustomerRepository customerRepository) {
        this.addressesRepository = addressesRepository;
        this.customerRepository = customerRepository;
    }

    public CustomerAddresses createAddress(int customerId, CustomerAddresses address) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found with id: " + customerId));
        address.setCustomer(customer);
        return addressesRepository.save(address);
    }

    public CustomerAddresses updateAddress(int id, CustomerAddresses updatedAddress) {
        CustomerAddresses address = addressesRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Address not found with id: " + id));
        address.setStreetAddress(updatedAddress.getStreetAddress());
        address.setPostalCode(updatedAddress.getPostalCode());
        address.setCity(updatedAddress.getCity());
        address.setCountry(updatedAddress.getCountry());
        // Optionally update customer if needed
        return addressesRepository.save(address);
    }

    public void deleteAddress(int id) {
        addressesRepository.deleteById(id);
    }

    public Optional<CustomerAddresses> getAddress(int id) {
        return addressesRepository.findById(id);
    }

    public Optional<CustomerAddresses> getAddressByCustomerId(int customerId) {
        return Optional.ofNullable(addressesRepository.findByCustomerId(customerId));
    }

    public CustomerAddresses updateAddressByCustomerId(int customerId, CustomerAddresses updatedAddress) {
        CustomerAddresses address = addressesRepository.findByCustomerId(customerId);
        if (address == null) {
            throw new IllegalArgumentException("Address not found for customer id: " + customerId);
        }
        address.setStreetAddress(updatedAddress.getStreetAddress());
        address.setPostalCode(updatedAddress.getPostalCode());
        address.setCity(updatedAddress.getCity());
        address.setCountry(updatedAddress.getCountry());
        return addressesRepository.save(address);
    }

    public void deleteAddressByCustomerId(int customerId) {
        CustomerAddresses address = addressesRepository.findByCustomerId(customerId);
        if (address != null) {
            addressesRepository.delete(address);
        }
    }
}
