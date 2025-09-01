/**
 * Represents an instructor with personal information and office details.
 * This class is used in an aggregation relationship with the Course class,
 * demonstrating the "HAS-A" relationship pattern.
 * 
 * @author kkatsumi
 * @version 1.0
 * @since 2025
 */
public class Instructor {
    /** The instructor's first name */
    private String firstName;
    
    /** The instructor's last name */
    private String lastName;
    
    /** The instructor's office number */
    private String officeNumber;
    
    /**
     * Constructs an Instructor with the specified personal and office information.
     * 
     * @param firstName the instructor's first name
     * @param lastName the instructor's last name
     * @param officeNumber the instructor's office number
     * @throws IllegalArgumentException if any parameter is null
     */
    public Instructor(String firstName, String lastName, String officeNumber) {
        if (firstName == null || lastName == null || officeNumber == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.officeNumber = officeNumber;
    }
    
    /**
     * Returns the instructor's first name.
     * 
     * @return the instructor's first name
     */
    public String getFirstName() {
        return firstName;
    }
    
    /**
     * Sets the instructor's first name.
     * 
     * @param firstName the instructor's first name
     * @throws IllegalArgumentException if firstName is null
     */
    public void setFirstName(String firstName) {
        if (firstName == null) {
            throw new IllegalArgumentException("First name cannot be null");
        }
        this.firstName = firstName;
    }
    
    /**
     * Returns the instructor's last name.
     * 
     * @return the instructor's last name
     */
    public String getLastName() {
        return lastName;
    }
    
    /**
     * Sets the instructor's last name.
     * 
     * @param lastName the instructor's last name
     * @throws IllegalArgumentException if lastName is null
     */
    public void setLastName(String lastName) {
        if (lastName == null) {
            throw new IllegalArgumentException("Last name cannot be null");
        }
        this.lastName = lastName;
    }
    
    /**
     * Returns the instructor's office number.
     * 
     * @return the instructor's office number
     */
    public String getOfficeNumber() {
        return officeNumber;
    }
    
    /**
     * Sets the instructor's office number.
     * 
     * @param officeNumber the instructor's office number
     * @throws IllegalArgumentException if officeNumber is null
     */
    public void setOfficeNumber(String officeNumber) {
        if (officeNumber == null) {
            throw new IllegalArgumentException("Office number cannot be null");
        }
        this.officeNumber = officeNumber;
    }
}