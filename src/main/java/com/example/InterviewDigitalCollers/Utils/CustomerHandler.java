package com.example.InterviewDigitalCollers.Utils;

import com.example.InterviewDigitalCollers.Utils.DAOs.TransactionDAO;
import com.example.InterviewDigitalCollers.models.DTOs.CustomerDTO;
import com.example.InterviewDigitalCollers.models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class CustomerHandler {


    @Autowired
    private TransactionDAO transactionDAO;

    @Autowired
    private TransactionFeeCalculator transactionFeeCalculator;


    public List<CustomerDTO> filterRequest(String id) {

        if (id.trim().toUpperCase().equals("ALL")) {
            return findAllCustomers();
        }
        if (id.trim().contains(",")) {
            return findByMultipleIds(id);
        }

        if (id.trim().matches("[0-9]")) {
            if (!isIdCorrect(Integer.valueOf(id))) {
                return findAllCustomers();
            }
            return findById(Integer.valueOf(id));
        }

        return findAllCustomers();
    }

    private List<CustomerDTO> findAllCustomers() {
        return findAllIds().stream()
                .map(this::createCustomer)
                .collect(Collectors.toList());

    }

    private List<CustomerDTO> findById(Integer id) {
        List<CustomerDTO> outputtedList = new ArrayList<>();
        outputtedList.add(createCustomer(id));
        return outputtedList;
    }

    private List<CustomerDTO> findByMultipleIds(String id) {
        if (findCustomerByFirstIdCorrect(id).isEmpty()) {
            return findAllCustomers();
        }
        List<CustomerDTO> outputtedList = new ArrayList<>();
        outputtedList.add(findCustomerByFirstIdCorrect(id).get());
        return outputtedList;

    }

    private Optional<CustomerDTO> findCustomerByFirstIdCorrect(String id) {
        return readIdsFromParameter(id).stream()
                .filter(this::isIdCorrect)
                .map(this::createCustomer)
                .findFirst();
    }

    private List<Integer> readIdsFromParameter(String id) {
        return Arrays.stream(id.split(","))
                .map(this::parseStringToInteger)
                .collect(Collectors.toList());
    }

    private Boolean isIdCorrect(Integer id) {
        return findAllIds().stream().anyMatch(i -> i.equals(id));
    }


    public List<Integer> findAllIds() {
        return transactionDAO.getTransactionList().stream()
                .map(Transaction::getCustomer_id)
                .distinct()
                .collect(Collectors.toList());
    }

    public CustomerDTO createCustomer(Integer id) {
        Transaction transactionFromDAO = findTransactionFromDAO(id);
        return new CustomerDTO(
                findFirstName(transactionFromDAO),
                findLastName(transactionFromDAO),
                id,
                findTotalValueOfTransactionsById(id),
                findTransactionsFeeValue(id),
                findLastTransactionById(id)
        );
    }

    private String findFirstName(Transaction transaction) {
        return transaction.getCustomer_first_name();
    }

    private String findLastName(Transaction transaction) {
        return transaction.getCustomer_last_name();
    }

    private BigDecimal findTotalValueOfTransactionsById(Integer id) {
        return transactionDAO.getTransactionList().stream()
                .filter(t -> t.getCustomer_id().equals(id))
                .map(t -> t.getTransaction_amount())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal findTransactionsFeeValue(Integer id) {
        BigDecimal total = findTotalValueOfTransactionsById(id);
        return transactionFeeCalculator.calculate(total);
    }

    private LocalDateTime findLastTransactionById(Integer id) {
        return transactionDAO.getTransactionList().stream()
                .filter( t-> t.getCustomer_id().equals(id))
                .map( t-> t.getTransaction_date())
                .sorted(Comparator.reverseOrder())
                .findFirst().get();

    }


    private Transaction findTransactionFromDAO(Integer id) {
        return transactionDAO.getTransactionList().stream()
                .filter(t -> t.getCustomer_id().equals(id))
                .findFirst().get();
    }


    private Integer parseStringToInteger(String input) {
        return Integer.valueOf(input);
    }

}
