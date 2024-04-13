package Lessons.Employee_manager;

import Lessons.Employee_manager.positions.Position;
import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Employee implements Serializable  {
    private String name;
    private String surname;
    private final int ID;
    private Position jobTitle;
    private BigDecimal salary;
    private LocalDate lastChangeDate;

    public Employee(String name, String surname, int ID, Position jobTitle, BigDecimal salary, LocalDate lastChangeDate) throws IOException {
        this.name = name;
        this.surname = surname;
        this.ID = ID;
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.lastChangeDate = lastChangeDate;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getID() {
        return ID;
    }

    public Position getJobTitle() {
        return jobTitle;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public LocalDate getLastChangeDate() {
        return lastChangeDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setJobTitle(Position jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public void setLastChangeDate(LocalDate lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }




    @Override
    public String toString() {
        return "Employee{ " +
                "name: " + name +
                " surname: " + surname +
                ", id: " + ID +
                ", job_title: " + jobTitle.getName() +
                ", salary: " + salary +
                ", lastChangeDate " + lastChangeDate +
                " }";
    }
}
