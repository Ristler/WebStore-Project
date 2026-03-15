package fi.metropolia.danielju.webstore.repositories;

import fi.metropolia.danielju.webstore.entity.Customer;
import fi.metropolia.danielju.webstore.entity.CustomerAddresses;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerAddressesRepository extends JpaRepository<CustomerAddresses, Integer> {
    Optional<CustomerAddresses> findByCustomer(Customer customer);
    CustomerAddresses findByCustomerId(int customerId);
}
