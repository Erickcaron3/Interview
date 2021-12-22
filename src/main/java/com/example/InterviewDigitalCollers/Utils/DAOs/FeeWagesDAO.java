package com.example.InterviewDigitalCollers.Utils.DAOs;

import com.example.InterviewDigitalCollers.models.FeeWage;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FeeWagesDAO {
    //could have been exported from file csv directly to Map instead of List - Erick CARON
    private List<FeeWage> feeWageList = new ArrayList<>();

    public FeeWagesDAO() {
    }

    public FeeWagesDAO(List<FeeWage> feeWageList) {
        this.feeWageList = feeWageList;
    }

    public List<FeeWage> getFeeWageList() {
        return feeWageList;
    }

    public void setFeeWageList(List<FeeWage> feeWageList) {
        this.feeWageList = feeWageList;
    }
}
