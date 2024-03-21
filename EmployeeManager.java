package Lessons.Employee_manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDate;

import static Lessons.Employee_manager.FileManager.employees;


public class EmployeeManager {
    private final static Character[] CHARS = new Character[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', ';', '.', ':', '&', '!', '?', '*', '\'', '-', '_', '=', '+', '{', '}', '[', ']', '@', '"', '\\'};

    public static void createEmployee(BufferedReader reader) throws IOException {
        String name, surname;
        int department = 0, salary = 0;

        reader = new BufferedReader(new InputStreamReader(System.in));
        int count;

        do {
            System.out.println("Внесение данных нового работника: " + "\n" + "Введите имя");
            name = reader.readLine();
            count = 0;
            for (int i = 0; i < name.length(); i++) {
                for (int j = 0; j < CHARS.length; j++) {
                    if (name.charAt(i) == CHARS[j]) count++;
                }
            }
            if (count > 0) System.out.println("Вы ввели недопустимые символы. Попробуйте снова");

        } while (count > 0);


        do {
            System.out.println("Введите фамилию");
            surname = reader.readLine();
            count = 0;
            for (int i = 0; i < surname.length(); i++) {
                for (int j = 0; j < CHARS.length; j++) {
                    if (surname.charAt(i) == CHARS[j]) count++;
                }
            }
            if (count > 0) System.out.println("Вы ввели недопустимые символы. Попробуйте снова");

        } while (count > 0);

        boolean rightDepartment = false;
        Object nameTitle = new Manager();
        do {
            System.out.println("Укажите цифру, из перечисленных должностей: " + "\n" +
                    "отдел Marketing :  1. Trainee, 2. Specialist, 3. Head of marketing " + "\n" +
                    "отдел HR : 4. Manager, 5. Senior manager, 6. Head of HR" + "\n" +
                    "отдел Development : 7. Junior developer, 8. Middle developer, 9. Senior developer, 10. Team lead");
            try {
                department = Integer.parseInt(reader.readLine());
                switch (department) {
                    case 1: {
                        nameTitle = new Trainee();
                        rightDepartment = true;
                        break;
                    }
                    case 2: {
                        nameTitle = new Specialist();
                        rightDepartment = true;
                        break;
                    }
                    case 3: {
                        nameTitle = new HeadOfMarketing();
                        rightDepartment = true;
                        break;
                    }
                    case 4: {
                        nameTitle = new Manager();
                        rightDepartment = true;
                        break;
                    }
                    case 5: {
                        nameTitle = new SeniorManager();
                        rightDepartment = true;
                        break;
                    }
                    case 6: {
                        nameTitle = new HeadOfHr();
                        rightDepartment = true;
                        break;
                    }
                    case 7: {
                        nameTitle = new JuniorDeveloper();
                        rightDepartment = true;
                        break;
                    }
                    case 8: {
                        nameTitle = new MiddleDeveloper();
                        rightDepartment = true;
                        break;
                    }
                    case 9: {
                        nameTitle = new SeniorManager();
                        rightDepartment = true;
                        break;
                    }
                    case 10: {
                        nameTitle = new TeamLead();
                        rightDepartment = true;
                        break;
                    }
                    default:
                        System.out.println("Вы ввели неверное число. ");
                }

            } catch (NumberFormatException e) {
                System.out.println("Вы ввели не число. ");
            }
        }

        while (!rightDepartment);

        boolean rightSalary = false;
        do {
            System.out.println("Введите данные о заработной плате: " + "\n" +
                    "Для справки: отдел Marketing:  1. Trainee (от 300 до 600), 2. Specialist (от 500 до 1200), 3. Head of marketing (от 1000 до 2000)" +
                    "отдел HR: 4. Manager (от 400 до 800), 5. Senior manager (от 700 до 1100), 6. Head of HR (от 800 до 1700)" + "\n" +
                    "отдел Development: 7. Junior developer (от 400 до 1000), 8. Middle developer (от 800 до 2000), 9. Senior developer (от 1800 до 4000), 10. Team lead (от 2500 до 7000)");
            try {
                salary = Integer.parseInt(reader.readLine());
                switch (department) {
                    case 1: {
                        if (salary >= 300 && salary <= 600) {
                            rightSalary = true;
                        } else System.out.println("Вы ввели неверные данные. ");
                        break;
                    }
                    case 2: {
                        if (salary >= 500 && salary <= 1200) {
                            rightSalary = true;
                        } else System.out.println("Вы ввели неверные данные. ");
                        break;
                    }
                    case 3: {
                        if (salary >= 1000 && salary <= 2000) {
                            rightSalary = true;
                        } else System.out.println("Вы ввели неверные данные. ");
                        break;
                    }
                    case 4: {
                        if (salary >= 400 && salary <= 800) {
                            rightSalary = true;
                        } else System.out.println("Вы ввели неверные данные. ");
                        break;
                    }
                    case 5: {
                        if (salary >= 700 && salary <= 1100) {
                            rightSalary = true;
                        } else System.out.println("Вы ввели неверные данные. ");
                        break;
                    }
                    case 6: {
                        if (salary >= 800 && salary <= 1700) {
                            rightSalary = true;
                        } else System.out.println("Вы ввели неверные данные. ");
                        break;
                    }
                    case 7: {
                        if (salary >= 400 && 1100 >= salary) {
                            rightSalary = true;

                        } else System.out.println("Вы ввели неверные данные. ");
                        break;
                    }
                    case 8: {
                        if (salary >= 800 && salary <= 2000) {
                            rightSalary = true;
                        } else System.out.println("Вы ввели неверные данные. ");
                        break;
                    }
                    case 9: {
                        if (salary >= 1800 && salary <= 4000) {
                            rightSalary = true;
                        } else System.out.println("Вы ввели неверные данные. ");
                        break;
                    }
                    case 10: {
                        if (salary >= 2500 && salary <= 7000) {
                            rightSalary = true;
                        } else System.out.println("Вы ввели неверные данные. ");
                        break;
                    }
                    default:
                        System.out.println("Вы ввели неверные данные. ");
                }
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели не число. ");
            }
        } while (!rightSalary);


        LocalDate today = LocalDate.now();

        int lastId = employees.get(employees.size() - 1).getID() + 1;
        Employee employee = new Employee(name, surname, lastId, (Position) nameTitle, new BigDecimal(salary), today);
        employees.add(employee);

        System.out.println("Данные о работнике внесены.");
    }

