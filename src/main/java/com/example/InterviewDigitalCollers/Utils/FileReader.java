package com.example.InterviewDigitalCollers.Utils;

import com.example.InterviewDigitalCollers.models.FeeWage;
import com.example.InterviewDigitalCollers.models.Transaction;
import org.springframework.stereotype.Component;

import java.io.*;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class FileReader {

    public List<FeeWage> readAllFeeWages(String fileName) {
        return parseStringsToFeeWages(readDatasFromFile(fileName));
    }

    public List<Transaction> readAllTransactions(String fileName) {
        return parseStringsToTransactions(readDatasFromFile(fileName));
    }


    private List<FeeWage> parseStringsToFeeWages(Stream<String> input) {
        Pattern pattern = Pattern.compile(",");

        return input.skip(1)
                .map(feeWAge -> {
                    String[] arrayString = pattern.split(feeWAge);
                    return new FeeWage(
                            Integer.parseInt(arrayString[0]),
                            prepareFeePourcentage(arrayString[1],arrayString[2]));
                })
                .collect(Collectors.toList());

    }

    private List<Transaction> parseStringsToTransactions(Stream<String> input) {
        //charset encoding ignored as not required in task.
        Pattern pattern = Pattern.compile(",");
        return input.skip(1)
                .map(transaction -> {
                    String[] arrayString = pattern.split(transaction);
                    return new Transaction(
                            Integer.parseInt(arrayString[0]),
                            prepareTransactionAmount(arrayString[1], arrayString[2]),
                            arrayString[3],
                            Integer.parseInt(arrayString[4]),
                            arrayString[5],
                            parseToLocateDateTime(arrayString[6]));

                })
                .collect(Collectors.toList());

    }

    private LocalDateTime parseToLocateDateTime(String inputtedString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        return LocalDateTime.parse(inputtedString, formatter);
    }

    private Stream<String> readDatasFromFile(String fileName) {

        InputStream ioStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream(fileName);

        return new BufferedReader(new InputStreamReader(ioStream)).lines();
    }


    private Path checkIfFileExisting(Path path) throws FileNotFoundException {
        if (!Files.exists(path)) {
            throw new FileNotFoundException();
        }
        return path;
    }

    private BigDecimal prepareTransactionAmount(String input1, String input2) {
        String str1 = input1.replaceAll("\"", "");
        String str2 = input2.replaceAll("\"", "");
        return new BigDecimal(str1+ "." +str2);
    }

    private Double prepareFeePourcentage(String input1, String input2){
        String str1 = input1.replaceAll("\"", "");
        String str2 = input2.replaceAll("\"", "");
        return Double.valueOf(str1 + "." + str2);
    }

}
