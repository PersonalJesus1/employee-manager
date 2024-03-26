package Lessons.Employee_manager.positions;

import Lessons.Employee_manager.departments.Department;

import java.math.BigDecimal;

public class Manager implements Position {

    @Override
    public String getName() {
        return "Manager";
    }

    @Override
    public Department getDepartment() {
        return Department.HR;
    }

    @Override
    public  BigDecimal getMinSalary() {
        return new BigDecimal(400);
    }

    @Override
    public BigDecimal getMaxSalary() {
        return new BigDecimal(800);
    }

    @Override
    public boolean validateSalary(int newSalary) {
        return newSalary>=400 && newSalary <= 800;
    }
}
