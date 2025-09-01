/**
 * Represents an hourly employee who is paid based on an hourly wage and hours worked.
 * This class extends the Employee base class and adds wage and hours-specific functionality.
 * 
 * @author kkatsumi
 * @version 1.0
 * @since 2025
 */
public class HourlyEmployee extends Employee {
    /** The employee's hourly wage rate */
    private double wage;
    
    /** The number of hours worked by the employee */
    private int hoursWorked;
    
    /**
     * Constructs an HourlyEmployee with the specified personal information, wage, and hours worked.
     * 
     * @param firstName the employee's first name
     * @param lastName the employee's last name
     * @param socialSecurityNumber the employee's social security number
     * @param wage the employee's hourly wage rate
     * @param hoursWorked the number of hours worked
     */
    public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber, double wage, int hoursWorked) {
        super(firstName, lastName, socialSecurityNumber);
        this.wage = wage;
        this.hoursWorked = hoursWorked;
    }
    
    /**
     * Returns the employee's hourly wage rate.
     * 
     * @return the hourly wage rate
     */
    public double getWage() {
        return wage;
    }
    
    /**
     * Sets the employee's hourly wage rate.
     * 
     * @param wage the new hourly wage rate
     */
    public void setWage(double wage) {
        this.wage = wage;
    }
    
    /**
     * Returns the number of hours worked by the employee.
     * 
     * @return the number of hours worked
     */
    public int getHoursWorked() {
        return hoursWorked;
    }
    
    /**
     * Sets the number of hours worked by the employee.
     * 
     * @param hoursWorked the new number of hours worked
     */
    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
    
    /**
     * Returns a string representation of the hourly employee.
     * 
     * @return a formatted string containing the employee's basic information, wage, and hours worked
     */
    @Override
    public String toString() {
        return String.format("%s - Wage: $%.2f/hour, Hours: %d", super.toString(), wage, hoursWorked);
    }
}