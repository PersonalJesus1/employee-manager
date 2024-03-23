package Lessons.Employee_manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

import static Lessons.Employee_manager.Accounting.changeSalary;
import static Lessons.Employee_manager.Department.*;
import static Lessons.Employee_manager.FileManager.employees;

public class DepartmentManager {

    public static void changeDepartment(Employee employee) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        boolean isDepartChanged = false;
        int indexOfEmployee = employees.indexOf(employee);
        Department oldDepartment = (employees.get(indexOfEmployee).getJob_title().getDepartment());
        // Choice of Department
        if (oldDepartment == MARKETING) {
            do {
                System.out.println("Write the number of the department: 1.Human Resources 2. Development");
                try {
                    int choiceDep = Integer.parseInt(reader.readLine());
                    if (choiceDep == 1) {
                        // Choice of job in HR
                        do {
                            System.out.println("Write the number of the title of job: 1.Manager, 2. Senior manager, 3. Head of HR");
                            try {
                                int numTitle = Integer.parseInt(reader.readLine());
                                switch (numTitle) {
                                    case 1: {
                                        Manager manager = new Manager();
                                        employee.setJob_title(manager);
                                        employee.setSalary(manager.getMinSalary());
                                        isDepartChanged = true;
                                        break;
                                    }
                                    case 2: {
                                        SeniorManager seniorManager = new SeniorManager();
                                        employee.setJob_title(seniorManager);
                                        employee.setSalary(seniorManager.getMinSalary());
                                        isDepartChanged = true;
                                        break;
                                    }
                                    case 3: {
                                        HeadOfHr headOfHr = new HeadOfHr();
                                        employee.setJob_title(headOfHr);
                                        employee.setSalary(headOfHr.getMinSalary());
                                        isDepartChanged = true;
                                        break;
                                    }
                                    default:
                                        System.out.println("You have written a wrong number.");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("You have written not a digit.");
                            }


                        } while (!isDepartChanged);

                    } else if (choiceDep == 2) {

                        // Choice of job in DEVELOPMENT
                        do {
                            System.out.println("Write the number of the title of job: 1.Junior developer, 2. Middle developer, 3.Senior developer, 4. Team lead");
                            try {
                                int numTitle = Integer.parseInt(reader.readLine());
                                switch (numTitle) {
                                    case 1: {
                                        JuniorDeveloper juniorDeveloper = new JuniorDeveloper();
                                        employee.setJob_title(new JuniorDeveloper());
                                        employee.setSalary(juniorDeveloper.getMinSalary());
                                        isDepartChanged = true;
                                        break;
                                    }
                                    case 2: {
                                        MiddleDeveloper middleDeveloper = new MiddleDeveloper();
                                        employee.setJob_title(new MiddleDeveloper());
                                        employee.setSalary(middleDeveloper.getMinSalary());
                                        isDepartChanged = true;
                                        break;
                                    }
                                    case 3: {
                                        SeniorDeveloper seniorDeveloper = new SeniorDeveloper();
                                        employee.setJob_title(new SeniorDeveloper());
                                        employee.setSalary(seniorDeveloper.getMinSalary());
                                        isDepartChanged = true;
                                        break;
                                    }
                                    case 4: {
                                        TeamLead teamLead = new TeamLead();
                                        employee.setJob_title(new TeamLead());
                                        employee.setSalary(teamLead.getMinSalary());
                                        isDepartChanged = true;
                                        break;
                                    }
                                    default:
                                        System.out.println("You have written a wrong number.");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("You have written not a digit. ");
                            }

                        } while (!isDepartChanged);


                    } else System.out.println("You have written a wrong number. ");
                } catch (NumberFormatException e) {
                    System.out.println("You have written not a digit. ");
                }
            } while (!isDepartChanged);


        } else if (oldDepartment == HR) {

            do {
                System.out.println("Write the number of the department: 1.Marketing 2. Development");
                try {
                    int choiceDep = Integer.parseInt(reader.readLine());
                    if (choiceDep == 1) {

                        // Choice of job in MARKETING
                        do {
                            System.out.println("Write the number of the title of job: 1.Trainee, 2. Specialist, 3. Head of marketing");
                            try {
                                int numberOfJob = Integer.parseInt(reader.readLine());
                                switch (numberOfJob) {
                                    case 1: {
                                        Trainee trainee = new Trainee();
                                        employee.setJob_title(new Trainee());
                                        employee.setSalary(trainee.getMinSalary());
                                        isDepartChanged = true;
                                        break;
                                    }
                                    case 2: {
                                        Specialist specialist = new Specialist();
                                        employee.setJob_title(new Specialist());
                                        employee.setSalary(specialist.getMinSalary());
                                        isDepartChanged = true;
                                        break;
                                    }
                                    case 3: {
                                        HeadOfMarketing headOfMarketing = new HeadOfMarketing();
                                        employee.setJob_title(new HeadOfMarketing());
                                        employee.setSalary(headOfMarketing.getMinSalary());
                                        isDepartChanged = true;
                                        break;
                                    }
                                    default:
                                        System.out.println("You have written a wrong number.");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("You have written not a digit. ");
                            }
                        }
                        while (!isDepartChanged);
                    } else if (choiceDep == 2) {
                        // Choice of job in DEVELOPMENT
                        do {
                            System.out.println("Write the number of the title of job: 1.Junior developer, 2. Middle developer, 3.Senior developer, 4. Team lead");
                            try {
                                int numberOfJob = Integer.parseInt(reader.readLine());
                                switch (numberOfJob) {
                                    case 1: {
                                        JuniorDeveloper juniorDeveloper = new JuniorDeveloper();
                                        employee.setJob_title(new JuniorDeveloper());
                                        employee.setSalary(juniorDeveloper.getMinSalary());
                                        isDepartChanged = true;
                                        break;
                                    }
                                    case 2: {
                                        MiddleDeveloper middleDeveloper = new MiddleDeveloper();
                                        employee.setJob_title(new MiddleDeveloper());
                                        employee.setSalary(middleDeveloper.getMinSalary());
                                        isDepartChanged = true;
                                        break;
                                    }
                                    case 3: {
                                        SeniorDeveloper seniorDeveloper = new SeniorDeveloper();
                                        employee.setJob_title(new SeniorDeveloper());
                                        employee.setSalary(seniorDeveloper.getMinSalary());
                                        isDepartChanged = true;
                                        break;
                                    }
                                    case 4: {
                                        TeamLead teamLead = new TeamLead();
                                        employee.setJob_title(new TeamLead());
                                        employee.setSalary(teamLead.getMinSalary());
                                        isDepartChanged = true;
                                        break;
                                    }
                                    default:
                                        System.out.println("You have written a wrong number. ");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("You have written not a digit.  ");
                            }
                        }
                        while (!isDepartChanged);
                    } else System.out.println("You have written a wrong number. ");
                } catch (NumberFormatException e) {
                    System.out.println("You have written not a digit. ");
                }
            } while (!isDepartChanged);


        } else if (oldDepartment == DEVELOPMENT) {

            do {
                System.out.println("Write the number of the department:  1.Marketing 2. HR");
                try {
                    int choiceDep = Integer.parseInt(reader.readLine());
                    if (choiceDep == 1) {

                        // Choice of job in MARKETING
                        do {
                            System.out.println("Write the number of the title of job: 1.Trainee, 2. Specialist, 3. Head of marketing");
                            try {
                                int numberOfJob = Integer.parseInt(reader.readLine());

                                switch (numberOfJob) {
                                    case 1: {
                                        Trainee trainee = new Trainee();
                                        employee.setJob_title(new Trainee());
                                        employee.setSalary(trainee.getMinSalary());
                                        isDepartChanged = true;
                                        break;
                                    }
                                    case 2: {
                                        Specialist specialist = new Specialist();
                                        employee.setJob_title(new Specialist());
                                        employee.setSalary(specialist.getMinSalary());
                                        isDepartChanged = true;
                                        break;
                                    }
                                    case 3: {
                                        HeadOfMarketing headOfMarketing = new HeadOfMarketing();
                                        employee.setJob_title(new HeadOfMarketing());
                                        employee.setSalary(headOfMarketing.getMinSalary());
                                        isDepartChanged = true;
                                        break;
                                    }
                                    default:
                                        System.out.println("You have written a wrong number. ");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("You have written not a digit. ");
                            }
                        }
                        while (!isDepartChanged);

                    } else if (choiceDep == 2) {
                        // Choice of job in HR

                        do {
                            System.out.println("Write the number of the title of job: 1.Manager, 2. Senior manager, 3. Head of HR");
                            try {
                                int numberOfJob = Integer.parseInt(reader.readLine());
                                switch (numberOfJob) {
                                    case 1: {
                                        Manager manager = new Manager();
                                        employee.setJob_title(new Manager());
                                        employee.setSalary(manager.getMinSalary());
                                        isDepartChanged = true;
                                        break;
                                    }
                                    case 2: {
                                        SeniorManager seniorManager = new SeniorManager();
                                        employee.setJob_title(new SeniorManager());
                                        employee.setSalary(seniorManager.getMinSalary());
                                        isDepartChanged = true;
                                        break;
                                    }
                                    case 3: {
                                        HeadOfHr headOfHr = new HeadOfHr();
                                        employee.setJob_title(new HeadOfHr());
                                        employee.setSalary(headOfHr.getMinSalary());
                                        isDepartChanged = true;
                                        break;
                                    }
                                    default:
                                        System.out.println("You have written a wrong number.  ");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("You have written not a digit.");
                            }
                        }
                        while (!isDepartChanged);

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
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfJob = 0;
        boolean isRightDepartment = false;

        do {
            System.out.println("Write number of the Job Title of the Department from proposed ones below: " + "\n" +
                    "Marketing :  1. Trainee, 2. Specialist, 3. Head of marketing " + "\n" +
                    "HR : 4. Manager, 5. Senior manager, 6. Head of HR" + "\n" +
                    "Development : 7. Junior developer, 8. Middle developer, 9. Senior developer, 10. Team lead");
            try {
                numberOfJob = Integer.parseInt(reader.readLine());
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
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // The name of title job
        String nameJobTitle = employee.getJob_title().getName();
        // changing position depending on the previous one
        if (new Trainee().getName().equals(nameJobTitle))
            employee.setJob_title(new Specialist());
        else if (new Specialist().getName().equals(employee.getJob_title().getName()))
            employee.setJob_title(new HeadOfMarketing());
        else if (new Manager().getName().equals(employee.getJob_title().getName()))
            employee.setJob_title(new SeniorManager());
        else if (new SeniorManager().getName().equals(employee.getJob_title().getName()))
            employee.setJob_title(new HeadOfHr());
        else if (new JuniorDeveloper().getName().equals(employee.getJob_title().getName()))
            employee.setJob_title(new MiddleDeveloper());
        else if (new MiddleDeveloper().getName().equals(employee.getJob_title().getName()))
            employee.setJob_title(new SeniorDeveloper());
        else if (new SeniorDeveloper().getName().equals(employee.getJob_title().getName()))
            employee.setJob_title(new TeamLead());
        else {
            nameJobTitle = " no raise";
        }

        //changeSalary
        if (nameJobTitle == "no raise") System.out.println("There is no raise for this position. ");
        else {
            System.out.println("Write information about salary: " + "\n" +
                    "For reference: Marketing:  1. Specialist (from 500 to 1200), 2. Head of marketing (from 1000 to 2000)" + "\n" +
                    "HR: 3. Senior manager (from 700 to 1100), 4. Head of HR (from 800 to 1700)" + "\n" +
                    "Development: 5. Middle developer (from 800 to 2000), 6. Senior developer (from 1800 to 4000), 7. Team lead (from 2500 to 7000)");
            int newSalary = Integer.parseInt(reader.readLine());
            changeSalary(employee, newSalary);
            employee.setLastChangeDate(LocalDate.now());
            System.out.println("Information has been changed");
        }
    }

    public static void lowerPosition(Employee employee) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // The name of title job
        String nameJobTitle = employee.getJob_title().getName();
        // changing position depending on the previous one
        if (new Specialist().getName().equals(employee.getJob_title().getName()))
            employee.setJob_title(new Trainee());
        else if (new HeadOfMarketing().getName().equals(employee.getJob_title().getName()))
            employee.setJob_title(new Specialist());
        else if (new SeniorManager().getName().equals(employee.getJob_title().getName()))
            employee.setJob_title(new Manager());
        else if (new HeadOfHr().getName().equals(employee.getJob_title().getName()))
            employee.setJob_title(new SeniorManager());
        else if (new MiddleDeveloper().getName().equals(employee.getJob_title().getName()))
            employee.setJob_title(new JuniorDeveloper());
        else if (new SeniorDeveloper().getName().equals(employee.getJob_title().getName()))
            employee.setJob_title(new MiddleDeveloper());
        else if (new TeamLead().getName().equals(employee.getJob_title().getName()))
            employee.setJob_title(new SeniorDeveloper());
        else {
            nameJobTitle = "no demotion";
        }

        //changeSalary
        if (nameJobTitle == "no demotion") System.out.println("There is no demotion for this position. ");
        else {
            System.out.println("For reference: Marketing:  1. Trainee (from 300 to 600), 2. Specialist (from 500 to 1200), " + "\n" +
                    "HR: 3. Manager (from 400 to 800), 4. Senior manager (from 700 to 1100)," + "\n" +
                    "Development: 5. Junior developer (from 400 to 1000), 6. Middle developer (from 800 to 2000), 7. Senior developer (from 1800 to 4000).");
            int newSalary = Integer.parseInt(reader.readLine());
            changeSalary(employee, newSalary);
            employee.setLastChangeDate(LocalDate.now());
            System.out.println("Information has been changed");
        }
    }

}
