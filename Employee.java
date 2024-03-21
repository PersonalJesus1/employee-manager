package Lessons.Employee_manager;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Employee {
    private String name;
    private String surname;
    private final int ID;
    private Position job_title;
    private BigDecimal salary;
    private LocalDate lastChangeDate;

    public Employee(String name, String surname, int ID, Position job_title, BigDecimal salary, LocalDate lastChangeDate) {
        this.name = name;
        this.surname = surname;
        this.ID  = ID;
        this.job_title = job_title;
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

    public Position getJob_title() {
        return job_title;
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

    public void setJob_title(Position job_title) {
        this.job_title = job_title;
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
                ", job_title: " + job_title.getName() +
                ", salary: " + salary +
                ", lastChangeDate " + lastChangeDate +
                " }";
    }
}
