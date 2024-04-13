package Lessons.Employee_manager;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileManager implements Serializable {

    public static ArrayList<Employee> employees = null;

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
        if (!Files.exists(Paths.get("employees.data"))) {
            Files.createFile(Paths.get("employees.data"));
        } else {
            try (ObjectInputStream inputObjectStream = new ObjectInputStream(new FileInputStream("employees.data"))) {
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
        try (ObjectOutputStream outputObjectStream = new ObjectOutputStream(new FileOutputStream("employees.data"))) {
            for (Employee e : listEmployees) {
                outputObjectStream.writeObject(e);
            }
        }

    }


}
