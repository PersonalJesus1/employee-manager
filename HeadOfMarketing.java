package Lessons.Employee_manager;

import java.math.BigDecimal;

public class HeadOfMarketing implements Position {
    String title;

    HeadOfMarketing(){
        title=getName();
    }

    @Override
    public String getName() {
        return "HeadOfMarketing";
    }

    @Override
    public Department getDepartment() {
        return Department.MARKETING;
    }

    @Override
    public BigDecimal getMinSalary() {
        return new BigDecimal(1000);
    }

    @Override
    public BigDecimal getMaxSalary() {
        return new BigDecimal(2000);
    }
}
