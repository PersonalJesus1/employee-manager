package Lessons.Employee_manager.departments;

import Lessons.Employee_manager.Employee;
import Lessons.Employee_manager.positions.*;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import static Lessons.Employee_manager.Accounting.changeSalary;
import static Lessons.Employee_manager.EmployeeManager.READER;
import static Lessons.Employee_manager.departments.Department.*;
import static Lessons.Employee_manager.FileManager.employees;

public class DepartmentManager implements Serializable {
    private static final long serialVersionUID = 1;

    public static void changeForHR(Employee employee) {
        boolean isChanged = false;
        do {
            System.out.println("Write the number of the title of job: 1.Manager, 2. Senior manager, 3. Head of HR");
            try {
                int numTitle = Integer.parseInt(READER.readLine());
                switch (numTitle) {
                    case 1: {
                        Manager manager = new Manager();
                        employee.setJobTitle(manager);
                        employee.setSalary(manager.getMinSalary());
                        isChanged = true;
                        break;
                    }
                    case 2: {
                        SeniorManager seniorManager = new SeniorManager();
                        employee.setJobTitle(seniorManager);
                        employee.setSalary(seniorManager.getMinSalary());
                        isChanged = true;
                        break;
                    }
                    case 3: {
                        HeadOfHr headOfHr = new HeadOfHr();
                        employee.setJobTitle(headOfHr);
                        employee.setSalary(headOfHr.getMinSalary());
                        isChanged = true;
                        break;
                    }
                    default:
                        System.out.println("You have written a wrong number.");
                }
            } catch (NumberFormatException | IOException e) {
                System.out.println("You have written not a digit.");
            }
        } while (!isChanged);
    }

    public static void changeForDevelopment(Employee employee) {
        boolean isChanged = false;
        do {
            System.out.println("Write the number of the title of job: 1.Junior developer, 2. Middle developer, 3.Senior developer, 4. Team lead");
            try {
                int numTitle = Integer.parseInt(READER.readLine());
                switch (numTitle) {
                    case 1: {
                        JuniorDeveloper juniorDeveloper = new JuniorDeveloper();
                        employee.setJobTitle(juniorDeveloper);
                        employee.setSalary(juniorDeveloper.getMinSalary());
                        isChanged = true;
                        break;
                    }
                    case 2: {
                        MiddleDeveloper middleDeveloper = new MiddleDeveloper();
                        employee.setJobTitle(middleDeveloper);
                        employee.setSalary(middleDeveloper.getMinSalary());
                        isChanged = true;
                        break;
                    }
                    case 3: {
                        SeniorDeveloper seniorDeveloper = new SeniorDeveloper();
                        employee.setJobTitle(seniorDeveloper);
                        employee.setSalary(seniorDeveloper.getMinSalary());
                        isChanged = true;
                        break;
                    }
                    case 4: {
                        TeamLead teamLead = new TeamLead();
                        employee.setJobTitle(teamLead);
                        employee.setSalary(teamLead.getMinSalary());
                        isChanged = true;
                        break;
                    }
                    default:
                        System.out.println("You have written a wrong number.");
                }
            } catch (NumberFormatException | IOException e) {
                System.out.println("You have written not a digit.");
            }
        } while (!isChanged);

    }

    public static void changeForMarketing(Employee employee) {
        boolean isChanged = false;
        do {
            System.out.println("Write the number of the title of job: 1.Trainee, 2. Specialist, 3. Head of marketing");
            try {
                int numberOfJob = Integer.parseInt(READER.readLine());
                switch (numberOfJob) {
                    case 1: {
                        Trainee trainee = new Trainee();
                        employee.setJobTitle(trainee);
                        employee.setSalary(trainee.getMinSalary());
                        isChanged = true;
                        break;
                    }
                    case 2: {
                        Specialist specialist = new Specialist();
                        employee.setJobTitle(specialist);
                        employee.setSalary(specialist.getMinSalary());
                        isChanged = true;
                        break;
                    }
                    case 3: {
                        HeadOfMarketing headOfMarketing = new HeadOfMarketing();
                        employee.setJobTitle(headOfMarketing);
                        employee.setSalary(headOfMarketing.getMinSalary());
                        isChanged = true;
                        break;
                    }
                    default:
                        System.out.println("You have written a wrong number.");
                }
            } catch (NumberFormatException | IOException e) {
                System.out.println("You have written not a digit.");
            }
        } while (!isChanged);

    }


