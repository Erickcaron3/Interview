package com.example.InterviewDigitalCollers.models.DTOs;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CustomerDTO {

    private String firstName;
    private String lastName;
    private Integer customerId;
    private BigDecimal totalValueOfTransactions;
    private BigDecimal transactionsFeeValue;
    private LocalDateTime lastTransactionDate;


    public CustomerDTO() {
    }

    public CustomerDTO(String firstName, String lastName, Integer customerId, BigDecimal totalValueOfTransactions, BigDecimal transactionsFeeValue, LocalDateTime lastTransactionDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.customerId = customerId;
        this.totalValueOfTransactions = totalValueOfTransactions;
        this.transactionsFeeValue = transactionsFeeValue;
        this.lastTransactionDate = lastTransactionDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }


    public BigDecimal getTotalValueOfTransactions() {
        return totalValueOfTransactions;
    }

    public void setTotalValueOfTransactions(BigDecimal totalValueOfTransactions) {
        this.totalValueOfTransactions = totalValueOfTransactions;
    }

    public BigDecimal getTransactionsFeeValue() {
        return transactionsFeeValue;
    }

    public void setTransactionsFeeValue(BigDecimal transactionsFeeValue) {
        this.transactionsFeeValue = transactionsFeeValue;
    }

    public LocalDateTime getLastTransactionDate() {
        return lastTransactionDate;
    }

    public void setLastTransactionDate(LocalDateTime lastTransactionDate) {
        this.lastTransactionDate = lastTransactionDate;
    }

}
