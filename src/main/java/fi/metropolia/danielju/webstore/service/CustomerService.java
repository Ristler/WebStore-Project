package fi.metropolia.danielju.webstore.service;

import fi.metropolia.danielju.webstore.dto.CustomerWithAddressDTO;
import fi.metropolia.danielju.webstore.entity.Customer;
import fi.metropolia.danielju.webstore.entity.CustomerAddresses;
import fi.metropolia.danielju.webstore.entity.Order;
import fi.metropolia.danielju.webstore.repositories.CustomerAddressesRepository;
import fi.metropolia.danielju.webstore.repositories.CustomerRepository;
import fi.metropolia.danielju.webstore.repositories.OrderItemsRepository;
import fi.metropolia.danielju.webstore.repositories.OrderRepository;
import fi.metropolia.danielju.webstore.repositories.SupplierAddressesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);

    private final CustomerRepository repository;
    private final CustomerAddressesRepository customerAddressesRepository;
    private final OrderRepository orderRepository;
    private final OrderItemsRepository orderItemsRepository;
    private final SupplierAddressesRepository supplierAddressesRepository;
    private final JdbcTemplate jdbcTemplate;

    public CustomerService(CustomerRepository repository,
                           CustomerAddressesRepository customerAddressesRepository,
                           OrderRepository orderRepository,
                           OrderItemsRepository orderItemsRepository,
                           SupplierAddressesRepository supplierAddressesRepository,
                           JdbcTemplate jdbcTemplate)
    {
        this.repository = repository;
        this.customerAddressesRepository = customerAddressesRepository;
        this.orderRepository = orderRepository;
        this.orderItemsRepository = orderItemsRepository;
        this.supplierAddressesRepository = supplierAddressesRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    public Customer updateCustomer(int id, Customer updatedCustomer) {
        Customer customer = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found with id: " + id));
        customer.setFirst_name(updatedCustomer.getFirst_name());
        customer.setLast_name(updatedCustomer.getLast_name());
        customer.setPhone(updatedCustomer.getPhone());
        customer.setEmail(updatedCustomer.getEmail());
        // Add more fields as needed
        return repository.save(customer);
    }

    @Transactional
    public Customer createCustomerWithAddress(CustomerWithAddressDTO dto) {
        Customer customer = new Customer(
            dto.firstName,
            dto.lastName,
            dto.phone,
            dto.email
        );
        Customer savedCustomer = repository.save(customer);
        CustomerAddresses address = new CustomerAddresses(
            savedCustomer,
            dto.streetAddress,
            dto.postalCode,
            dto.city,
            dto.country
        );
        customerAddressesRepository.save(address);
        return savedCustomer;
    }

    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    public Customer getCustomerById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional
    public boolean deleteCustomer(int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
