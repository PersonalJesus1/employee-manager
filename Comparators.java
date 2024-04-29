package Lessons.Employee_manager;

import java.util.Comparator;

public class Comparators {
    static class SalaryComparator implements Comparator<Employee> {
        public int compare(Employee e1, Employee e2) {
            return e1.getSalary().compareTo(e2.getSalary());
        }
    }
    static class DepartmentComparator implements Comparator<Employee> {
        public int compare(Employee e1, Employee e2) {
            return e1.getJobTitle().getDepartment().getTitle().compareTo(e2.getJobTitle().getDepartment().getTitle());
        }
    }
}
