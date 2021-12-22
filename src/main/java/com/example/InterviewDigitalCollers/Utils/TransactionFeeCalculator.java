package com.example.InterviewDigitalCollers.Utils;
import com.example.InterviewDigitalCollers.Utils.DAOs.FeeWagesDAO;
import com.example.InterviewDigitalCollers.models.FeeWage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class TransactionFeeCalculator {

    @Autowired
    private FeeWagesDAO feeWagesDAO;

    public BigDecimal calculate(BigDecimal total){
        Map<Integer, Double> feeWagesMap = parseArrayListToMap(feeWagesDAO.getFeeWageList());
        BigDecimal comission = BigDecimal.ZERO;

        Iterator<Map.Entry<Integer, Double>> iterator = feeWagesMap.entrySet().iterator();
        while(iterator.hasNext()) {

            Map.Entry<Integer, Double> keyValue = iterator.next();

            BigDecimal thresold = BigDecimal.valueOf(keyValue.getKey());

            if (total.compareTo(thresold) >= 0) {
                comission = calculateComission(total, keyValue.getValue());
                total = total.subtract(thresold);
            }
        }
        return comission.setScale(2, RoundingMode.CEILING);

    }

    private Map<Integer, Double> parseArrayListToMap(List<FeeWage> feeWageList){
        return feeWageList.stream()
                .collect(Collectors.toMap( f -> f.getTransaction_value_fee(), f->f.getFee_percentage_of_transaction_value()));
    }



    private BigDecimal calculateComission(BigDecimal total, Double percent){
        return total.multiply(BigDecimal.valueOf(percent).divide(new BigDecimal("100"), RoundingMode.CEILING));
    }

    private Map<Integer, Double> sortMapDescending(Map<Integer, Double> input){
        Map<Integer, Double> feeWagesMapSorted = new HashMap<>();
        input.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .forEachOrdered( f-> feeWagesMapSorted.put(f.getKey(), f.getValue()));
        return feeWagesMapSorted;
    }





}
