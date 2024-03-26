package Lessons.Employee_manager.positions;

import Lessons.Employee_manager.departments.Department;

import java.math.BigDecimal;

public class TeamLead implements Position {

    @Override
    public String getName() {
        return "Team Lead";
    }

    @Override
    public Department getDepartment() {
        return Department.DEVELOPMENT;
    }

    @Override
    public  BigDecimal getMinSalary() {
        return new BigDecimal(2500);
    }

    @Override
    public BigDecimal getMaxSalary() {
        return new BigDecimal(7000);
    }

    @Override
    public boolean validateSalary(int newSalary) {
        return newSalary >= 2500 && newSalary <= 7000;
    }
}
