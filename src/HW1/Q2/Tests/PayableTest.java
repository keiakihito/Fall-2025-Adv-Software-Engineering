import Freelancer;
import Payable;
import VendorInvoice;

package Tests;
public class PayableTest {
    private static int testsPassed = 0;
    private static int totalTests = 0;
    
    public static void runTests() {
        System.out.println("Testing Payable Interface Functionality");
        System.out.println("=======================================");
        
        testPayableInterface();
        testPolymorphicBehavior();
        testInterfaceImplementation();
        
        System.out.println("\nPayable Interface Test Results: " + testsPassed + "/" + totalTests + " tests passed\n");
    }
    
    private static void testPayableInterface() {
        try {
            Payable freelancer = new Freelancer("John", "Doe", 50.0, 40.0);
            Payable vendor = new VendorInvoice("Test Vendor", "INV-001", 1000.0);
            
            assert freelancer instanceof Payable : "Freelancer should implement Payable";
            assert vendor instanceof Payable : "VendorInvoice should implement Payable";
            
            assert freelancer.calculatePayment() > 0 : "calculatePayment should return positive value";
            assert vendor.calculatePayment() > 0 : "calculatePayment should return positive value";
            
            assert freelancer.getPayeeName() != null : "getPayeeName should not return null";
            assert vendor.getPayeeName() != null : "getPayeeName should not return null";
            
            System.out.println("✓ Payable interface implementation test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ Payable interface implementation test failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testPolymorphicBehavior() {
        try {
            Payable[] payables = {
                new Freelancer("Alice", "Johnson", 60.0, 35.0),
                new VendorInvoice("Tech Co", "INV-002", 2500.0),
                new Freelancer("Bob", "Smith", 70.0, 45.0)
            };
            
            double totalPayment = 0.0;
            for (Payable payable : payables) {
                totalPayment += payable.calculatePayment();
            }
            
            assert totalPayment > 0 : "Total payment should be positive";
            assert payables.length == 3 : "Array should contain 3 payables";
            
            for (Payable payable : payables) {
                assert payable.getPayeeName().length() > 0 : "Payee name should not be empty";
            }
            
            System.out.println("✓ Polymorphic behavior test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ Polymorphic behavior test failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testInterfaceImplementation() {
        try {
            Freelancer freelancer = new Freelancer("Test", "User", 40.0, 30.0);
            VendorInvoice vendor = new VendorInvoice("Test Vendor", "TEST-001", 1500.0);
            
            // Test that both classes properly implement the interface methods
            double freelancerPayment = freelancer.calculatePayment();
            double vendorPayment = vendor.calculatePayment();
            
            assert freelancerPayment == 1200.0 : "Freelancer payment calculation incorrect";
            assert vendorPayment == 1500.0 : "Vendor payment calculation incorrect";
            
            assert freelancer.getPayeeName().equals("Test User") : "Freelancer payee name incorrect";
            assert vendor.getPayeeName().equals("Test Vendor") : "Vendor payee name incorrect";
            
            System.out.println("✓ Interface implementation test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ Interface implementation test failed: " + e.getMessage());
        }
        totalTests++;
    }
}