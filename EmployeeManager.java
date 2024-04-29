package Lessons.Employee_manager;

import Lessons.Employee_manager.departments.DepartmentManager;
import Lessons.Employee_manager.positions.*;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.regex.Pattern;

import static Lessons.Employee_manager.Accounting.changeSalary;
import static Lessons.Employee_manager.Accounting.chooseSalary;
import static Lessons.Employee_manager.FileManager.*;
import static Lessons.Employee_manager.departments.DepartmentManager.*;

public class EmployeeManager implements Serializable {

    private static final long serialVersionUID = 1;

    public static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    //Print the list of the employees
    private static void printListOfEmployee() {
        System.out.println("The list of employees: ");
        int count = 1;
        if (getEmployees().size() == 0) System.out.println("The list is empty ");
        else {
            for (Employee e : getEmployees()) {
                System.out.println(count + " " + e);
                count++;
            }
        }
    }

    //Get Index of Ordinal number of employee
    public static int indexOfChosenNum(int ordinalNumber) {
        for (int i = 0; i < getEmployees().size(); i++) {
            if (ordinalNumber - 1 == i) {
                return i;
            }
        }
        return -1;
    }

    //Ask Ordinal number of employee, ask about salary, change salary
    private static void choiceEmployeeToChangeSalary() {
        boolean isChanged = false;
        do {
            System.out.println("Write ordinal number of employee from the list: ");
            try {
                int ordinalNumber = Integer.parseInt(READER.readLine());
                if (ordinalNumber > getEmployees().size() || ordinalNumber < 1)
                    System.out.println("You have written a wrong number.");
                else {

                    System.out.println("Write information about salary: " + "\n" +
                            "For reference: Marketing:  1. Trainee (from 300 to 600), 2. Specialist (from 500 to 1200), 3. Head of marketing (from 1000 to 2000)" + "\n" +
                            "HR: 4. Manager (from 400 to 800), 5. Senior manager (from 700 to 1100), 6. Head of HR (from 800 to 1700)" + "\n" +
                            "Development: 7. Junior developer (from 400 to 1000), 8. Middle developer (from 800 to 2000), 9. Senior developer (from 1800 to 4000), 10. Team lead (from 2500 to 7000)");
                    int newSalary = Integer.parseInt(READER.readLine());
                    int indexOfNum = indexOfChosenNum(ordinalNumber);
                    changeSalary(getEmployees().get(indexOfNum), newSalary);
                    saveEmployees(getEmployees());
                    isChanged = true;
                }
            } catch (NumberFormatException | IOException e) {
                System.out.println("You have written not a digit.");
            }
        } while (!isChanged);
    }

    //Ask Ordinal number of employee, change department
    private static void choiceEmployeeToChangeDepartment() {

        printListOfEmployee();
        boolean isEmployeeNumber = false;
        do {
            System.out.println("Write ordinal number of employee from the list ");
            try {
                int choiceEmployee = Integer.parseInt(READER.readLine());
                int indexOfNum = indexOfChosenNum(choiceEmployee);
                if (indexOfNum < 0) System.out.println("You have written a wrong number.");
                else {
                    DepartmentManager.changeDepartment(getEmployees().get(indexOfNum));
                    saveEmployees(getEmployees());
                    isEmployeeNumber = true;

                }
            } catch (NumberFormatException | IOException e) {
                System.out.println("You have written not a digit.");
            }

        } while (!isEmployeeNumber);
    }

    //Ask Ordinal number of employee,raise of Position
    private static void choiceEmployeeToRaisePosition() {
        //Print the list of the employees with ordinal numbers
        printListOfEmployee();
        boolean isRaised = false;
        do {
            System.out.println("Write ordinal number of employee from the list: ");
            try {
                int numRaised = Integer.parseInt(READER.readLine());

                int indexOfNum = indexOfChosenNum(numRaised);
                if (indexOfNum < 0) System.out.println("You have written a wrong number.");
                else {
                    raisePosition(getEmployees().get(indexOfNum));
                    saveEmployees(getEmployees());
                    isRaised = true;
                }
            } catch (NumberFormatException | IOException e) {
                System.out.println("You have written not a digit.");
            }
        } while (!isRaised);

    }

    //Ask Ordinal number of employee, demote of Position
    private static void choiceEmployeeToDemotePosition() {
        //Print the list of the employees with ordinal numbers
        printListOfEmployee();
        boolean isDemoted = false;
        do {
            System.out.println("Write ordinal number of employee from the list: ");
            try {
                int numDemoted = Integer.parseInt(READER.readLine());

                int indexOfNum = indexOfChosenNum(numDemoted);
                if (indexOfNum < 0) System.out.println("You have written a wrong number.");
                else {
                    lowerPosition(getEmployees().get(indexOfNum));
                    saveEmployees(getEmployees());
                    isDemoted = true;

                }
            } catch (NumberFormatException | IOException e) {
                System.out.println("You have written not a digit.");
            }
        } while (!isDemoted);
    }

    private static boolean isValidString(String stringToCheck) {
        String toBeCompared = "^[a-zA-Zа-яА-Я]+$";
        return Pattern.matches(toBeCompared, stringToCheck);
    }

