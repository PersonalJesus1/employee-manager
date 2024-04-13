package Lessons.Employee_manager.positions;

import Lessons.Employee_manager.departments.Department;

import java.io.Serializable;
import java.math.BigDecimal;

public  interface Position extends Serializable {
    String getName();

    Department getDepartment();

     BigDecimal getMinSalary();

    BigDecimal getMaxSalary();

    default boolean validateSalary(int newSalary){

        return (getMinSalary().intValue()) <= newSalary && getMaxSalary().intValue() >= newSalary;
    }



}


