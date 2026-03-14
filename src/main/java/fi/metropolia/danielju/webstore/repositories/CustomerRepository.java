package fi.metropolia.danielju.webstore.repositories;

import fi.metropolia.danielju.webstore.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}

