package com.example.InterviewDigitalCollers.Utils.DAOs;

import com.example.InterviewDigitalCollers.models.Transaction;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TransactionDAO {

    private List<Transaction> transactionList = new ArrayList<>();

    public TransactionDAO() {
    }

    public TransactionDAO(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }




}
