package Lessons.Employee_manager;

import Lessons.Employee_manager.positions.*;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import static Lessons.Employee_manager.EmployeeManager.READER;

public class Accounting implements Serializable {
    public static void changeSalary(Employee employee, int newSalary) throws IOException {

        // The name of title job
        Position positionOfEmployee = employee.getJobTitle();
        boolean isSalaryChanged = false;
        do {
            try {

                    if (positionOfEmployee.validateSalary(newSalary)) {
                        employee.setSalary(new BigDecimal(newSalary));
                        System.out.println("Information has been accepted.");
                        isSalaryChanged = true;
                    } else {
                        System.out.println("You have written wrong unacceptable information. Try again");
                        newSalary = Integer.parseInt(READER.readLine());
                    }

            } catch (NumberFormatException e) {
                System.out.println("You have written not a digit.");
            }
        } while (!isSalaryChanged);
        employee.setLastChangeDate(LocalDate.now());

    }

    public static int chooseSalary(Position position) throws IOException {
        boolean isRightSalary = false;
        int salary=0;
        do {
            System.out.println("Write information about salary: " + "\n" +
                    "For reference: Marketing:  1. Trainee (from 300 to 600), 2. Specialist (from 500 to 1200), 3. Head of marketing (from 1000 to 2000)" + "\n" +
                    "HR: 4. Manager (from 400 to 800), 5. Senior manager (from 700 to 1100), 6. Head of HR (from 800 to 1700)" + "\n" +
                    "Development: 7. Junior developer (from 400 to 1000), 8. Middle developer (from 800 to 2000), 9. Senior developer (from 1800 to 4000), 10. Team lead (from 2500 to 7000)");
            try {
                salary = Integer.parseInt(READER.readLine());

                if (position.validateSalary(salary)) {
                    System.out.println("Information has been accepted.");
                    isRightSalary = true;

                } else System.out.println("You have written wrong unacceptable information. ");

            } catch (NumberFormatException e) {
                System.out.println("You have written not a digit. ");
            }

        } while (!isRightSalary);
        return salary;
    }
}
