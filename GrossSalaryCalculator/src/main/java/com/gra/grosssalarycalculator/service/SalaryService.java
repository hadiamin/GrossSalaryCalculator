package com.gra.grosssalarycalculator.service;

import com.gra.grosssalarycalculator.model.SalaryDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SalaryService {
    ArrayList<SalaryDetails> salaryDetails = new ArrayList<>();

    public SalaryDetails calculateGrossSalary(double netSalary, double allowances) {
        double grossSalary = calculateGrossFromNet(netSalary, allowances);
        double basicSalary = grossSalary - allowances;
        double totalPayeTax = calculatePayeTax(basicSalary + allowances);
        double employeePensionContribution = calculateEmployeePensionContribution(grossSalary);
        double employerPensionContribution = calculateEmployerPensionContribution(grossSalary);

        SalaryDetails response = new SalaryDetails();
        response.setGrossSalary(grossSalary);
        response.setBasicSalary(basicSalary);
        response.setTotalPayeTax(totalPayeTax);
        response.setEmployeePensionContribution(employeePensionContribution);
        response.setEmployerPensionContribution(employerPensionContribution);

        return response;
    }

    private double calculateGrossFromNet(double netSalary, double allowances) {

        return netSalary + allowances;
    }

    private double calculatePayeTax(double taxableIncome) {

        double payeTax = 0;

        if (taxableIncome <= 490) {
            payeTax = 0;
        } else if (taxableIncome <= 600) {
            payeTax = (taxableIncome - 490) * 0.055;
        } else if (taxableIncome <= 730) {
            payeTax = (600 - 490) * 0.055 + (taxableIncome - 600) * 0.10;
        } else if (taxableIncome <= 3896.67) {
            payeTax = (600 - 490) * 0.055 + (730 - 600) * 0.10 + (taxableIncome - 730) * 0.175;
        } else if (taxableIncome <= 19896.67) {
            payeTax = (600 - 490) * 0.055 + (730 - 600) * 0.10 + (3896.67 - 730) * 0.175 + (taxableIncome - 3896.67) * 0.25;
        } else if (taxableIncome <= 50416.67) {
            payeTax = (600 - 490) * 0.055 + (730 - 600) * 0.10 + (3896.67 - 730) * 0.175 + (19896.67 - 3896.67) * 0.25 + (taxableIncome - 19896.67) * 0.30;
        } else {
            payeTax = (600 - 490) * 0.055 + (730 - 600) * 0.10 + (3896.67 - 730) * 0.175 + (19896.67 - 3896.67) * 0.25 + (50416.67 - 19896.67) * 0.30 + (taxableIncome - 50416.67) * 0.35;
        }
        return payeTax;
    }

    private double calculateEmployeePensionContribution(double grossSalary) {
        double tier2Contribution = grossSalary * 0.055;
        double tier3Contribution = grossSalary * 0.05;
        return tier2Contribution + tier3Contribution;
    }

    private double calculateEmployerPensionContribution(double grossSalary) {
        double tier1Contribution = grossSalary * 0.13;
        double tier3Contribution = grossSalary * 0.05;
        return tier1Contribution + tier3Contribution;
    }
}
