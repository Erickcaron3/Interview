package com.example.InterviewDigitalCollers.services.impl;

import com.example.InterviewDigitalCollers.Utils.CustomerHandler;
import com.example.InterviewDigitalCollers.models.DTOs.CustomerDTO;
import com.example.InterviewDigitalCollers.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerHandler customerHandler;

    public List<CustomerDTO> findById(String id) {
        return customerHandler.filterRequest(id);
    }


}
