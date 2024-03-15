package Lessons.Employee_manager;

import java.math.BigDecimal;

public class JuniorDeveloper implements Position {

    @Override
    public String getName() {
        return "JuniorDeveloper";
    }

    @Override
    public Department getDepartment() {
        return Department.DEVELOPMENT;
    }

    @Override
    public BigDecimal getMinSalary() {
        return new BigDecimal(400);
    }

    @Override
    public BigDecimal getMaxSalary() {
        return new BigDecimal(1000);
    }
}
