/**
 * Represents entities that can receive payments.
 * This interface defines the contract for calculating payment amounts and identifying payees.
 * It enables polymorphic treatment of different payable entities such as freelancers and vendors.
 * 
 * @author kkatsumi
 * @version 1.0
 * @since 2025
 */
public interface Payable {
    
    /**
     * Calculates the payment amount to be paid to this entity.
     * The calculation method varies depending on the implementing class:
     * - Freelancers: Based on hourly rate and hours worked (with overtime)
     * - Vendors: Based on invoice amount due
     * 
     * @return the payment amount as a double value
     */
    double calculatePayment();
    
    /**
     * Returns the name of the person or entity to be paid.
     * 
     * @return the payee's name as a String
     */
    String getPayeeName();
}