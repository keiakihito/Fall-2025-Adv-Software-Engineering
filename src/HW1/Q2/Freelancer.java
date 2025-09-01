/**
 * Represents a freelancer who is paid based on hourly rate and hours worked.
 * This class implements the Payable interface and includes overtime calculation
 * for hours worked beyond 40 hours per period.
 * 
 * @author CS5800 Student
 * @version 1.0
 * @since 2025
 */
public class Freelancer implements Payable {
    /** The freelancer's first name */
    private String firstName;
    
    /** The freelancer's last name */
    private String lastName;
    
    /** The hourly rate paid to the freelancer */
    private double hourlyRate;
    
    /** The number of hours worked by the freelancer */
    private double hoursWorked;
    
    /**
     * Constructs a Freelancer with the specified name, hourly rate, and hours worked.
     * 
     * @param firstName the freelancer's first name
     * @param lastName the freelancer's last name
     * @param hourlyRate the hourly rate (must be >= 0)
     * @param hoursWorked the hours worked (must be >= 0)
     * @throws IllegalArgumentException if hourlyRate or hoursWorked is negative
     */
    public Freelancer(String firstName, String lastName, double hourlyRate, double hoursWorked) {
        this.firstName = firstName;
        this.lastName = lastName;
        setHourlyRate(hourlyRate);
        setHoursWorked(hoursWorked);
    }
    
    /**
     * Returns the freelancer's first name.
     * 
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }
    
    /**
     * Sets the freelancer's first name.
     * 
     * @param firstName the new first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    /**
     * Returns the freelancer's last name.
     * 
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }
    
    /**
     * Sets the freelancer's last name.
     * 
     * @param lastName the new last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    /**
     * Returns the freelancer's hourly rate.
     * 
     * @return the hourly rate
     */
    public double getHourlyRate() {
        return hourlyRate;
    }
    
    /**
     * Sets the freelancer's hourly rate.
     * 
     * @param hourlyRate the new hourly rate (must be >= 0)
     * @throws IllegalArgumentException if hourlyRate is negative
     */
    public void setHourlyRate(double hourlyRate) {
        if (hourlyRate < 0) {
            throw new IllegalArgumentException("Hourly rate cannot be negative");
        }
        this.hourlyRate = hourlyRate;
    }
    
    /**
     * Returns the number of hours worked by the freelancer.
     * 
     * @return the hours worked
     */
    public double getHoursWorked() {
        return hoursWorked;
    }
    
    /**
     * Sets the number of hours worked by the freelancer.
     * 
     * @param hoursWorked the new hours worked (must be >= 0)
     * @throws IllegalArgumentException if hoursWorked is negative
     */
    public void setHoursWorked(double hoursWorked) {
        if (hoursWorked < 0) {
            throw new IllegalArgumentException("Hours worked cannot be negative");
        }
        this.hoursWorked = hoursWorked;
    }
    
    /**
     * Calculates the total payment for the freelancer based on hours worked and hourly rate.
     * For hours worked over 40, overtime is paid at 1.5 times the regular hourly rate.
     * 
     * @return the total payment amount
     */
    @Override
    public double calculatePayment() {
        if (hoursWorked <= 40) {
            return hourlyRate * hoursWorked;
        } else {
            double regularPay = hourlyRate * 40;
            double overtimeHours = hoursWorked - 40;
            double overtimePay = overtimeHours * (hourlyRate * 1.5);
            return regularPay + overtimePay;
        }
    }
    
    /**
     * Returns the full name of the freelancer as the payee name.
     * 
     * @return the freelancer's full name (firstName + " " + lastName)
     */
    @Override
    public String getPayeeName() {
        return firstName + " " + lastName;
    }
    
    /**
     * Prints the freelancer's information including name and calculated payment.
     * Output format: "Freelancer: [Full Name] - Payment: $[Amount]"
     */
    public void print() {
        System.out.printf("Freelancer: %s - Payment: $%.2f\n", getPayeeName(), calculatePayment());
    }
}