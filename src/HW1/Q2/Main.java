import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("===============================================");
        System.out.println("       CS5800 - HW1: Payable Interface        ");
        System.out.println("===============================================\n");
        
        List<Payable> payables = createPayables();
        
        System.out.println("1. PAYABLE ENTITIES");
        System.out.println("===================");
        
        double totalPayout = 0.0;
        
        for (Payable payable : payables) {
            if (payable instanceof Freelancer) {
                ((Freelancer) payable).print();
            } else if (payable instanceof VendorInvoice) {
                ((VendorInvoice) payable).print();
            }
            totalPayout += payable.calculatePayment();
        }
        
        System.out.println("\n2. TOTAL PAYOUT CALCULATION");
        System.out.println("============================");
        System.out.printf("Total Amount to Pay: $%.2f\n", totalPayout);
        
        System.out.println("\n3. POLYMORPHISM DEMONSTRATION");
        System.out.println("==============================");
        demonstratePolymorphism(payables);
        
        System.out.println("\n4. PAYMENT BREAKDOWN BY TYPE");
        System.out.println("=============================");
        analyzePaymentTypes(payables);
    }
    
    private static List<Payable> createPayables() {
        List<Payable> payables = new ArrayList<>();
        
        payables.add(new Freelancer("Alice", "Johnson", 75.0, 35.0));
        payables.add(new Freelancer("Bob", "Smith", 60.0, 45.0));
        payables.add(new Freelancer("Carol", "Davis", 80.0, 20.0));
        
        payables.add(new VendorInvoice("Tech Supply Co.", "INV-2024-001", 2500.00));
        payables.add(new VendorInvoice("Office Materials Ltd.", "INV-2024-002", 1800.75));
        payables.add(new VendorInvoice("Consulting Services Inc.", "INV-2024-003", 5000.00));
        
        return payables;
    }
    
    private static void demonstratePolymorphism(List<Payable> payables) {
        System.out.println("All payables are handled uniformly via Payable interface:");
        
        for (Payable payable : payables) {
            System.out.printf("%-20s -> %s (Payment: $%.2f)\n", 
                payable.getClass().getSimpleName(),
                payable.getPayeeName(),
                payable.calculatePayment());
        }
    }
    
    private static void analyzePaymentTypes(List<Payable> payables) {
        double freelancerTotal = 0.0;
        double vendorTotal = 0.0;
        int freelancerCount = 0;
        int vendorCount = 0;
        
        for (Payable payable : payables) {
            if (payable instanceof Freelancer) {
                freelancerTotal += payable.calculatePayment();
                freelancerCount++;
            } else if (payable instanceof VendorInvoice) {
                vendorTotal += payable.calculatePayment();
                vendorCount++;
            }
        }
        
        System.out.printf("Freelancer Payments: %d freelancers, Total: $%.2f\n", 
                         freelancerCount, freelancerTotal);
        System.out.printf("Vendor Payments:     %d vendors, Total: $%.2f\n", 
                         vendorCount, vendorTotal);
        System.out.printf("Grand Total:         $%.2f\n", freelancerTotal + vendorTotal);
    }
}

/*
===============================================
       CS5800 - HW1: Payable Interface        
===============================================

1. PAYABLE ENTITIES
===================
Freelancer: Alice Johnson - Payment: $2625.00
Freelancer: Bob Smith - Payment: $2850.00
Freelancer: Carol Davis - Payment: $1600.00
Vendor: Tech Supply Co., Invoice: INV-2024-001 - Payment: $2500.00
Vendor: Office Materials Ltd., Invoice: INV-2024-002 - Payment: $1800.75
Vendor: Consulting Services Inc., Invoice: INV-2024-003 - Payment: $5000.00

2. TOTAL PAYOUT CALCULATION
============================
Total Amount to Pay: $16375.75

3. POLYMORPHISM DEMONSTRATION
==============================
All payables are handled uniformly via Payable interface:
Freelancer           -> Alice Johnson (Payment: $2625.00)
Freelancer           -> Bob Smith (Payment: $2850.00)
Freelancer           -> Carol Davis (Payment: $1600.00)
VendorInvoice        -> Tech Supply Co. (Payment: $2500.00)
VendorInvoice        -> Office Materials Ltd. (Payment: $1800.75)
VendorInvoice        -> Consulting Services Inc. (Payment: $5000.00)

4. PAYMENT BREAKDOWN BY TYPE
=============================
Freelancer Payments: 3 freelancers, Total: $7075.00
Vendor Payments:     3 vendors, Total: $9300.75
Grand Total:         $16375.75


 */