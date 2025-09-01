/**
 * Represents a textbook with title, author, and publisher information.
 * This class is used in an aggregation relationship with the Course class,
 * demonstrating the "HAS-A" relationship pattern.
 * 
 * @author kkatsumi
 * @version 1.0
 * @since 2025
 */
public class Textbook {
    /** The textbook's title */
    private String title;
    
    /** The textbook's author */
    private String author;
    
    /** The textbook's publisher */
    private String publisher;
    
    /**
     * Constructs a Textbook with the specified title, author, and publisher.
     * 
     * @param title the textbook's title
     * @param author the textbook's author
     * @param publisher the textbook's publisher
     * @throws IllegalArgumentException if any parameter is null
     */
    public Textbook(String title, String author, String publisher) {
        if (title == null || author == null || publisher == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }
        this.title = title;
        this.author = author;
        this.publisher = publisher;
    }
    
    /**
     * Returns the textbook's title.
     * 
     * @return the textbook's title
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * Sets the textbook's title.
     * 
     * @param title the textbook's title
     * @throws IllegalArgumentException if title is null
     */
    public void setTitle(String title) {
        if (title == null) {
            throw new IllegalArgumentException("Title cannot be null");
        }
        this.title = title;
    }
    
    /**
     * Returns the textbook's author.
     * 
     * @return the textbook's author
     */
    public String getAuthor() {
        return author;
    }
    
    /**
     * Sets the textbook's author.
     * 
     * @param author the textbook's author
     * @throws IllegalArgumentException if author is null
     */
    public void setAuthor(String author) {
        if (author == null) {
            throw new IllegalArgumentException("Author cannot be null");
        }
        this.author = author;
    }
    
    /**
     * Returns the textbook's publisher.
     * 
     * @return the textbook's publisher
     */
    public String getPublisher() {
        return publisher;
    }
    
    /**
     * Sets the textbook's publisher.
     * 
     * @param publisher the textbook's publisher
     * @throws IllegalArgumentException if publisher is null
     */
    public void setPublisher(String publisher) {
        if (publisher == null) {
            throw new IllegalArgumentException("Publisher cannot be null");
        }
        this.publisher = publisher;
    }
}