    public static void removeEmployee(BufferedReader reader) throws IOException {
        System.out.println("Cписок сотрудников: ");
        int count = 1;
        for (Employee e : employees) {
            System.out.println(count + " " + e);
            count++;
        }
        boolean rightRemovenum = false;
        int Removenum = 0;
        do {
            System.out.println("Напишите порядковый номер сотрудника из списка для удаления информации");
            try {
                Removenum = Integer.parseInt(reader.readLine());
                for (int i = 0; i < employees.size(); i++) {
                    if (Removenum - 1 == i) {

                        FileManager.removeEmployee(employees.get(Removenum - 1));
                        rightRemovenum = true;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели не число. ");
            }
        } while (!rightRemovenum);
    }


    public static void main(String[] args) throws IOException {

        Employee employee1 = new Employee("Adam", "Smith", 1, new HeadOfMarketing(), new BigDecimal(1500), LocalDate.of(2023, 5, 15));
        Employee employee2 = new Employee("Joey", "Jordison", 2, new MiddleDeveloper(), new BigDecimal(1300), LocalDate.of(2022, 4, 20));
        Employee employee3 = new Employee("Corey", "Taylor", 3, new SeniorManager(), new BigDecimal(1000), LocalDate.of(2022, 6, 21));
        Employee employee4 = new Employee("Jim", "Root", 4, new TeamLead(), new BigDecimal(4500), LocalDate.of(2020, 3, 5));
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);


        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String choice = "0";
            try {
                do {

                    System.out.println("Введите номер действия (1, 2, 3, 4  или 5): " + "\n" +
                            "1. Распечатать список 2. Внести данные нового работника 3. Удалить данные о работнике 4.Изменить должность работника 5. Выход из программы ");

                    choice = reader.readLine();
                    if (Integer.parseInt(choice) == 1) {
                        for (Employee e : employees) {
                            System.out.println(e);
                        }
                    } else if (Integer.parseInt(choice) == 2) {
                        createEmployee(reader);
                    } else if (Integer.parseInt(choice) == 3) {
                        removeEmployee(reader);
                    } else if (Integer.parseInt(choice) == 4) {
                        int count = 1;
                        for (Employee e : employees) {
                            System.out.println(count + " " + e);
                            count++;
                        }
                        int choiceEmployee = 0;
                        boolean booleanDepart = false;
                        do {
                            System.out.println("Впишите порядковый номер работника ");
                            try {
                                choiceEmployee = Integer.parseInt(reader.readLine());
                                if (choiceEmployee > employees.size() || choiceEmployee < 1)
                                    System.out.println("Вы ввели неверное число. ");
                                else {
                                    for (int i = 0; i < employees.size(); i++) {
                                        if (choiceEmployee - 1 == i) {
                                            DepartmentManager.changeDepartment(employees.get(choiceEmployee - 1));
                                            booleanDepart = true;
                                            break;
                                        }
                                    }
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Вы ввели не число. ");
                            }

                        } while (!booleanDepart);
                    } else System.out.println("Вы ввели неверное число. ");


                }
                while (Integer.parseInt(choice) != 5);
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели не число. ");

            }

        }

    }
}

