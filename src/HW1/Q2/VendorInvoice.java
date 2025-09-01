/**
 * Represents a vendor invoice that specifies an amount due to be paid.
 * This class implements the Payable interface and represents payments to vendors
 * for services or goods provided.
 * 
 * @author kkatsumi
 * @version 1.0
 * @since 2025
 */
public class VendorInvoice implements Payable {
    /** The name of the vendor to be paid */
    private String vendorName;
    
    /** The invoice number for tracking purposes */
    private String invoiceNumber;
    
    /** The amount due to be paid to the vendor */
    private double amountDue;
    
    /**
     * Constructs a VendorInvoice with the specified vendor information and amount due.
     * 
     * @param vendorName the name of the vendor
     * @param invoiceNumber the invoice number for reference
     * @param amountDue the amount due (must be >= 0)
     * @throws IllegalArgumentException if amountDue is negative
     */
    public VendorInvoice(String vendorName, String invoiceNumber, double amountDue) {
        this.vendorName = vendorName;
        this.invoiceNumber = invoiceNumber;
        setAmountDue(amountDue);
    }
    
    /**
     * Returns the vendor's name.
     * 
     * @return the vendor name
     */
    public String getVendorName() {
        return vendorName;
    }
    
    /**
     * Sets the vendor's name.
     * 
     * @param vendorName the new vendor name
     */
    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }
    
    /**
     * Returns the invoice number.
     * 
     * @return the invoice number
     */
    public String getInvoiceNumber() {
        return invoiceNumber;
    }
    
    /**
     * Sets the invoice number.
     * 
     * @param invoiceNumber the new invoice number
     */
    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }
    
    /**
     * Returns the amount due to the vendor.
     * 
     * @return the amount due
     */
    public double getAmountDue() {
        return amountDue;
    }
    
    /**
     * Sets the amount due to the vendor.
     * 
     * @param amountDue the new amount due (must be >= 0)
     * @throws IllegalArgumentException if amountDue is negative
     */
    public void setAmountDue(double amountDue) {
        if (amountDue < 0) {
            throw new IllegalArgumentException("Amount due cannot be negative");
        }
        this.amountDue = amountDue;
    }
    
    /**
     * Calculates the payment amount for this vendor invoice.
     * For vendor invoices, this simply returns the amount due.
     * 
     * @return the amount due as the payment amount
     */
    @Override
    public double calculatePayment() {
        return amountDue;
    }
    
    /**
     * Returns the vendor name as the payee name.
     * 
     * @return the vendor's name
     */
    @Override
    public String getPayeeName() {
        return vendorName;
    }
    
    /**
     * Prints the vendor invoice information including vendor name, invoice number, and payment amount.
     * Output format: "Vendor: [Vendor Name], Invoice: [Invoice Number] - Payment: $[Amount]"
     */
    public void print() {
        System.out.printf("Vendor: %s, Invoice: %s - Payment: $%.2f\n", 
                         vendorName, invoiceNumber, calculatePayment());
    }
}