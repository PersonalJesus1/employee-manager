package Lessons.Employee_manager;

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
    public BigDecimal getMinSalary() {
        return new BigDecimal(2500);
    }

    @Override
    public BigDecimal getMaxSalary() {
        return new BigDecimal(7000);
    }
}
