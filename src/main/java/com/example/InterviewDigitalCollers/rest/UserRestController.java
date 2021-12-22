package com.example.InterviewDigitalCollers.rest;

import com.example.InterviewDigitalCollers.models.DTOs.CustomerDTO;
import com.example.InterviewDigitalCollers.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// endpoint: localhost:8080/customers?id=

@RestController
@RequestMapping("/customers")
public class UserRestController {

    @Autowired
    private CustomerService customerService;

    @GetMapping()
    public List<CustomerDTO> findById(@RequestParam String id) {
        return customerService.findById(id);
    }


}
