import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee("Alicia", "Engineering", 90000));
        employees.add(new Employee("Anna", "Marketing", 75000));
        employees.add(new Employee("Juan", "Engineering", 85000));
        employees.add(new Employee("Pepe", "HR", 60000));
        employees.add(new Employee("Marcos", "Marketing", 72000));
        employees.add(new Employee("Maria", "Engineering", 95000));

        // Employees sorted by salary (lowest to highest)
        List<Employee> filterSalary = employees.stream().sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())).toList();

        System.out.println("Employees sorted by salary (highest to lowest):");
        for(Employee e : filterSalary) {
            System.out.println(e.getName() + " - " + e.getDepartment() + " - $" + e.getSalary());
        }

        // Employees with salary greater than $50,000
        List<Employee> filterSalary50 = employees.stream().filter(e -> e.getSalary() > 50000).toList();

        System.out.println("\nEmployees with salary greater than $50,000:");
        for(Employee e : filterSalary50) {
            System.out.println(e.getName() + " - " + e.getDepartment() + " - $" + e.getSalary());
        }

        System.out.println();
        // Employee with the highest salary
        Employee highestSalaryEmployee = employees.stream().max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())).orElse(null);
        System.out.println("Employee with the highest salary: " + highestSalaryEmployee.getName());

        // Employees in the "Engineering" department
        List<Employee> engineeringEmployees = employees.stream().filter(e -> e.getDepartment().equals("Engineering")).toList();

        System.out.println("\nEmployees in the Engineering department:");

        for(int i = 0; i < engineeringEmployees.size(); i++) {
            if(i==0){
                System.out.print(engineeringEmployees.get(i).getName());
            }
            else{
                System.out.print(", " + engineeringEmployees.get(i).getName());
            }
        }

        // Average salary in the "Marketing" department
        Double average = employees.stream().filter(e -> e.getDepartment().equals("Marketing")).map(e -> e.getSalary()).reduce(0.0, Double::sum) / employees.stream().filter(e -> e.getDepartment().equals("Marketing")).count();

        System.out.println("\nAverage salary in Marketing department: $" + average);
    }
}