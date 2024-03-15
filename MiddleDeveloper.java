package Lessons.Employee_manager;

import java.math.BigDecimal;

public class MiddleDeveloper implements Position {

    @Override
    public String getName() {
        return "Middle Developer";
    }

    @Override
    public Department getDepartment() {
        return Department.DEVELOPMENT;
    }

    @Override
    public BigDecimal getMinSalary() {
        return new BigDecimal(800);
    }

    @Override
    public BigDecimal getMaxSalary() {
        return new BigDecimal(2000);
    }
}
