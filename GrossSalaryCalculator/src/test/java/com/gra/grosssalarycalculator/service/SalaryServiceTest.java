package com.gra.grosssalarycalculator.service;

import com.gra.grosssalarycalculator.model.SalaryDetails;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SalaryServiceTest {
    @Autowired
    private SalaryService salaryService;

    @Test
    public void testCalculateGrossSalary() {
        double netSalary = 2000;
        double allowances = 500;

        SalaryDetails response = salaryService.calculateGrossSalary(netSalary, allowances);

        assertNotNull(response);
        assertTrue(response.getGrossSalary() > netSalary);
        assertTrue(response.getBasicSalary() < response.getGrossSalary());
        assertTrue(response.getTotalPayeTax() > 0);
        assertTrue(response.getEmployeePensionContribution() > 0);
        assertTrue(response.getEmployerPensionContribution() > 0);
    }
}