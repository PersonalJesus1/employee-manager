package Lessons.Employee_manager.positions;

import Lessons.Employee_manager.departments.Department;

import java.io.Serializable;
import java.math.BigDecimal;

public class Specialist implements Position, Serializable {
    private static final long serialVersionUID = 1;

    @Override
    public String getName() {
        return "Specialist";
    }

    @Override
    public Department getDepartment() {
        return Department.MARKETING;
    }

    @Override
    public  BigDecimal getMinSalary() {
        return new BigDecimal(500);
    }

    @Override
    public BigDecimal getMaxSalary() {
        return new BigDecimal(1200);
    }


}
