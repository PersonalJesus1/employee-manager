package Lessons.Employee_manager.positions;

import Lessons.Employee_manager.departments.Department;

import java.io.Serializable;
import java.math.BigDecimal;

public class HeadOfHr implements Position, Serializable {
    private static final long serialVersionUID = 1;

    @Override
    public String getName() {
        return "Head Of HR";
    }

    @Override
    public Department getDepartment() {
        return Department.HR;
    }

    @Override
    public  BigDecimal getMinSalary() {
        return new BigDecimal(800);
    }

    @Override
    public BigDecimal getMaxSalary() {
        return new BigDecimal(1700);
    }


}

