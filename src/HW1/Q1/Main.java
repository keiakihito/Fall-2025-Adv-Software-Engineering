import java.util.ArrayList;
import java.util.List;

/**
 * Main driver program demonstrating the Employee inheritance hierarchy.
 * This program creates instances of different employee types, stores them in a collection,
 * and demonstrates key object-oriented programming concepts including inheritance,
 * polymorphism, and encapsulation.
 * 
 * @author CS5800 Student
 * @version 1.0
 * @since 2025
 */
public class Main {
    
    /**
     * Main method that executes the employee hierarchy demonstration.
     * Creates employees according to the assignment requirements and demonstrates
     * various OOP concepts through structured output sections.
     * 
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("===============================================");
        System.out.println("       CS5800 - HW1: Employee Hierarchy       ");
        System.out.println("===============================================\n");
        
        List<Employee> employees = createEmployees();
        
        System.out.println("1. EMPLOYEE ROSTER");
        System.out.println("==================");
        displayAllEmployees(employees);
        
        System.out.println("\n2. POLYMORPHISM DEMONSTRATION");
        System.out.println("==============================");
        demonstratePolymorphism(employees);
        
        System.out.println("\n3. EMPLOYEE TYPE ANALYSIS");
        System.out.println("==========================");
        analyzeEmployeeTypes(employees);
        
        System.out.println("\n4. ENCAPSULATION DEMONSTRATION");
        System.out.println("===============================");
        demonstrateEncapsulation(employees);
        
        System.out.println("\n5. INHERITANCE VERIFICATION");
        System.out.println("============================");
        verifyInheritance(employees);
    }
    
    /**
     * Creates and returns a list of employees with the test data specified in the assignment requirements.
     * The employees include different types: SalariedEmployee, HourlyEmployee, CommissionEmployee, and BaseEmployee.
     * 
     * @return a List containing all employee objects with the specified test data
     */
    private static List<Employee> createEmployees() {
        List<Employee> employees = new ArrayList<>();
        
        employees.add(new SalariedEmployee("Joe", "Jones", "111-11-1111", 2500.00));
        employees.add(new HourlyEmployee("Stephanie", "Smith", "222-22-2222", 25.00, 32));
        employees.add(new HourlyEmployee("Mary", "Quinn", "333-33-3333", 19.00, 47));
        employees.add(new CommissionEmployee("Nicole", "Dior", "444-44-4444", 0.15, 50000.00));
        employees.add(new SalariedEmployee("Renwa", "Chanel", "555-55-5555", 1700.00));
        employees.add(new BaseEmployee("Mike", "Davenport", "666-66-6666", 95000.00));
        employees.add(new CommissionEmployee("Mahnaz", "Vaziri", "777-77-7777", 0.22, 40000.00));
        
        return employees;
    }
    
    /**
     * Displays all employees in a numbered list format.
     * Each employee's information is shown using their toString() method.
     * 
     * @param employees the list of employees to display
     */
    private static void displayAllEmployees(List<Employee> employees) {
        for (int i = 0; i < employees.size(); i++) {
            Employee emp = employees.get(i);
            System.out.printf("Employee %d: %s\n", i + 1, emp.toString());
        }
    }
    
    /**
     * Demonstrates polymorphism by showing how different employee types
     * can be treated uniformly as Employee objects while maintaining their specific behavior.
     * 
     * @param employees the list of employees to demonstrate polymorphism with
     */
    private static void demonstratePolymorphism(List<Employee> employees) {
        System.out.println("All employees are stored in Employee[] array/list:");
        System.out.println("Each employee type responds to the same Employee interface:");
        
        for (Employee emp : employees) {
            System.out.printf("%-20s -> %s %s (SSN: %s)\n", 
                emp.getClass().getSimpleName(),
                emp.getFirstName(), 
                emp.getLastName(), 
                emp.getSocialSecurityNumber());
        }
    }
    
    /**
     * Analyzes and displays the distribution of different employee types in the collection.
     * Uses instanceof to count each employee type and displays statistics.
     * 
     * @param employees the list of employees to analyze
     */
    private static void analyzeEmployeeTypes(List<Employee> employees) {
        int salariedCount = 0, hourlyCount = 0, commissionCount = 0, baseCount = 0;
        
        for (Employee emp : employees) {
            if (emp instanceof SalariedEmployee) {
                salariedCount++;
            } else if (emp instanceof HourlyEmployee) {
                hourlyCount++;
            } else if (emp instanceof CommissionEmployee) {
                commissionCount++;
            } else if (emp instanceof BaseEmployee) {
                baseCount++;
            }
        }
        
        System.out.println("Employee Type Distribution:");
        System.out.printf("- SalariedEmployee:   %d employees\n", salariedCount);
        System.out.printf("- HourlyEmployee:     %d employees\n", hourlyCount);
        System.out.printf("- CommissionEmployee: %d employees\n", commissionCount);
        System.out.printf("- BaseEmployee:       %d employees\n", baseCount);
        System.out.printf("Total Employees:      %d\n", employees.size());
    }
    
