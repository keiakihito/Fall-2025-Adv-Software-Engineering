/**
 * Represents a base Employee with fundamental employee information.
 * This class serves as the parent class for all employee types in the inheritance hierarchy.
 * 
 * @author CS5800 Student
 * @version 1.0
 * @since 2025
 */
public class Employee {
    /** The employee's first name */
    private String firstName;
    
    /** The employee's last name */
    private String lastName;
    
    /** The employee's social security number */
    private String socialSecurityNumber;
    
    /**
     * Constructs an Employee with the specified personal information.
     * 
     * @param firstName the employee's first name
     * @param lastName the employee's last name
     * @param socialSecurityNumber the employee's social security number
     */
    public Employee(String firstName, String lastName, String socialSecurityNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
    }
    
    /**
     * Returns the employee's first name.
     * 
     * @return the first name of the employee
     */
    public String getFirstName() {
        return firstName;
    }
    
    /**
     * Sets the employee's first name.
     * 
     * @param firstName the new first name for the employee
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    /**
     * Returns the employee's last name.
     * 
     * @return the last name of the employee
     */
    public String getLastName() {
        return lastName;
    }
    
    /**
     * Sets the employee's last name.
     * 
     * @param lastName the new last name for the employee
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    /**
     * Returns the employee's social security number.
     * 
     * @return the social security number of the employee
     */
    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }
    
    /**
     * Sets the employee's social security number.
     * 
     * @param socialSecurityNumber the new social security number for the employee
     */
    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }
    
    /**
     * Returns a string representation of the employee.
     * 
     * @return a formatted string containing the employee's name and social security number
     */
    @Override
    public String toString() {
        return String.format("%s %s (SSN: %s)", firstName, lastName, socialSecurityNumber);
    }
}