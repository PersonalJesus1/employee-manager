package Lessons.Employee_manager.positions;

import Lessons.Employee_manager.departments.Department;

import java.io.Serializable;
import java.math.BigDecimal;

public class MiddleDeveloper implements Position, Serializable {
    private static final long serialVersionUID = 1;

    @Override
    public String getName() {
        return "Middle Developer";
    }

    @Override
    public Department getDepartment() {
        return Department.DEVELOPMENT;
    }

    @Override
    public BigDecimal getMinSalary() {
        return new BigDecimal(800);
    }




    @Override
    public BigDecimal getMaxSalary() {
        return new BigDecimal(2000);
    }

}
