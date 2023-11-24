package com.bouali.banking.Controllers;


import com.bouali.banking.dto.TransactionSumDetails;
import com.bouali.banking.services.StatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/statistics")
@RequiredArgsConstructor
public class StatisticsController {

    private final StatisticsService service;

    @GetMapping("/sum-by-date/{user-id}")
    public ResponseEntity<List<TransactionSumDetails>> findSumTractionsByDate(
            @PathVariable("user-id") Integer userId,
            @RequestParam("start-date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
            @RequestParam("end-date")  @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate
    ){
        return ResponseEntity.ok(service.findSumTractionsByDate(startDate, endDate, userId));
    }


    @GetMapping("/account-balance/{user-id}")
    public ResponseEntity<BigDecimal> getAccountBalance(
            @PathVariable("user-id") Integer userId
    ){
        return ResponseEntity.ok(service.getAccountBalance(userId));
    }

    @GetMapping("/highest-transfer/{user-id}")
    public ResponseEntity<BigDecimal> highestTransfer(
            @PathVariable("user-id") Integer userId
    ){
        return ResponseEntity.ok(service.highestTransfer(userId));
    }

    @GetMapping("/highest-deposit/{user-id}")
    public ResponseEntity<BigDecimal> highestDeposit(
            @PathVariable("user-id") Integer userId
    ){
        return ResponseEntity.ok(service.highestDeposit(userId));
    }

}
