package Lessons.Employee_manager;

import java.math.BigDecimal;

public class HeadOfHr implements Position {


    @Override
    public String getName() {
        return "Head Of HR";
    }

    @Override
    public Department getDepartment() {
        return Department.HR;
    }

    @Override
    public BigDecimal getMinSalary() {
        return new BigDecimal(800);
    }

    @Override
    public BigDecimal getMaxSalary() {
        return new BigDecimal(1700);
    }
}