    public static void changeDepartment(Employee employee) throws IOException {

        boolean isDepartChanged = false;
        int indexOfEmployee = employees.indexOf(employee);
        Department oldDepartment = (employees.get(indexOfEmployee).getJobTitle().getDepartment());
        // Choice of Department
        if (oldDepartment == MARKETING) {
            do {
                System.out.println("Write the number of the department: 1.Human Resources 2. Development");
                try {
                    int choiceDep = Integer.parseInt(READER.readLine());
                    if (choiceDep == 1) {
                        changeForHR(employee);
                        isDepartChanged = true;
                    } else if (choiceDep == 2) {
                        changeForDevelopment(employee);
                        isDepartChanged = true;
                    } else System.out.println("You have written a wrong number. ");
                } catch (NumberFormatException e) {
                    System.out.println("You have written not a digit. ");
                }
            } while (!isDepartChanged);


        } else if (oldDepartment == HR) {
            do {
                System.out.println("Write the number of the department: 1.Marketing 2. Development");
                try {
                    int choiceDep = Integer.parseInt(READER.readLine());
                    if (choiceDep == 1) {
                        changeForMarketing(employee);
                        isDepartChanged = true;

                    } else if (choiceDep == 2) {
                        changeForDevelopment(employee);
                        isDepartChanged = true;

                    } else System.out.println("You have written a wrong number. ");
                } catch (NumberFormatException e) {
                    System.out.println("You have written not a digit. ");
                }
            } while (!isDepartChanged);


        } else if (oldDepartment == DEVELOPMENT) {

            do {
                System.out.println("Write the number of the department:  1.Marketing 2. HR");
                try {
                    int choiceDep = Integer.parseInt(READER.readLine());
                    if (choiceDep == 1) {
                        changeForMarketing(employee);
                        isDepartChanged = true;
                    } else if (choiceDep == 2) {

                        changeForHR(employee);
                        isDepartChanged = true;
                    } else System.out.println("You have written a wrong number. ");

                } catch (NumberFormatException e) {
                    System.out.println("You have written not a digit. ");
                }

            } while (!isDepartChanged);
        }
        employee.setLastChangeDate(LocalDate.now());
        System.out.println("Information about employee has been changed. ");

    }

    public static int chooseNumJobtitle() throws IOException {

        int numberOfJob = 0;
        boolean isRightDepartment = false;

        do {
            System.out.println("Write number of the Job Title of the Department from proposed ones below: " + "\n" +
                    "Marketing :  1. Trainee, 2. Specialist, 3. Head of marketing " + "\n" +
                    "HR : 4. Manager, 5. Senior manager, 6. Head of HR" + "\n" +
                    "Development : 7. Junior developer, 8. Middle developer, 9. Senior developer, 10. Team lead");
            try {
                numberOfJob = Integer.parseInt(READER.readLine());
                switch (numberOfJob) {
                    case 1: {
                        System.out.println("Information has been accepted.");
                        isRightDepartment = true;
                        break;
                    }
                    case 2: {
                        System.out.println("Information has been accepted.");
                        isRightDepartment = true;
                        break;
                    }
                    case 3: {
                        System.out.println("Information has been accepted.");
                        isRightDepartment = true;
                        break;
                    }
                    case 4: {
                        System.out.println("Information has been accepted.");
                        isRightDepartment = true;
                        break;
                    }
                    case 5: {
                        System.out.println("Information has been accepted.");
                        isRightDepartment = true;
                        break;
                    }
                    case 6: {
                        System.out.println("Information has been accepted.");
                        isRightDepartment = true;
                        break;
                    }
                    case 7: {
                        System.out.println("Information has been accepted.");
                        isRightDepartment = true;
                        break;
                    }
                    case 8: {
                        System.out.println("Information has been accepted.");
                        isRightDepartment = true;
                        break;
                    }
                    case 9: {
                        System.out.println("Information has been accepted.");
                        isRightDepartment = true;
                        break;
                    }
                    case 10: {
                        System.out.println("Information has been accepted.");
                        isRightDepartment = true;
                        break;
                    }
                    default:
                        System.out.println("You have written a wrong number.");
                }

            } catch (NumberFormatException e) {
                System.out.println("You have written not a digit. ");
            }
        }
        while (!isRightDepartment);
        return numberOfJob;
    }

