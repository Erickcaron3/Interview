package com.example.InterviewDigitalCollers.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

//lombok voluntary not used in the entire project

public class Transaction {

    private Integer transaction_id;
    private BigDecimal transaction_amount;
    private String customer_first_name;
    private Integer customer_id;
    private String customer_last_name;
    private LocalDateTime transaction_date;

    public Transaction() {

    }

    public Transaction(Integer transaction_id, BigDecimal transaction_amount, String customer_first_name, Integer customer_id, String customer_last_name, LocalDateTime transaction_date) {
        this.transaction_id = transaction_id;
        this.transaction_amount = transaction_amount;
        this.customer_first_name = customer_first_name;
        this.customer_id = customer_id;
        this.customer_last_name = customer_last_name;
        this.transaction_date = transaction_date;
    }

    public Integer getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(Integer transaction_id) {
        this.transaction_id = transaction_id;
    }

    public BigDecimal getTransaction_amount() {
        return transaction_amount;
    }

    public void setTransaction_amount(BigDecimal transaction_amount) {
        this.transaction_amount = transaction_amount;
    }

    public String getCustomer_first_name() {
        return customer_first_name;
    }

    public void setCustomer_first_name(String customer_first_name) {
        this.customer_first_name = customer_first_name;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_last_name() {
        return customer_last_name;
    }

    public void setCustomer_last_name(String customer_last_name) {
        this.customer_last_name = customer_last_name;
    }

    public LocalDateTime getTransaction_date() {
        return transaction_date;
    }

    public void setTransaction_date(LocalDateTime transaction_date) {
        this.transaction_date = transaction_date;
    }

}
