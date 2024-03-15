package Lessons.Employee_manager;

import java.math.BigDecimal;

public class SeniorManager implements Position {

    @Override
    public String getName() {
        return "Senior Manager";
    }

    @Override
    public Department getDepartment() {
        return Department.HR;
    }

    @Override
    public BigDecimal getMinSalary() {
        return new BigDecimal(700);
    }

    @Override
    public BigDecimal getMaxSalary() {
        return new BigDecimal(1100);
    }
}
