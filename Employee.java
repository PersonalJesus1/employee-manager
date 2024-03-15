package Lessons.Employee_manager;

import java.math.BigDecimal;
import java.time.LocalDate;


public class Employee {
    String name;
    String surname;
    int id;
    Position job_title;
    BigDecimal salary;
    LocalDate lastChangeDate;

    public Employee(String name, String surname, int id, Position job_title, BigDecimal salary, LocalDate lastChangeDate) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.job_title = job_title;
        this.salary = salary;
        this.lastChangeDate = lastChangeDate;
    }

    @Override
    public String toString() {
        return "Employee{ " +
                "name: " + name +
                " surname: " + surname +
                ", id: " + id +
                ", job_title: " + job_title.getName() +
                ", salary: " + salary +
                ", lastChangeDate " + lastChangeDate +
                " }";
    }
}