    public static Position jobTitleOfChosenNum(int chosenJob) {
        Position jobTitle = null;
        switch (chosenJob) {
            case 1: {
                jobTitle = new Trainee();
                break;
            }
            case 2: {
                jobTitle = new Specialist();
                break;
            }
            case 3: {
                jobTitle = new HeadOfMarketing();
                break;
            }
            case 4: {
                jobTitle = new Manager();
                break;
            }
            case 5: {
                jobTitle = new SeniorManager();
                break;
            }
            case 6: {
                jobTitle = new HeadOfHr();
                break;

            }
            case 7: {
                jobTitle = new JuniorDeveloper();
                break;
            }
            case 8: {
                jobTitle = new MiddleDeveloper();
                break;
            }
            case 9: {
                jobTitle = new SeniorDeveloper();
                break;
            }
            case 10: {
                jobTitle = new TeamLead();
                break;
            }

            default:
                System.out.println("You have written a wrong number.");
        }
        return jobTitle;
    }

    public static void raisePosition(Employee employee) throws IOException {
        // The name of title job
        String nameJobTitle = employee.getJobTitle().getName();
        // changing position depending on the previous one
        if ("Trainee".equals(nameJobTitle))
            employee.setJobTitle(new Specialist());
        else if ("Specialist".equals(nameJobTitle))
            employee.setJobTitle(new HeadOfMarketing());
        else if ("Manager".equals(nameJobTitle))
            employee.setJobTitle(new SeniorManager());
        else if ("Senior Manager".equals(nameJobTitle))
            employee.setJobTitle(new HeadOfHr());
        else if ("Junior Developer".equals(nameJobTitle))
            employee.setJobTitle(new MiddleDeveloper());
        else if ("Middle Developer".equals(nameJobTitle))
            employee.setJobTitle(new SeniorDeveloper());
        else if ("Senior Developer".equals(nameJobTitle))
            employee.setJobTitle(new TeamLead());
        else {
            nameJobTitle = "no raise";
        }

        //changeSalary
        if (nameJobTitle.equals("no raise")) System.out.println("There is no raise for this position. ");
        else {
            System.out.println("Write information about salary: " + "\n" +
                    "For reference: Marketing:  1. Specialist (from 500 to 1200), 2. Head of marketing (from 1000 to 2000)" + "\n" +
                    "HR: 3. Senior manager (from 700 to 1100), 4. Head of HR (from 800 to 1700)" + "\n" +
                    "Development: 5. Middle developer (from 800 to 2000), 6. Senior developer (from 1800 to 4000), 7. Team lead (from 2500 to 7000)");
            int newSalary = Integer.parseInt(READER.readLine());
            changeSalary(employee, newSalary);
            employee.setLastChangeDate(LocalDate.now());
            System.out.println("Information has been changed");
        }
    }

    public static void lowerPosition(Employee employee) throws IOException {

        // The name of title job
        String nameJobTitle = employee.getJobTitle().getName();
        // changing position depending on the previous one
        if ("Specialist".equals(nameJobTitle))
            employee.setJobTitle(new Trainee());
        else if ("Head Of Marketing".equals(nameJobTitle))
            employee.setJobTitle(new Specialist());
        else if ("Senior Manager".equals(nameJobTitle))
            employee.setJobTitle(new Manager());
        else if ("Head Of HR".equals(nameJobTitle))
            employee.setJobTitle(new SeniorManager());
        else if ("Middle Developer".equals(nameJobTitle))
            employee.setJobTitle(new JuniorDeveloper());
        else if ("Senior Developer".equals(nameJobTitle))
            employee.setJobTitle(new MiddleDeveloper());
        else if ("Team Lead".equals(nameJobTitle))
            employee.setJobTitle(new SeniorDeveloper());
        else {
            nameJobTitle = "no demotion";
        }

        //changeSalary
        if (nameJobTitle.equals("no demotion")) System.out.println("There is no demotion for this position. ");
        else {
            System.out.println("For reference: Marketing:  1. Trainee (from 300 to 600), 2. Specialist (from 500 to 1200), " + "\n" +
                    "HR: 3. Manager (from 400 to 800), 4. Senior manager (from 700 to 1100)," + "\n" +
                    "Development: 5. Junior developer (from 400 to 1000), 6. Middle developer (from 800 to 2000), 7. Senior developer (from 1800 to 4000).");
            int newSalary = Integer.parseInt(READER.readLine());
            changeSalary(employee, newSalary);
            employee.setLastChangeDate(LocalDate.now());
            System.out.println("Information has been changed");
        }
    }
}