    /**
     * Demonstrates encapsulation by showing how private fields are accessed
     * only through public getter and setter methods. Tests field modification
     * and restoration using the accessor/mutator methods.
     * 
     * @param employees the list of employees to demonstrate encapsulation with
     */
    private static void demonstrateEncapsulation(List<Employee> employees) {
        System.out.println("Testing private field access through getters/setters:");
        
        Employee firstEmployee = employees.get(0);
        System.out.printf("Original name: %s %s\n", 
            firstEmployee.getFirstName(), firstEmployee.getLastName());
        
        firstEmployee.setFirstName("Modified");
        System.out.printf("After setter:  %s %s\n", 
            firstEmployee.getFirstName(), firstEmployee.getLastName());
        
        firstEmployee.setFirstName("Joe");
        System.out.println("Name restored using setter.");
        
        if (employees.get(1) instanceof HourlyEmployee) {
            HourlyEmployee hourlyEmp = (HourlyEmployee) employees.get(1);
            System.out.printf("HourlyEmployee wage: $%.2f/hour, Hours: %d\n", 
                hourlyEmp.getWage(), hourlyEmp.getHoursWorked());
            
            hourlyEmp.setWage(30.00);
            hourlyEmp.setHoursWorked(40);
            System.out.printf("After modification:  $%.2f/hour, Hours: %d\n", 
                hourlyEmp.getWage(), hourlyEmp.getHoursWorked());
                
            hourlyEmp.setWage(25.00);
            hourlyEmp.setHoursWorked(32);
            System.out.println("Values restored using setters.");
        }
    }
    
    /**
     * Verifies the inheritance hierarchy by checking IS-A relationships
     * and demonstrating access to inherited methods from the base Employee class.
     * 
     * @param employees the list of employees to verify inheritance relationships for
     */
    private static void verifyInheritance(List<Employee> employees) {
        System.out.println("Inheritance Verification (IS-A relationships):");
        
        for (Employee emp : employees) {
            String className = emp.getClass().getSimpleName();
            boolean isEmployee = emp instanceof Employee;
            System.out.printf("%s IS-A Employee: %s\n", className, isEmployee);
        }
        
        System.out.println("\nAccessing inherited methods from base Employee class:");
        Employee anyEmployee = employees.get(0);
        System.out.printf("firstName getter:           %s\n", anyEmployee.getFirstName());
        System.out.printf("lastName getter:            %s\n", anyEmployee.getLastName());
        System.out.printf("socialSecurityNumber getter: %s\n", anyEmployee.getSocialSecurityNumber());
    }
}

/*
Sample Run

===============================================
       CS5800 - HW1: Employee Hierarchy       
===============================================

1. EMPLOYEE ROSTER
==================
Employee 1: Joe Jones (SSN: 111-11-1111) - Weekly Salary: $2500.00
Employee 2: Stephanie Smith (SSN: 222-22-2222) - Wage: $25.00/hour, Hours: 32
Employee 3: Mary Quinn (SSN: 333-33-3333) - Wage: $19.00/hour, Hours: 47
Employee 4: Nicole Dior (SSN: 444-44-4444) - Commission Rate: 15.0%, Gross Sales: $50000.00
Employee 5: Renwa Chanel (SSN: 555-55-5555) - Weekly Salary: $1700.00
Employee 6: Mike Davenport (SSN: 666-66-6666) - Base Salary: $95000.00
Employee 7: Mahnaz Vaziri (SSN: 777-77-7777) - Commission Rate: 22.0%, Gross Sales: $40000.00

2. POLYMORPHISM DEMONSTRATION
==============================
All employees are stored in Employee[] array/list:
Each employee type responds to the same Employee interface:
SalariedEmployee     -> Joe Jones (SSN: 111-11-1111)
HourlyEmployee       -> Stephanie Smith (SSN: 222-22-2222)
HourlyEmployee       -> Mary Quinn (SSN: 333-33-3333)
CommissionEmployee   -> Nicole Dior (SSN: 444-44-4444)
SalariedEmployee     -> Renwa Chanel (SSN: 555-55-5555)
BaseEmployee         -> Mike Davenport (SSN: 666-66-6666)
CommissionEmployee   -> Mahnaz Vaziri (SSN: 777-77-7777)

3. EMPLOYEE TYPE ANALYSIS
==========================
Employee Type Distribution:
- SalariedEmployee:   2 employees
- HourlyEmployee:     2 employees
- CommissionEmployee: 2 employees
- BaseEmployee:       1 employees
Total Employees:      7

4. ENCAPSULATION DEMONSTRATION
===============================
Testing private field access through getters/setters:
Original name: Joe Jones
After setter:  Modified Jones
Name restored using setter.
HourlyEmployee wage: $25.00/hour, Hours: 32
After modification:  $30.00/hour, Hours: 40
Values restored using setters.

5. INHERITANCE VERIFICATION
============================
Inheritance Verification (IS-A relationships):
SalariedEmployee IS-A Employee: true
HourlyEmployee IS-A Employee: true
HourlyEmployee IS-A Employee: true
CommissionEmployee IS-A Employee: true
SalariedEmployee IS-A Employee: true
BaseEmployee IS-A Employee: true
CommissionEmployee IS-A Employee: true

Accessing inherited methods from base Employee class:
firstName getter:           Joe
lastName getter:            Jones
socialSecurityNumber getter: 111-11-1111



*/