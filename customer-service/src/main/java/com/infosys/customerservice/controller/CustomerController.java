package com.infosys.customerservice.controller;

import java.util.*;
import com.infosys.customerservice.entity.Customer;
import com.infosys.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController                  //This annotation makes this class a REST controller - It indicates that this is spring MVC controller where each method will return a response directly(no need for view resolution)
@RequestMapping("/customers")    //Base URL for all endpoints in this controller - This sets the base URL for all API endpoints in this controller to /customers. Every endpoint here will start with /customers
public class CustomerController
{
    private final CustomerService customerService;

    //Constructor injection of customer service

    @Autowired
    public CustomerController(CustomerService customerService)
    {
        this.customerService = customerService;
    }

    //Endpoint to create  new customer

    @PostMapping     //HTTP POST to create a customer - used to creating a customer.This method will receive a customer object in the request body and then save it to the database
    public Customer createCustomer(@RequestBody Customer customer)
    {
        return customerService.saveCustomer(customer);    //calls the service to save the customer
    }

    //Endpoint to get all customers

    @GetMapping     //HTTP GET to retrieve all customers - Used to get all customers.This method will return a list of customers
    public List<Customer> getAllCustomers()
    {
        return customerService.getAllCustomers();     //calls the service to get all customers
    }


    //Endpoint to get a customer by ID
    @GetMapping("/{id}")      //HTTP GET to retrieve all customer by ID - Used to get a specific customer by ID. The @PathVariable annotation binds the id in the URL to the id parameter in the method
    public Optional<Customer> getCustomerById(@PathVariable Long id)
    {
        return customerService.getCustomerById(id);        //calls the service to get a customer by id
    }




}
