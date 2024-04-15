package Lessons.Employee_manager;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileManager implements Serializable {
    static final Path FILE_PATH = Path.of("employees.data");
    private static ArrayList<Employee> employees;

    public static void setEmployees() throws IOException {
        FileManager.employees = readEmployees();
    }

    public static ArrayList<Employee> getEmployees() {
        return employees;
    }

    public FileManager() {
    }

   public static void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public static void removeEmployee(Employee employee) {
        employees.remove(employee);

    }


    public static ArrayList<Employee> readEmployees() throws IOException {
        ArrayList<Employee> employees = new ArrayList<>();
        if (!Files.exists(Paths.get(String.valueOf(FILE_PATH)))) {
            Files.createFile(Paths.get(String.valueOf(FILE_PATH)));
        } else {
            try (ObjectInputStream inputObjectStream = new ObjectInputStream(new FileInputStream(String.valueOf(FILE_PATH)))) {
                while (true) {
                    try {
                        Employee employee = (Employee) inputObjectStream.readObject();
                        employees.add(employee);
                    } catch (EOFException e) {
                        break;
                    }
                }
            } catch (ClassNotFoundException|EOFException e) {
                System.out.println(e.getStackTrace());
            }
        }
        return employees;
    }

    public static void saveEmployees(ArrayList<Employee> listEmployees) throws IOException {
        try (ObjectOutputStream outputObjectStream = new ObjectOutputStream(new FileOutputStream(String.valueOf(FILE_PATH)))) {
            for (Employee e : listEmployees) {
                outputObjectStream.writeObject(e);
            }
        }

    }


}
