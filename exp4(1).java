import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    int id;
    String name;
    double salary;

    
    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // Display Employee details
    public void displayEmployee() {
        System.out.println("ID: " + id + ", Name: " + name + ", Salary: " + salary);
    }

    // Getter for ID
    public int getId() {
        return id;
    }
}

public class EmployeeManagement {
    // List to store employees
    private static ArrayList<Employee> employees = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Remove Employee");
            System.out.println("4. Search Employee");
            System.out.println("5. Display All Employees");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    updateEmployee();
                    break;
                case 3:
                    removeEmployee();
                    break;
                case 4:
                    searchEmployee();
                    break;
                case 5:
                    displayAllEmployees();
                    break;
                case 6:
                    System.out.println("Exiting the system.");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 6);
    }

    // Add an employee
    private static void addEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Employee Salary: ");
        double salary = scanner.nextDouble();

        Employee employee = new Employee(id, name, salary);
        employees.add(employee);
        System.out.println("Employee added successfully.");
    }

    // Update an employee's details
    private static void updateEmployee() {
        System.out.print("Enter Employee ID to update: ");
        int id = scanner.nextInt();
        Employee employee = findEmployeeById(id);

        if (employee != null) {
            scanner.nextLine(); // Consume the newline
            System.out.print("Enter new Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new Salary: ");
            double salary = scanner.nextDouble();

            employee.name = name;
            employee.salary = salary;
            System.out.println("Employee updated successfully.");
        } else {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    // Remove an employee by ID
    private static void removeEmployee() {
        System.out.print("Enter Employee ID to remove: ");
        int id = scanner.nextInt();
        Employee employee = findEmployeeById(id);

        if (employee != null) {
            employees.remove(employee);
            System.out.println("Employee removed successfully.");
        } else {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    // Search for an employee by ID
    private static void searchEmployee() {
        System.out.print("Enter Employee ID to search: ");
        int id = scanner.nextInt();
        Employee employee = findEmployeeById(id);

        if (employee != null) {
            employee.displayEmployee();
        } else {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    // Display all employees
    private static void displayAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            for (Employee employee : employees) {
                employee.displayEmployee();
            }
        }
    }

    // Helper method to find an employee by ID
    private static Employee findEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }
}
