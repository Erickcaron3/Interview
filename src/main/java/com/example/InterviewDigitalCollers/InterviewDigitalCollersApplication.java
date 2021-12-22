package com.example.InterviewDigitalCollers;

import com.example.InterviewDigitalCollers.Utils.DAOs.FeeWagesDAO;
import com.example.InterviewDigitalCollers.Utils.FileReader;
import com.example.InterviewDigitalCollers.Utils.DAOs.TransactionDAO;
import com.example.InterviewDigitalCollers.Utils.StaticContextAccessor;
import com.example.InterviewDigitalCollers.models.FeeWage;
import com.example.InterviewDigitalCollers.models.Transaction;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Collections;

@SpringBootApplication
public class InterviewDigitalCollersApplication {

    @Autowired
    private ApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(InterviewDigitalCollersApplication.class, args);
        FileReader fileReader = new FileReader();

        TransactionDAO transactionDAO = StaticContextAccessor.getBean(TransactionDAO.class);
        transactionDAO.setTransactionList(fileReader.readAllTransactions("transactions.csv"));

        FeeWagesDAO feeWagesDAO = StaticContextAccessor.getBean(FeeWagesDAO.class);
        feeWagesDAO.setFeeWageList(fileReader.readAllFeeWages("fee_wages.csv"));

    }



}




