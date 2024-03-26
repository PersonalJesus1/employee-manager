package Lessons.Employee_manager.positions;

import Lessons.Employee_manager.departments.Department;

import java.math.BigDecimal;

public class Specialist implements Position {

    @Override
    public String getName() {
        return "Specialist";
    }

    @Override
    public Department getDepartment() {
        return Department.MARKETING;
    }

    @Override
    public  BigDecimal getMinSalary() {
        return new BigDecimal(500);
    }

    @Override
    public BigDecimal getMaxSalary() {
        return new BigDecimal(1200);
    }

    @Override
    public boolean validateSalary(int newSalary) {
        return newSalary >= 500 && newSalary <= 1200;
    }
}
