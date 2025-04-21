package com.infosys.customerservice.service;

import java.util.*;
import com.infosys.customerservice.entity.Customer;
import com.infosys.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service //->this makes the class as a service in class
public class CustomerService
{
    private final CustomerRepository customerRepository;

    //constructor based injection of customerRepository - customerService depends on CustomerRepository to perform CRUD operations

    @Autowired   //It Injects the CustomerRepository bean into this service class when its created
    public CustomerService(CustomerRepository customerRepository)
    {
        this.customerRepository = customerRepository;
    }

    //method to save a customer to the database
    public Customer saveCustomer(Customer customer)     //saveCustomer(Customer customer)- saves a customer object to the database. it uses the save() method of the repository to persist the customer
    {
        return customerRepository.save(customer);
        //It saves the customer to the database
    }

    //Method to get all customers from the database
    public List<Customer> getAllCustomers()        //fetches all customer records from the database using findAll() method from the repository
    {
        return customerRepository.findAll();    //Retrieves all customers from the database
    }


    //Method to get a customer by their id
    public Optional<Customer> getCustomerById(Long id)  //Fetches a specific customer by their ID using findById() from repository
    {
        return customerRepository.findById(id);    //Retrieves a customer based on their id
    }



    



}
