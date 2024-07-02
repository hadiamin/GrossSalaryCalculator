package com.gra.grosssalarycalculator.controller;

import com.gra.grosssalarycalculator.model.SalaryDetails;
import com.gra.grosssalarycalculator.service.SalaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/salary")
@RequiredArgsConstructor
public class SalaryController {

    private final SalaryService salaryService;

    @PostMapping
    @ResponseBody
    public SalaryDetails calculateGrossSalary(@RequestBody SalaryRequest salaryRequest) {
        return salaryService.calculateGrossSalary(salaryRequest.getDesiredNetSalary(), salaryRequest.getAllowances());
    }
}
