package Lessons.Employee_manager;

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
    public BigDecimal getMinSalary() {
        return new BigDecimal(300);
    }

    @Override
    public BigDecimal getMaxSalary() {
        return new BigDecimal(600);
    }
}
