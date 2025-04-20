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



    //Method to update an existing customer
    public Customer updateCustomer(Long id, Customer updatedCustomer)
    {
        Customer existingCustomer = customerRepository.findById(id);

        //if customer not found, throw an exception(you can replace with your own custom exception handling)
        if(existingCustomer == null)
        {
            throw new RuntimeException("customer not found with id: "+id);
        }

        //update the existing customer fields

        existingCustomer.setName(updatedCustomer.getName());
        existingCustomer.setEmail(updatedCustomer.getEmail());
        existingCustomer.setPhone(updatedCustomer.getPhone());
        existingCustomer.setAddress(updatedCustomer.getAddress());

        //save the updated customer

        return customerRepository.save(existingCustomer);
    }



}
