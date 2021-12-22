package com.example.InterviewDigitalCollers.services;

import com.example.InterviewDigitalCollers.models.DTOs.CustomerDTO;

import java.util.List;

public interface CustomerService {
    List<CustomerDTO> findById(String id);
}
