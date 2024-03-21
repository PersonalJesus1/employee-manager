package Lessons.Employee_manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

import static Lessons.Employee_manager.Department.*;
import static Lessons.Employee_manager.FileManager.employees;

public class DepartmentManager {

    public static void changeDepartment(Employee employee) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        boolean boolean1 = false;
        int index = employees.indexOf(employee);
        Department oldDepartment = (employees.get(index).getJob_title().getDepartment());
        if (oldDepartment == MARKETING) {
            int choiceDep = 0;

            do {
                System.out.println("Впишите номер отдела: 1.Human Resources 2. Development");
                try {
                    choiceDep = Integer.parseInt(reader.readLine());
                    if (choiceDep == 1) {
                        int numTitle = 0;

                        do {
                            System.out.println("Введите номер должности: 1.Manager, 2. Senior manager, 3. Head of HR");
                            try {
                                numTitle = Integer.parseInt(reader.readLine());
                                switch (numTitle) {
                                    case 1: {
                                        Manager manager = new Manager();
                                        employee.setJob_title(manager);
                                        employee.setSalary(manager.getMinSalary());
                                        boolean1 = true;
                                        break;
                                    }
                                    case 2: {
                                        SeniorManager seniorManager = new SeniorManager();
                                        employee.setJob_title(seniorManager);
                                        employee.setSalary(seniorManager.getMinSalary());
                                        boolean1 = true;
                                        break;
                                    }
                                    case 3: {
                                        HeadOfHr headOfHr = new HeadOfHr();
                                        employee.setJob_title(headOfHr);
                                        employee.setSalary(headOfHr.getMinSalary());
                                        boolean1 = true;
                                        break;
                                    }
                                    default:
                                        System.out.println("Вы ввели неверное число. ");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Вы ввели не число. ");
                            }


                        } while (!boolean1);

                    } else if (choiceDep == 2) {
                        int numTitle = 0;

                        do {
                            System.out.println("Введите номер должности: 1.Junior developer, 2. Middle developer, 3.Senior developer, 4. Team lead");
                            try {
                                numTitle = Integer.parseInt(reader.readLine());
                                switch (numTitle) {
                                    case 1: {
                                        JuniorDeveloper juniorDeveloper = new JuniorDeveloper();
                                        employee.setJob_title(new JuniorDeveloper());
                                        employee.setSalary(juniorDeveloper.getMinSalary());
                                        boolean1 = true;
                                        break;
                                    }
                                    case 2: {
                                        MiddleDeveloper middleDeveloper = new MiddleDeveloper();
                                        employee.setJob_title(new MiddleDeveloper());
                                        employee.setSalary(middleDeveloper.getMinSalary());
                                        boolean1 = true;
                                        break;
                                    }
                                    case 3: {
                                        SeniorDeveloper seniorDeveloper = new SeniorDeveloper();
                                        employee.setJob_title(new SeniorDeveloper());
                                        employee.setSalary(seniorDeveloper.getMinSalary());
                                        boolean1 = true;
                                        break;
                                    }
                                    case 4: {
                                        TeamLead teamLead = new TeamLead();
                                        employee.setJob_title(new TeamLead());
                                        employee.setSalary(teamLead.getMinSalary());
                                        boolean1 = true;
                                        break;
                                    }
                                    default:
                                        System.out.println("Вы ввели неверное число. ");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Вы ввели не число. ");
                            }

                        }
                        while (!boolean1);


                    } else System.out.println("Вы ввели неверное число. ");
                } catch (NumberFormatException e) {
                    System.out.println("Вы ввели не число. ");
                }
            } while (!boolean1);


        } else if (oldDepartment == HR) {

            do {
                System.out.println("Впишите номер отдела: 1.Marketing 2. Development");
                try {
                    int choiceDep = Integer.parseInt(reader.readLine());
                    if (choiceDep == 1) {
                        int numTitle = 0;

                        do {
                            System.out.println("Введите номер должности: 1.Trainee, 2. Specialist, 3. Head of marketing");
                            try {
                                numTitle = Integer.parseInt(reader.readLine());
                                switch (numTitle) {
                                    case 1: {
                                        Trainee trainee = new Trainee();
                                        employee.setJob_title(new Trainee());
                                        employee.setSalary(trainee.getMinSalary());
                                        boolean1 = true;
                                        break;
                                    }
                                    case 2: {
                                        Specialist specialist = new Specialist();
                                        employee.setJob_title(new Specialist());
                                        employee.setSalary(specialist.getMinSalary());
                                        boolean1 = true;
                                        break;
                                    }
                                    case 3: {
                                        HeadOfMarketing headOfMarketing = new HeadOfMarketing();
                                        employee.setJob_title(new HeadOfMarketing());
                                        employee.setSalary(headOfMarketing.getMinSalary());
                                        boolean1 = true;
                                        break;
                                    }
                                    default:
                                        System.out.println("Вы ввели неверное число. ");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Вы ввели не число. ");
                            }

                        }
                        while (!boolean1);


                    } else if (choiceDep == 2) {
                        int numTitle = 0;
                           do {
                                System.out.println("Введите номер должности: 1.Junior developer, 2. Middle developer, 3.Senior developer, 4. Team lead");
                                try {
                                numTitle = Integer.parseInt(reader.readLine());
                                switch (numTitle) {
                                    case 1: {
                                        JuniorDeveloper juniorDeveloper = new JuniorDeveloper();
                                        employee.setJob_title(new JuniorDeveloper());
                                        employee.setSalary(juniorDeveloper.getMinSalary());
                                        boolean1 = true;
                                        break;
                                    }
                                    case 2: {
                                        MiddleDeveloper middleDeveloper = new MiddleDeveloper();
                                        employee.setJob_title(new MiddleDeveloper());
                                        employee.setSalary(middleDeveloper.getMinSalary());
                                        boolean1 = true;
                                        break;
                                    }
                                    case 3: {
                                        SeniorDeveloper seniorDeveloper = new SeniorDeveloper();
                                        employee.setJob_title(new SeniorDeveloper());
                                        employee.setSalary(seniorDeveloper.getMinSalary());
                                        boolean1 = true;
                                        break;
                                    }
                                    case 4: {
                                        TeamLead teamLead = new TeamLead();
                                        employee.setJob_title(new TeamLead());
                                        employee.setSalary(teamLead.getMinSalary());
                                        boolean1 = true;
                                        break;
                                    }
                                    default:
                                        System.out.println("Вы ввели неверное число. ");
                                }
                                } catch (NumberFormatException e) {
                                    System.out.println("Вы ввели не число. ");
                                }
                            }
                            while (!boolean1);

                    } else System.out.println("Вы ввели неверное число. ");
                } catch (NumberFormatException e) {
                    System.out.println("Вы ввели не число. ");
                }

            } while (!boolean1);


        } else if (oldDepartment == DEVELOPMENT) {


            do {
                System.out.println("Впишите номер отдела: 1.Marketing 2. HR");
                try {
                    int choiceDep = Integer.parseInt(reader.readLine());
                    if (choiceDep == 1) {
                        int numTitle = 0;

                            do {
                                System.out.println("Введите номер должности: 1.Trainee, 2. Specialist, 3. Head of marketing");
                                try {
                                numTitle = Integer.parseInt(reader.readLine());

                                switch (numTitle) {
                                    case 1: {
                                        Trainee trainee = new Trainee();
                                        employee.setJob_title(new Trainee());
                                        employee.setSalary(trainee.getMinSalary());
                                        boolean1 = true;
                                        break;
                                    }
                                    case 2: {
                                        Specialist specialist = new Specialist();
                                        employee.setJob_title(new Specialist());
                                        employee.setSalary(specialist.getMinSalary());
                                        boolean1 = true;
                                        break;
                                    }
                                    case 3: {
                                        HeadOfMarketing headOfMarketing = new HeadOfMarketing();
                                        employee.setJob_title(new HeadOfMarketing());
                                        employee.setSalary(headOfMarketing.getMinSalary());
                                        boolean1 = true;
                                        break;
                                    }
                                    default:
                                        System.out.println("Вы ввели неверное число. ");
                                }
                                } catch (NumberFormatException e) {
                                    System.out.println("Вы ввели не число. ");
                                }
                            }
                            while (!boolean1);

                    } else if (choiceDep == 2) {
                        int numTitle = 0;

                            do {
                                System.out.println("Введите номер должности: 1.Manager, 2. Senior manager, 3. Head of HR");
                                try {
                                    numTitle = Integer.parseInt(reader.readLine());
                                switch (numTitle) {
                                    case 1: {
                                        Manager manager = new Manager();
                                        employee.setJob_title(new Manager());
                                        employee.setSalary(manager.getMinSalary());
                                        boolean1 = true;
                                        break;
                                    }
                                    case 2: {
                                        SeniorManager seniorManager = new SeniorManager();
                                        employee.setJob_title(new SeniorManager());
                                        employee.setSalary(seniorManager.getMinSalary());
                                        boolean1 = true;
                                        break;
                                    }
                                    case 3: {
                                        HeadOfHr headOfHr = new HeadOfHr();
                                        employee.setJob_title(new HeadOfHr());
                                        employee.setSalary(headOfHr.getMinSalary());
                                        boolean1 = true;
                                        break;
                                    }
                                    default:
                                        System.out.println("Вы ввели неверное число. ");
                                }
                                } catch (NumberFormatException e) {
                                    System.out.println("Вы ввели не число. ");
                                }
                            }
                            while (!boolean1);

                    } else  System.out.println("Вы ввели неверное число. ");

                } catch (NumberFormatException e) {
                    System.out.println("Вы ввели не число. ");
                }

            } while (!boolean1);
        }
        employee.setLastChangeDate(LocalDate.now());
        System.out.println("Данные о работнике изменены ");

    }
}
