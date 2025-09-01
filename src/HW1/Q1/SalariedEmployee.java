/**
 * Represents a salaried employee who receives a fixed weekly salary.
 * This class extends the Employee base class and adds salary-specific functionality.
 * 
 * @author kkatsumi
 * @version 1.0
 * @since 2025
 */
public class SalariedEmployee extends Employee {
    /** The employee's weekly salary amount */
    private double weeklySalary;
    
    /**
     * Constructs a SalariedEmployee with the specified personal information and salary.
     * 
     * @param firstName the employee's first name
     * @param lastName the employee's last name
     * @param socialSecurityNumber the employee's social security number
     * @param weeklySalary the employee's weekly salary amount
     */
    public SalariedEmployee(String firstName, String lastName, String socialSecurityNumber, double weeklySalary) {
        super(firstName, lastName, socialSecurityNumber);
        this.weeklySalary = weeklySalary;
    }
    
    /**
     * Returns the employee's weekly salary.
     * 
     * @return the weekly salary amount
     */
    public double getWeeklySalary() {
        return weeklySalary;
    }
    
    /**
     * Sets the employee's weekly salary.
     * 
     * @param weeklySalary the new weekly salary amount
     */
    public void setWeeklySalary(double weeklySalary) {
        this.weeklySalary = weeklySalary;
    }
    
    /**
     * Returns a string representation of the salaried employee.
     * 
     * @return a formatted string containing the employee's basic information and weekly salary
     */
    @Override
    public String toString() {
        return String.format("%s - Weekly Salary: $%.2f", super.toString(), weeklySalary);
    }
}