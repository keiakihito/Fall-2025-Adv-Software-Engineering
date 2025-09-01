/**
 * Represents a base employee who receives a fixed annual base salary.
 * This class extends the Employee base class and adds base salary functionality.
 * 
 * @author CS5800 Student
 * @version 1.0
 * @since 2025
 */
public class BaseEmployee extends Employee {
    /** The employee's annual base salary amount */
    private double baseSalary;
    
    /**
     * Constructs a BaseEmployee with the specified personal information and base salary.
     * 
     * @param firstName the employee's first name
     * @param lastName the employee's last name
     * @param socialSecurityNumber the employee's social security number
     * @param baseSalary the employee's annual base salary amount
     */
    public BaseEmployee(String firstName, String lastName, String socialSecurityNumber, double baseSalary) {
        super(firstName, lastName, socialSecurityNumber);
        this.baseSalary = baseSalary;
    }
    
    /**
     * Returns the employee's annual base salary.
     * 
     * @return the base salary amount
     */
    public double getBaseSalary() {
        return baseSalary;
    }
    
    /**
     * Sets the employee's annual base salary.
     * 
     * @param baseSalary the new base salary amount
     */
    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }
    
    /**
     * Returns a string representation of the base employee.
     * 
     * @return a formatted string containing the employee's basic information and base salary
     */
    @Override
    public String toString() {
        return String.format("%s - Base Salary: $%.2f", super.toString(), baseSalary);
    }
}