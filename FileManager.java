package Lessons.Employee_manager;

import java.util.ArrayList;

public class FileManager {
    public static  ArrayList<Employee> employees = new ArrayList<>();

    public static void addEmployee( Employee employee){
        employees.add(employee);
    }

    public static void removeEmployee( Employee employee){
        employees.remove(employee);

    }


}
