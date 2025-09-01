import Tests.FreelancerTest;
import Tests.PayableTest;

public class TestRunner {
    public static void main(String[] args) {
        System.out.println("===========================================");
        System.out.println("  PAYABLE INTERFACE QUALITY TEST SUITE   ");
        System.out.println("===========================================\n");
        
        try {
            PayableTest.runTests();
            FreelancerTest.runTests();
            VendorInvoiceTest.runTests();
            
            System.out.println("===========================================");
            System.out.println("         INTEGRATION TESTS               ");
            System.out.println("===========================================");
            testIntegration();
            
            System.out.println("\n===========================================");
            System.out.println("        POLYMORPHISM TESTS                ");
            System.out.println("===========================================");
            testPolymorphismAdvanced();
            
            System.out.println("\n===========================================");
            System.out.println("         VALIDATION TESTS                 ");
            System.out.println("===========================================");
            testValidationScenarios();
            
            System.out.println("\n===========================================");
            System.out.println("         BUSINESS LOGIC TESTS             ");
            System.out.println("===========================================");
            testBusinessLogic();
            
            System.out.println("\n===========================================");
            System.out.println("            ALL TESTS COMPLETED            ");
            System.out.println("===========================================");
            
        } catch (Exception e) {
            System.out.println("✗ Critical error during testing: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private static void testIntegration() {
        try {
            // Test that all components work together
            Payable[] payables = {
                new Freelancer("John", "Developer", 100.0, 45.0), // overtime
                new VendorInvoice("Hardware Store", "HW-001", 2500.0),
                new Freelancer("Jane", "Designer", 85.0, 30.0), // regular
                new VendorInvoice("Software License", "SW-002", 1200.0)
            };
            
            double totalExpected = 0.0;
            for (Payable p : payables) {
                totalExpected += p.calculatePayment();
            }
            
            // Freelancer 1: 40*100 + 5*150 = 4000 + 750 = 4750
            // Vendor 1: 2500
            // Freelancer 2: 30*85 = 2550
            // Vendor 2: 1200
            // Total: 11000
            
            assert Math.abs(totalExpected - 11000.0) < 0.01 : "Integration calculation failed";
            System.out.println("✓ Integration test passed - Total payout: $" + totalExpected);
            
        } catch (Exception e) {
            System.out.println("✗ Integration test failed: " + e.getMessage());
        }
    }
    
    private static void testPolymorphismAdvanced() {
        try {
            // Test polymorphic behavior in various scenarios
            java.util.List<Payable> payableList = new java.util.ArrayList<>();
            payableList.add(new Freelancer("Alice", "Writer", 50.0, 25.0));
            payableList.add(new VendorInvoice("Print Shop", "PRT-100", 800.0));
            payableList.add(new Freelancer("Bob", "Editor", 75.0, 50.0)); // overtime
            
            // Test polymorphic method calls
            for (Payable payable : payableList) {
                assert payable.calculatePayment() > 0 : "All payables should have positive payment";
                assert payable.getPayeeName() != null : "All payables should have non-null payee name";
            }
            
            // Test instance checking still works
            int freelancerCount = 0;
            int vendorCount = 0;
            for (Payable payable : payableList) {
                if (payable instanceof Freelancer) {
                    freelancerCount++;
                } else if (payable instanceof VendorInvoice) {
                    vendorCount++;
                }
            }
            
            assert freelancerCount == 2 : "Should have 2 freelancers";
            assert vendorCount == 1 : "Should have 1 vendor";
            
            System.out.println("✓ Advanced polymorphism test passed");
            
        } catch (Exception e) {
            System.out.println("✗ Advanced polymorphism test failed: " + e.getMessage());
        }
    }
    
    private static void testValidationScenarios() {
        try {
            // Test various validation scenarios
            
            // Test boundary values for freelancer
            Freelancer exactlyForty = new Freelancer("Test", "User", 50.0, 40.0);
            assert exactlyForty.calculatePayment() == 2000.0 : "Exactly 40 hours should not trigger overtime";
            
            Freelancer justOverForty = new Freelancer("Test", "User", 50.0, 40.01);
            double expectedPayment = 40 * 50 + 0.01 * 50 * 1.5;
            assert Math.abs(justOverForty.calculatePayment() - expectedPayment) < 0.01 : "Just over 40 hours should trigger minimal overtime";
            
            // Test zero values
            VendorInvoice zeroInvoice = new VendorInvoice("Free Service", "FREE-001", 0.0);
            assert zeroInvoice.calculatePayment() == 0.0 : "Zero amount invoice should work";
            
            Freelancer zeroHours = new Freelancer("Inactive", "Worker", 100.0, 0.0);
            assert zeroHours.calculatePayment() == 0.0 : "Zero hours should result in zero payment";
            
            System.out.println("✓ Validation scenarios test passed");
            
        } catch (Exception e) {
            System.out.println("✗ Validation scenarios test failed: " + e.getMessage());
        }
    }
    
    private static void testBusinessLogic() {
        try {
            // Test realistic business scenarios
            
            // Scenario 1: Part-time freelancer
            Freelancer partTime = new Freelancer("Sarah", "Consultant", 120.0, 15.0);
            assert partTime.calculatePayment() == 1800.0 : "Part-time calculation failed";
            
            // Scenario 2: Heavy overtime freelancer
            Freelancer overtime = new Freelancer("Mike", "Developer", 80.0, 60.0);
            // 40 * 80 + 20 * 120 = 3200 + 2400 = 5600
            assert overtime.calculatePayment() == 5600.0 : "Heavy overtime calculation failed";
            
            // Scenario 3: Large vendor invoice
            VendorInvoice largeVendor = new VendorInvoice("Enterprise Corp", "ENT-2024-001", 25000.0);
            assert largeVendor.calculatePayment() == 25000.0 : "Large vendor invoice failed";
            
            // Scenario 4: Multiple small invoices
            VendorInvoice[] smallInvoices = {
                new VendorInvoice("Coffee Shop", "CF-001", 45.50),
                new VendorInvoice("Taxi Service", "TX-002", 22.75),
                new VendorInvoice("Parking Meter", "PM-003", 8.25)
            };
            
            double smallTotal = 0.0;
            for (VendorInvoice invoice : smallInvoices) {
                smallTotal += invoice.calculatePayment();
            }
            assert Math.abs(smallTotal - 76.50) < 0.01 : "Small invoices total failed";
            
            System.out.println("✓ Business logic test passed");
            
        } catch (Exception e) {
            System.out.println("✗ Business logic test failed: " + e.getMessage());
        }
    }
}

/*
Sample Run

===========================================
  PAYABLE INTERFACE QUALITY TEST SUITE   
===========================================

Testing Payable Interface Functionality
=======================================
✓ Payable interface implementation test passed
✓ Polymorphic behavior test passed
✓ Interface implementation test passed

Payable Interface Test Results: 3/3 tests passed

Testing Freelancer Class
========================
✓ Constructor test passed
✓ Getters and Setters test passed
✓ Regular hours payment test passed
✓ Overtime payment test passed
✓ Edge case payments test passed
✓ Input validation test passed
✓ Payable interface methods test passed
Freelancer: Test User - Payment: $1000.00
✓ Print method test passed

Freelancer Test Results: 8/8 tests passed

Testing VendorInvoice Class
===========================
✓ Constructor test passed
✓ Getters and Setters test passed
✓ Payment calculation test passed
✓ Input validation test passed
✓ Payable interface methods test passed
Vendor: Test Vendor, Invoice: TEST-001 - Payment: $1234.56
✓ Print method test passed
✓ Edge cases test passed

VendorInvoice Test Results: 7/7 tests passed

===========================================
         INTEGRATION TESTS               
===========================================
✓ Integration test passed - Total payout: $11000.0

===========================================
        POLYMORPHISM TESTS                
===========================================
✓ Advanced polymorphism test passed

===========================================
         VALIDATION TESTS                 
===========================================
✓ Validation scenarios test passed

===========================================
         BUSINESS LOGIC TESTS             
===========================================
✓ Business logic test passed

===========================================
            ALL TESTS COMPLETED            
===========================================


 */