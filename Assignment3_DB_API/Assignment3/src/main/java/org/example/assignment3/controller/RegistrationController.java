package org.example.assignment3.controller;
import org.example.assignment3.model.Customer;
import org.example.assignment3.repository.CustomerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.List;

@RestController
public class RegistrationController {
    private final CustomerRepository customerRepository;

    public RegistrationController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostMapping(value = "/customer/new")
    public ResponseEntity<Customer> createUser(@RequestBody Customer customer){
        customerRepository.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @GetMapping(value = "/customer/list")
    public ResponseEntity<List<Customer>> listuser(){
        List<Customer> customers = customerRepository.findAll();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
}
