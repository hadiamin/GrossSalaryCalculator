package com.gra.grosssalarycalculator.controller;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SalaryRequest {
    private double desiredNetSalary;
    private double allowances;
}
