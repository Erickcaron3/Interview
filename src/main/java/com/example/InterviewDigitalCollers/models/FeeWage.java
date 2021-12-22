package com.example.InterviewDigitalCollers.models;

public class FeeWage {

    private Integer transaction_value_fee;
    private Double fee_percentage_of_transaction_value;

    public FeeWage() {
    }

    public FeeWage(Integer transaction_value_fee, Double fee_percentage_of_transaction_value) {
        this.transaction_value_fee = transaction_value_fee;
        this.fee_percentage_of_transaction_value = fee_percentage_of_transaction_value;
    }

    public Integer getTransaction_value_fee() {
        return transaction_value_fee;
    }

    public void setTransaction_value_fee(Integer transaction_value_fee) {
        this.transaction_value_fee = transaction_value_fee;
    }

    public Double getFee_percentage_of_transaction_value() {
        return fee_percentage_of_transaction_value;
    }

    public void setFee_percentage_of_transaction_value(Double fee_percentage_of_transaction_value) {
        this.fee_percentage_of_transaction_value = fee_percentage_of_transaction_value;
    }

}
