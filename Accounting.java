package Lessons.Employee_manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Accounting {
    public static void changeSalary(Employee employee, int newSalary) throws IOException {
        BufferedReader reader = new BufferedReader((new InputStreamReader(System.in)));
        // The name of title job
        String  nameJobTitle = employee.getJob_title().getName();
        boolean isSalaryChanged = false;
        do {
            try {
                if (new Trainee().getName().equals(nameJobTitle)) {
                    if (newSalary >= 300 && newSalary <= 600) {
                        employee.setSalary(new BigDecimal(newSalary));
                        System.out.println("Information has been accepted.");
                        isSalaryChanged = true;
                    } else {
                        System.out.println("You have written wrong unacceptable information. Try again");
                        newSalary = Integer.parseInt(reader.readLine());
                    }
                } else if (new Specialist().getName().equals(nameJobTitle)) {
                    if (newSalary >= 500 && newSalary <= 1200) {
                        employee.setSalary(new BigDecimal(newSalary));
                        System.out.println("Information has been accepted.");
                        isSalaryChanged = true;
                    } else {
                        System.out.println("You have written wrong unacceptable information. Try again");
                        newSalary = Integer.parseInt(reader.readLine());
                    }
                } else if (new HeadOfMarketing().getName().equals(nameJobTitle)) {
                    if (newSalary >= 1000 && newSalary <= 2000) {
                        employee.setSalary(new BigDecimal(newSalary));
                        System.out.println("Information has been accepted.");
                        isSalaryChanged = true;
                    } else {
                        System.out.println("You have written wrong unacceptable information. Try again");
                        newSalary = Integer.parseInt(reader.readLine());
                    }
                } else if (new Manager().getName().equals(nameJobTitle)) {
                    if (newSalary >= 400 && newSalary <= 800) {
                        employee.setSalary(new BigDecimal(newSalary));
                        System.out.println("Information has been accepted.");
                        isSalaryChanged = true;
                    } else {
                        System.out.println("You have written wrong unacceptable information. Try again");
                        newSalary = Integer.parseInt(reader.readLine());
                    }
                } else if (new SeniorManager().getName().equals(nameJobTitle)) {
                    if (newSalary >= 700 && newSalary <= 1100) {
                        employee.setSalary(new BigDecimal(newSalary));
                        System.out.println("Information has been accepted.");
                        isSalaryChanged = true;
                    } else {
                        System.out.println("You have written wrong unacceptable information. Try again");
                        newSalary = Integer.parseInt(reader.readLine());
                    }
                } else if (new HeadOfHr().getName().equals(nameJobTitle)) {
                    if (newSalary >= 800 && newSalary <= 1700) {
                        employee.setSalary(new BigDecimal(newSalary));
                        System.out.println("Information has been accepted.");
                        isSalaryChanged = true;
                    } else {
                        System.out.println("You have written wrong unacceptable information. Try again");
                        newSalary = Integer.parseInt(reader.readLine());
                    }
                } else if (new JuniorDeveloper().getName().equals(nameJobTitle)) {
                    if (newSalary >= 400 && newSalary <= 1000) {
                        employee.setSalary(new BigDecimal(newSalary));
                        System.out.println("Information has been accepted.");
                        isSalaryChanged = true;
                    } else {
                        System.out.println("You have written wrong unacceptable information. Try again");
                        newSalary = Integer.parseInt(reader.readLine());
                    }
                } else if (new MiddleDeveloper().getName().equals(nameJobTitle)) {
                    if (newSalary >= 800 && newSalary <= 2000) {
                        employee.setSalary(new BigDecimal(newSalary));
                        System.out.println("Information has been accepted.");
                        isSalaryChanged = true;
                    } else {
                        System.out.println("You have written wrong unacceptable information. Try again");
                        newSalary = Integer.parseInt(reader.readLine());
                    }
                } else if (new SeniorDeveloper().getName().equals(nameJobTitle)) {
                    if (newSalary >= 1800 && newSalary <= 4000) {
                        employee.setSalary(new BigDecimal(newSalary));
                        System.out.println("Information has been accepted.");
                        isSalaryChanged = true;
                    } else {
                        System.out.println("You have written wrong unacceptable information. Try again");
                        newSalary = Integer.parseInt(reader.readLine());
                    }
                } else if (new TeamLead().getName().equals(nameJobTitle)) {
                    if (newSalary >= 2500 && newSalary <= 7000) {
                        employee.setSalary(new BigDecimal(newSalary));
                        System.out.println("Information has been accepted.");
                        isSalaryChanged = true;
                    } else {
                        System.out.println("You have written wrong unacceptable information. Try again");
                        newSalary = Integer.parseInt(reader.readLine());
                    }
                }

            } catch (NumberFormatException e) {
                System.out.println("You have written not a digit.");
            }
        } while (!isSalaryChanged);
        employee.setLastChangeDate(LocalDate.now());

    }

    public static int chooseSalary(int numberOfJob) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int salary = 0;
        boolean isRightSalary = false;

        do {
            System.out.println("Write information about salary: " + "\n" +
                    "For reference: Marketing:  1. Trainee (from 300 to 600), 2. Specialist (from 500 to 1200), 3. Head of marketing (from 1000 to 2000)" + "\n" +
                    "HR: 4. Manager (from 400 to 800), 5. Senior manager (from 700 to 1100), 6. Head of HR (from 800 to 1700)" + "\n" +
                    "Development: 7. Junior developer (from 400 to 1000), 8. Middle developer (from 800 to 2000), 9. Senior developer (from 1800 to 4000), 10. Team lead (from 2500 to 7000)");
            try {
                salary = Integer.parseInt(reader.readLine());

                switch (numberOfJob) {
                    case 1: {
                        if (salary >= 300 && salary <= 600) {
                            System.out.println("Information has been accepted.");
                            isRightSalary = true;

                        } else System.out.println("You have written wrong unacceptable information. ");
                        break;
                    }
                    case 2: {
                        if (salary >= 500 && salary <= 1200) {
                            System.out.println("Information has been accepted.");
                            isRightSalary = true;
                        } else System.out.println("You have written wrong unacceptable information. ");
                        break;
                    }
                    case 3: {
                        if (salary >= 1000 && salary <= 2000) {
                            System.out.println("Information has been accepted.");
                            isRightSalary = true;
                        } else System.out.println("You have written wrong unacceptable information. ");
                        break;
                    }
                    case 4: {
                        if (salary >= 400 && salary <= 800) {
                            System.out.println("Information has been accepted.");
                            isRightSalary = true;
                        } else System.out.println("You have written wrong unacceptable information. ");
                        break;
                    }
                    case 5: {
                        if (salary >= 700 && salary <= 1100) {
                            System.out.println("Information has been accepted.");
                            isRightSalary = true;
                        } else System.out.println("You have written wrong unacceptable information. ");
                        break;
                    }
                    case 6: {
                        if (salary >= 800 && salary <= 1700) {
                            System.out.println("Information has been accepted.");
                            isRightSalary = true;
                        } else System.out.println("You have written wrong unacceptable information. ");
                        break;
                    }
                    case 7: {
                        if (salary >= 400 && 1000 >= salary) {
                            System.out.println("Information has been accepted.");

                            isRightSalary = true;
                        } else System.out.println("You have written wrong unacceptable information. ");
                        break;
                    }
                    case 8: {
                        if (salary >= 800 && salary <= 2000) {
                            System.out.println("Information has been accepted.");
                            isRightSalary = true;
                        } else System.out.println("You have written wrong unacceptable information. ");
                        break;
                    }
                    case 9: {
                        if (salary >= 1800 && salary <= 4000) {
                            System.out.println("Information has been accepted.");
                            isRightSalary = true;
                        } else System.out.println("You have written wrong unacceptable information. ");
                        break;
                    }
                    case 10: {
                        if (salary >= 2500 && salary <= 7000) {
                            System.out.println("Information has been accepted.");
                            isRightSalary = true;
                        } else System.out.println("You have written wrong unacceptable information. ");
                        break;
                    }
                }


            } catch (NumberFormatException e) {
                System.out.println("You have written not a digit. ");
            }

        } while (!isRightSalary);
        return salary;
    }
}
