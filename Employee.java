import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employee {
    private int id;
    private String name;
    private String department;

    public Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    // Getters and Setters (Optional)
    // Implement getters and setters if you want to access and modify employee properties.

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Department: " + department;
    }
}

class HRMS {
    private List<Employee> employees;

    public HRMS() {
        employees = new ArrayList<>();
    }

    public void addEmployee(int id, String name, String department) {
        employees.add(new Employee(id, name, department));
    }

    public void listAllEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public Employee findEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }
}

public class HRMSApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HRMS hrms = new HRMS();

        // Sample data
        hrms.addEmployee(1, "John Doe", "Engineering");
        hrms.addEmployee(2, "Jane Smith", "Marketing");
        hrms.addEmployee(3, "Michael Johnson", "Finance");

        while (true) {
            System.out.println("\nHRMS Menu:");
            System.out.println("1. Add Employee");
            System.out.println("2. List All Employees");
            System.out.println("3. Find Employee by ID");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter Employee Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Employee Department: ");
                    String department = scanner.nextLine();
                    hrms.addEmployee(id, name, department);
                    System.out.println("Employee added successfully!");
                    break;
                case 2:
                    System.out.println("\nAll Employees:");
                    hrms.listAllEmployees();
                    break;
                case 3:
                    System.out.print("Enter Employee ID to search: ");
                    int searchId = scanner.nextInt();
                    Employee employee = hrms.findEmployeeById(searchId);
                    if (employee != null) {
                        System.out.println("\nEmployee Found:");
                        System.out.println(employee);
                    } else {
                        System.out.println("Employee not found!");
                    }
                    break;
                case 4:
                    System.out.println("Exiting HRMS. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
