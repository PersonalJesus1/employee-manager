package Lessons.Employee_manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

public class EmployeeManager {
    public static void main(String[] args) throws IOException {
        ArrayList<Employee> employees = new ArrayList<>();
        Employee employee1 = new Employee("Adam", "Smith", 1, new HeadOfMarketing(), new BigDecimal(1500), LocalDate.of(2023, 5, 15));
        Employee employee2 = new Employee("Joey", "Jordison", 2, new MiddleDeveloper(), new BigDecimal(1300), LocalDate.of(2022, 4, 20));
        Employee employee3 = new Employee("Corey", "Taylor", 3, new SeniorManager(), new BigDecimal(1000), LocalDate.of(2022, 6, 21));
        Employee employee4 = new Employee("Jim", "Root", 4, new TeamLead(), new BigDecimal(4500), LocalDate.of(2020, 3, 5));
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String choice;
            try {
                do {
                    System.out.println("Введите номер действия (1 или 2):  1. распечатать список 2. выход из программы ");
                    choice = reader.readLine();
                    if (Integer.parseInt(choice) == 1) {
                        for (Employee e : employees) {
                            System.out.println(e);
                        }
                    }
                }
                while (Integer.parseInt(choice) != 2);
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели неверное число/не число. ");
            }
        }
    }
}


