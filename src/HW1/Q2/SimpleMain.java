import java.util.ArrayList;

public class SimpleMain {
    public static void main(String[] args) {
        System.out.println("CS5800 - HW1 Q2: Payable Interface Implementation");
        System.out.println("=================================================\n");
        
        // 1. Create ArrayList<Payable>
        ArrayList<Payable> payables = new ArrayList<>();
        
        // 2. Populate with at least 4 objects (2+ Freelancers, 2+ VendorInvoices)
        payables.add(new Freelancer("Alice", "Johnson", 75.0, 35.0));      // Regular hours
        payables.add(new Freelancer("Bob", "Smith", 60.0, 45.0));          // Overtime hours
        payables.add(new VendorInvoice("Tech Supply Co.", "INV-2024-001", 2500.00));
        payables.add(new VendorInvoice("Office Materials Ltd.", "INV-2024-002", 1800.75));
        
        System.out.println("Processing Payable Entities:");
        System.out.println("=============================");
        
        double totalPayout = 0.0;
        
        // 3. Loop through collection
        for (Payable payable : payables) {
            // Call print() for each element
            if (payable instanceof Freelancer) {
                ((Freelancer) payable).print();
            } else if (payable instanceof VendorInvoice) {
                ((VendorInvoice) payable).print();
            }
            
            // Call calculatePayment() and accumulate total
            totalPayout += payable.calculatePayment();
        }
        
        // 4. Display total payout
        System.out.println("\n=============================");
        System.out.printf("Total Payout: $%.2f\n", totalPayout);
        System.out.println("=============================");
    }
}