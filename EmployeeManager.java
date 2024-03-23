package Lessons.Employee_manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDate;

import static Lessons.Employee_manager.Accounting.changeSalary;
import static Lessons.Employee_manager.Accounting.chooseSalary;
import static Lessons.Employee_manager.DepartmentManager.*;
import static Lessons.Employee_manager.FileManager.employees;

public class EmployeeManager {

    private final static Character[] CHARS = new Character[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', ';', '.', ':', '&', '!', '?', '*', '\'', '-', '_', '=', '+', '{', '}', '[', ']', '@', '"', '\\'};

    public static void createEmployee() throws IOException {
        String name, surname;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count;
        System.out.println("Creating information of new employee: ");

        //Write name
        do {
            System.out.println("Write name");
            name = reader.readLine();
            count = 0;
            for (int i = 0; i < name.length(); i++) {
                for (int j = 0; j < CHARS.length; j++) {
                    if (name.charAt(i) == CHARS[j]) count++;
                }
            }
            if (count > 0) System.out.println("You have written unacceptable symbols. Try again");

        } while (count > 0);

        //Write surname
        do {
            System.out.println("Write surname");
            surname = reader.readLine();
            count = 0;
            for (int i = 0; i < surname.length(); i++) {
                for (int j = 0; j < CHARS.length; j++) {
                    if (surname.charAt(i) == CHARS[j]) count++;
                }
            }
            if (count > 0) System.out.println("You have written  unacceptable symbols. Try again");

        } while (count > 0);

        //Write Job title
        int numOfChosenJob = chooseNumJobtitle();
        Position jobTitle = jobTitleOfChosenNum(numOfChosenJob);

        // Write salary
        int ChosenSalary = chooseSalary(numOfChosenJob);

        LocalDate today = LocalDate.now();
        int lastId = employees.get(employees.size() - 1).getID() + 1;
        Employee employee = new Employee(name, surname, lastId, jobTitle, new BigDecimal(ChosenSalary), today);
        employees.add(employee);

        System.out.println("Information about new employee has been created.");
    }

