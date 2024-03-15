package Lessons.Employee_manager;

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
    public BigDecimal getMinSalary() {
        return new BigDecimal(500);
    }

    @Override
    public BigDecimal getMaxSalary() {
        return new BigDecimal(1200);
    }
}
