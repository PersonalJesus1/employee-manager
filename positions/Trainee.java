package Lessons.Employee_manager.positions;

import Lessons.Employee_manager.departments.Department;

import java.io.Serializable;
import java.math.BigDecimal;

public class Trainee implements Position, Serializable {
    private static final long serialVersionUID = 1;

    @Override
    public String getName() {
        return "Trainee";
    }

    @Override
    public Department getDepartment() {
        return Department.MARKETING;
    }

    @Override
    public  BigDecimal getMinSalary() {
        return new BigDecimal(300);
    }

    @Override
    public BigDecimal getMaxSalary() {
        return new BigDecimal(600);
    }


}