    public static void removeEmployee() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("The list of employees: ");
        //Print list of employees
        int count = 1;
        for (Employee e : employees) {
            System.out.println(count + " " + e);
            count++;
        }
        boolean isRightRemoveNumber = false;
        int RemoveNumber;
        do {
            System.out.println("Write ordinal number of employee from the list to delete");
            try {
                RemoveNumber = Integer.parseInt(reader.readLine());
                for (int i = 0; i < employees.size(); i++) {
                    if (RemoveNumber - 1 == i) {

                        FileManager.removeEmployee(employees.get(RemoveNumber - 1));
                        isRightRemoveNumber = true;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("You have written not a digit.");
            }
        } while (!isRightRemoveNumber);
    }


    public static void main(String[] args) throws IOException {

        Employee employee1 = new Employee("Adam", "Smith", 1, new Trainee(), new BigDecimal(400), LocalDate.of(2023, 5, 15));
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
                    System.out.println("Write the number of the next action  (1, 2, 3, 4, 5, 6 or 7): " + "\n" +
                            "1. Print the list of the employees 2. Write information about new employee 3. Delete information about employee " +"\n" +
                            "4. Change department of employee 5. Change salary of employee 6. Raise of Position 7.Demotion of Position 8. Exit");

                    choice = reader.readLine();
                    //Print the list of the employees
                    if (Integer.parseInt(choice) == 1) {
                        for (Employee e : employees) {
                            System.out.println(e);
                        }

                    }
                    // Write information about new employee
                    else if (Integer.parseInt(choice) == 2) {
                        createEmployee();                    }
                    // Delete information about employee
                    else if (Integer.parseInt(choice) == 3) {
                        removeEmployee();
                    }
                    // Change department of employee
                    else if (Integer.parseInt(choice) == 4) {
                        //Print the list of the employees with ordinal numbers
                        System.out.println("The list of employees: ");
                        int count = 1;
                        for (Employee e : employees) {
                            System.out.println(count + " " + e);
                            count++;
                        }
                      boolean isEmployeeNumber = false;
                        do {
                            System.out.println("Write ordinal number of employee from the list ");
                            try {
                                int choiceEmployee = Integer.parseInt(reader.readLine());
                                if (choiceEmployee > employees.size() || choiceEmployee < 1)
                                    System.out.println("You have written a wrong number.");
                                else {
                                    for (int i = 0; i < employees.size(); i++) {
                                        if (choiceEmployee - 1 == i) {
                                            DepartmentManager.changeDepartment(employees.get(choiceEmployee - 1));
                                            isEmployeeNumber = true;
                                            break;
                                        }
                                    }
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("You have written not a digit.");
                            }

                        } while (!isEmployeeNumber);
                    }
                    // Change salary of employee
                    else if (Integer.parseInt(choice) == 5) {
                        //Print the list of the employees with ordinal numbers
                        System.out.println("The list of employees: ");
                        int count = 1;
                        for (Employee e : employees) {
                            System.out.println(count + " " + e);
                            count++;
                        }
                        boolean isChanged = false;
                        do {
                            System.out.println("Write ordinal number of employee from the list: ");
                            try {
                                int numRaised = Integer.parseInt(reader.readLine());
                                System.out.println("Write information about salary: " + "\n" +
                                        "For reference: Marketing:  1. Trainee (from 300 to 600), 2. Specialist (from 500 to 1200), 3. Head of marketing (from 1000 to 2000)" + "\n" +
                                        "HR: 4. Manager (from 400 to 800), 5. Senior manager (from 700 to 1100), 6. Head of HR (from 800 to 1700)" + "\n" +
                                        "Development: 7. Junior developer (from 400 to 1000), 8. Middle developer (from 800 to 2000), 9. Senior developer (from 1800 to 4000), 10. Team lead (from 2500 to 7000)");

                                int newSalary = Integer.parseInt(reader.readLine());
                                for (int i = 0; i < employees.size(); i++) {
                                    if (numRaised - 1 == i) {
                                        changeSalary(employees.get(numRaised - 1), newSalary);
                                        isChanged = true;
                                    }
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("You have written not a digit.");
                            }
                        } while (!isChanged);


                    }
                    //Raise of Position
                    else if (Integer.parseInt(choice) == 6) {
                        //Print the list of the employees with ordinal numbers
                        System.out.println("The list of employees: ");
                        int count = 1;
                        for (Employee e : employees) {
                            System.out.println(count + " " + e);
                            count++;
                        }
                        boolean isRaised = false;
                        do {
                            System.out.println("Write ordinal number of employee from the list: ");
                            try {
                                int numRaised = Integer.parseInt(reader.readLine());
                                for (int i = 0; i < employees.size(); i++) {
                                    if (numRaised - 1 == i) {
                                        raisePosition(employees.get(numRaised - 1));
                                        isRaised = true;
                                    }
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("You have written not a digit.");
                            }
                        } while (!isRaised);

                    }
                    //Demotion of Position
                    else if (Integer.parseInt(choice) == 7) {
                        //Print the list of the employees with ordinal numbers
                        System.out.println("The list of employees: ");
                        int count = 1;
                        for (Employee e : employees) {
                            System.out.println(count + " " + e);
                            count++;
                        }
                        boolean isDemoted = false;

                        do {
                            System.out.println("Write ordinal number of employee from the list: ");
                            try {
                                int numDemoted = Integer.parseInt(reader.readLine());
                                for (int i = 0; i < employees.size(); i++) {
                                    if (numDemoted - 1 == i) {
                                        lowerPosition(employees.get(numDemoted - 1));
                                        isDemoted = true;
                                    }
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("You have written not a digit.");
                            }
                        } while (!isDemoted);

                    }
                }
                while (Integer.parseInt(choice) != 8);
            } catch (NumberFormatException e) {
                System.out.println("You have written not a digit. ");

            }

        }

    }
}
