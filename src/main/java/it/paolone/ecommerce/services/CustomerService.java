package it.paolone.ecommerce.services;
import it.paolone.ecommerce.entities.Customer;
import it.paolone.ecommerce.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public Customer getCustomerById(Long query){
        Optional<Customer> fetchedCustomer = customerRepository.findById(query);
        return fetchedCustomer.orElse(null);
    }

    public List<Customer> getAllCustomers(){
        List<Customer> fetchedCustomers = customerRepository.findAll();
        return fetchedCustomers;
    }

    public Customer saveCustomer(Customer data){
        return customerRepository.save(data);
    }

}
