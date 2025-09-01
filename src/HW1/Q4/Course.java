/**
 * Represents a course that demonstrates aggregation relationships with Instructor and Textbook objects.
 * This class implements the "HAS-A" relationship pattern, where a Course has Instructor(s) and Textbook(s).
 * The class supports both single and multiple instructor/textbook configurations.
 * 
 * @author CS5800 Student
 * @version 1.0
 * @since 2025
 */
public class Course {
    /** The course name */
    private String courseName;
    
    /** Single instructor (used when course has one instructor) */
    private Instructor instructor;
    
    /** Single textbook (used when course has one textbook) */
    private Textbook textbook;
    
    /** Multiple instructors (used when course has multiple instructors) */
    private Instructor[] instructors;
    
    /** Multiple textbooks (used when course has multiple textbooks) */
    private Textbook[] textbooks;
    
    /**
     * Constructs a Course with a single instructor and single textbook.
     * 
     * @param courseName the name of the course
     * @param instructor the instructor for the course
     * @param textbook the textbook for the course
     * @throws IllegalArgumentException if any parameter is null
     */
    public Course(String courseName, Instructor instructor, Textbook textbook) {
        if (courseName == null || instructor == null || textbook == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }
        this.courseName = courseName;
        this.instructor = instructor;
        this.textbook = textbook;
        this.instructors = null;
        this.textbooks = null;
    }
    
    /**
     * Constructs a Course with multiple instructors and multiple textbooks.
     * 
     * @param courseName the name of the course
     * @param instructors the array of instructors for the course
     * @param textbooks the array of textbooks for the course
     * @throws IllegalArgumentException if any parameter is null
     */
    public Course(String courseName, Instructor[] instructors, Textbook[] textbooks) {
        if (courseName == null || instructors == null || textbooks == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }
        this.courseName = courseName;
        this.instructor = null;
        this.textbook = null;
        this.instructors = instructors;
        this.textbooks = textbooks;
    }
    
    /**
     * Returns the course name.
     * 
     * @return the course name
     */
    public String getCourseName() {
        return courseName;
    }
    
    /**
     * Sets the course name.
     * 
     * @param courseName the course name
     * @throws IllegalArgumentException if courseName is null
     */
    public void setCourseName(String courseName) {
        if (courseName == null) {
            throw new IllegalArgumentException("Course name cannot be null");
        }
        this.courseName = courseName;
    }
    
    /**
     * Returns the single instructor for this course.
     * 
     * @return the instructor, or null if multiple instructors are used
     */
    public Instructor getInstructor() {
        return instructor;
    }
    
    /**
     * Sets a single instructor for this course.
     * This will clear any multiple instructors configuration.
     * 
     * @param instructor the instructor to set
     * @throws IllegalArgumentException if instructor is null
     */
    public void setInstructor(Instructor instructor) {
        if (instructor == null) {
            throw new IllegalArgumentException("Instructor cannot be null");
        }
        this.instructor = instructor;
        this.instructors = null;
    }
    
    /**
     * Returns the single textbook for this course.
     * 
     * @return the textbook, or null if multiple textbooks are used
     */
    public Textbook getTextbook() {
        return textbook;
    }
    
    /**
     * Sets a single textbook for this course.
     * This will clear any multiple textbooks configuration.
     * 
     * @param textbook the textbook to set
     * @throws IllegalArgumentException if textbook is null
     */
    public void setTextbook(Textbook textbook) {
        if (textbook == null) {
            throw new IllegalArgumentException("Textbook cannot be null");
        }
        this.textbook = textbook;
        this.textbooks = null;
    }
    
    /**
     * Returns the array of instructors for this course.
     * 
     * @return the array of instructors, or null if single instructor is used
     */
    public Instructor[] getInstructors() {
        return instructors;
    }
    
    /**
     * Sets multiple instructors for this course.
     * This will clear any single instructor configuration.
     * 
     * @param instructors the array of instructors to set
     * @throws IllegalArgumentException if instructors is null
     */
    public void setInstructors(Instructor[] instructors) {
        if (instructors == null) {
            throw new IllegalArgumentException("Instructors cannot be null");
        }
        this.instructors = instructors;
        this.instructor = null;
    }
    
    /**
     * Returns the array of textbooks for this course.
     * 
     * @return the array of textbooks, or null if single textbook is used
     */
    public Textbook[] getTextbooks() {
        return textbooks;
    }
    
    /**
     * Sets multiple textbooks for this course.
     * This will clear any single textbook configuration.
     * 
     * @param textbooks the array of textbooks to set
     * @throws IllegalArgumentException if textbooks is null
     */
    public void setTextbooks(Textbook[] textbooks) {
        if (textbooks == null) {
            throw new IllegalArgumentException("Textbooks cannot be null");
        }
        this.textbooks = textbooks;
        this.textbook = null;
    }
    
    /**
     * Prints the course information including course name, instructor(s), and textbook(s).
     * The format adapts based on whether single or multiple instructors/textbooks are configured.
     */
    public void print() {
        System.out.println("Course: " + courseName);
        
        if (instructor != null && textbook != null) {
            System.out.println("Instructor: " + instructor.getFirstName() + " " + instructor.getLastName());
            System.out.println("Textbook: " + textbook.getTitle() + " by " + textbook.getAuthor());
        } else if (instructors != null && textbooks != null) {
            System.out.println("Instructors:");
            for (Instructor inst : instructors) {
                System.out.println("  - " + inst.getFirstName() + " " + inst.getLastName());
            }
            System.out.println("Textbooks:");
            for (Textbook tb : textbooks) {
                System.out.println("  - " + tb.getTitle() + " by " + tb.getAuthor());
            }
        }
    }
}