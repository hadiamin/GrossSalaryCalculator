package com.gra.grosssalarycalculator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalaryDetails {
    private Long salaryId;
    private double grossSalary;
    private double basicSalary;
    private double totalPayeTax;
    private double employeePensionContribution;
    private double employerPensionContribution;
}