    private static void createEmployee() throws IOException {
        String name, surname;


        System.out.println("Creating information of new employee: ");
        //Write name
        boolean isNameString = false;
        do {
            System.out.println("Write name");
            name = READER.readLine();
            if (!isValidString(name)) System.out.println("You have written unacceptable symbols. Try again");
            else isNameString = true;

        } while (!isNameString);

        //Write surname
        boolean isSurnameString = false;
        do {
            System.out.println("Write surname");
            surname = READER.readLine();
            if (!isValidString(surname)) System.out.println("You have written unacceptable symbols. Try again");
            else isSurnameString = true;

        } while (!isSurnameString);

        //Write Job title
        int numOfChosenJob = chooseNumJobtitle();
        Position jobTitle = jobTitleOfChosenNum(numOfChosenJob);

        // Write salary
        int ChosenSalary = chooseSalary(jobTitle);

        LocalDate today = LocalDate.now();
        int lastId;
        if (getEmployees().size() == 0) lastId = 1;
        else lastId = getEmployees().get(getEmployees().size() - 1).getID() + 1;
        Employee employee = new Employee(name, surname, lastId, jobTitle, new BigDecimal(ChosenSalary), today);
        addEmployee(employee);
        saveEmployees(getEmployees());
        System.out.println("Information about new employee has been created.");

    }

    private static void removeEmployee() throws IOException {

        printListOfEmployee();
        boolean isRightRemoveNumber = false;
        do {
            System.out.println("Write ordinal number of employee from the list to delete");
            try {

                int RemoveNumber = Integer.parseInt(READER.readLine());
                int IndextOfRemoveImployee = indexOfChosenNum(RemoveNumber);
                if (IndextOfRemoveImployee < 0) System.out.println("You have written  a wrong number.");
                else {
                    FileManager.removeEmployee(getEmployees().get(IndextOfRemoveImployee));
                    saveEmployees(getEmployees());
                    isRightRemoveNumber = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("You have written not a digit.");
            }
        } while (!isRightRemoveNumber);
    }

    //print Employees by the Department
    static class DepartmentComporator implements Comparator<Employee> {
        public int compare(Employee e1, Employee e2) {

            return e1.getJobTitle().getDepartment().getTitle().compareTo(e2.getJobTitle().getDepartment().getTitle());
        }
    }

    private static void getEmployeeByDepartment() {
        ArrayList<Employee> employees = getEmployees();
        employees.stream()
                .sorted(new DepartmentComporator())
                .forEach(e -> System.out.println(e));

    }

    //print Employees by the Salary
    static class SalaryComporator implements Comparator<Employee> {
        public int compare(Employee e1, Employee e2) {

            return e1.getSalary().compareTo(e2.getSalary());
        }
    }

    private static void getEmployeeBySalary() {
        ArrayList<Employee> employees = getEmployees();
        employees.stream()
                .sorted(new SalaryComporator())
                .forEach(e -> System.out.println(e));

    }

    //print Employees with the highest job title


    private static void getEmployeeWithHighestJobTitle() {
        ArrayList<Employee> employees = getEmployees();
        employees.stream()
                .filter(e ->
                {
                    if (e.getJobTitle().getName().equals("Head Of Marketing")
                            || e.getJobTitle().getName().equals("Head of HR")
                            || e.getJobTitle().getName().equals("Team Lead"))
                        return true;
                    else return false;
                })
                .forEach(e -> System.out.println(e));
    }

       public static void main(String[] args) throws IOException {

        //get all information from file
        setEmployees();

        try (READER) {
            String choice;
            try {
                do {
                    System.out.println("Write the number of the next action  (1, 2, 3, 4, 5, 6, 7, 8, 9, 10 or 11): " + "\n" +
                            "1. Print the list of the employees 2. Write information about new employee 3. Delete information about employee " + "\n" +
                            "4. Change department of employee 5. Change salary of employee 6. Raise of Position 7.Demotion of Position " + "\n" +
                            "8. Print the list of employees by the Department 9.Print the list of employees by the Salary " + "\n" +
                            "10. Print the list of employees with the highest job title 11. Exit");

                    choice = READER.readLine();
                    //Print the list of the employees
                    if (Integer.parseInt(choice) == 1) {
                        printListOfEmployee();

                    }
                    // Write information about new employee
                    else if (Integer.parseInt(choice) == 2) {
                        createEmployee();
                    }
                    // Delete information about employee
                    else if (Integer.parseInt(choice) == 3) {
                        removeEmployee();
                    }
                    // Change department of employee
                    else if (Integer.parseInt(choice) == 4) {
                        choiceEmployeeToChangeDepartment();
                    }
                    // Change salary of employee
                    else if (Integer.parseInt(choice) == 5) {
                        choiceEmployeeToChangeSalary();
                    }
                    //Raise of Position
                    else if (Integer.parseInt(choice) == 6) {
                        choiceEmployeeToRaisePosition();
                    }
                    //Demotion of Position
                    else if (Integer.parseInt(choice) == 7) {
                        choiceEmployeeToDemotePosition();
                    //print Employees by the Department
                    } else if (Integer.parseInt(choice) == 8) {
                        getEmployeeByDepartment();
                    //print Employees by the Salary
                    } else if (Integer.parseInt(choice) == 9) {
                        getEmployeeBySalary();
                    //print Employees with the highest job title
                    } else if (Integer.parseInt(choice) == 10) {
                        getEmployeeWithHighestJobTitle();
                    } else if (Integer.parseInt(choice) == 11) {
                        break;
                    }
                }
                while (Integer.parseInt(choice) < 12);
            } catch (NumberFormatException e) {
                System.out.println("You have written not a digit. ");

            }
        }
    }
}


