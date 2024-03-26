package Lessons.Employee_manager.positions;

import Lessons.Employee_manager.departments.Department;

import java.math.BigDecimal;

public class Trainee implements Position {

    @Override
    public String getName() {
        return "Trainee";
    }

    @Override
    public Department getDepartment() {
        return Department.MARKETING;
    }

    @Override
    public  BigDecimal getMinSalary() {
        return new BigDecimal(300);
    }

    @Override
    public BigDecimal getMaxSalary() {
        return new BigDecimal(600);
    }

    @Override
    public boolean validateSalary(int newSalary) {
        return newSalary >= 300 && newSalary <= 600;
    }
}
