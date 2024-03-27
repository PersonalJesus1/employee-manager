package Lessons.Employee_manager.positions;

import Lessons.Employee_manager.departments.Department;

import java.math.BigDecimal;

public class SeniorDeveloper implements Position {

    @Override
    public String getName() {
        return "Senior Developer";
    }

    @Override
    public Department getDepartment() {
        return Department.DEVELOPMENT;
    }

    @Override
    public  BigDecimal getMinSalary() {
        return new BigDecimal(1800);
    }

    @Override
    public BigDecimal getMaxSalary() {
        return new BigDecimal(4000);
    }

    
}
