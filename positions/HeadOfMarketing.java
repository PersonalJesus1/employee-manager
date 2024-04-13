package Lessons.Employee_manager.positions;

import Lessons.Employee_manager.departments.Department;

import java.io.Serializable;
import java.math.BigDecimal;

public class HeadOfMarketing implements Position, Serializable {
    private static final long serialVersionUID = 1;
    private String title;

    public HeadOfMarketing(){
        title=getName();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String getName() {
        return "Head Of Marketing";
    }

    @Override
    public Department getDepartment() {
        return Department.MARKETING;
    }

    @Override
    public  BigDecimal getMinSalary() {
        return new BigDecimal(1000);
    }

    @Override
    public BigDecimal getMaxSalary() {
        return new BigDecimal(2000);
    }


}
