import Freelancer;
import Payable;

package Tests;
public class FreelancerTest {
    private static int testsPassed = 0;
    private static int totalTests = 0;
    
    public static void runTests() {
        System.out.println("Testing Freelancer Class");
        System.out.println("========================");
        
        testConstructor();
        testGettersAndSetters();
        testRegularHoursPayment();
        testOvertimePayment();
        testEdgeCasePayments();
        testInputValidation();
        testPayableInterfaceMethods();
        testPrintMethod();
        
        System.out.println("\nFreelancer Test Results: " + testsPassed + "/" + totalTests + " tests passed\n");
    }
    
    private static void testConstructor() {
        try {
            Freelancer freelancer = new Freelancer("John", "Doe", 50.0, 40.0);
            assert freelancer.getFirstName().equals("John") : "Constructor failed for firstName";
            assert freelancer.getLastName().equals("Doe") : "Constructor failed for lastName";
            assert freelancer.getHourlyRate() == 50.0 : "Constructor failed for hourlyRate";
            assert freelancer.getHoursWorked() == 40.0 : "Constructor failed for hoursWorked";
            System.out.println("✓ Constructor test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ Constructor test failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testGettersAndSetters() {
        try {
            Freelancer freelancer = new Freelancer("John", "Doe", 50.0, 40.0);
            
            freelancer.setFirstName("Jane");
            assert freelancer.getFirstName().equals("Jane") : "setFirstName/getFirstName failed";
            
            freelancer.setLastName("Smith");
            assert freelancer.getLastName().equals("Smith") : "setLastName/getLastName failed";
            
            freelancer.setHourlyRate(60.0);
            assert freelancer.getHourlyRate() == 60.0 : "setHourlyRate/getHourlyRate failed";
            
            freelancer.setHoursWorked(35.0);
            assert freelancer.getHoursWorked() == 35.0 : "setHoursWorked/getHoursWorked failed";
            
            System.out.println("✓ Getters and Setters test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ Getters and Setters test failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testRegularHoursPayment() {
        try {
            Freelancer freelancer = new Freelancer("John", "Doe", 50.0, 30.0);
            double payment = freelancer.calculatePayment();
            assert payment == 1500.0 : "Regular hours payment calculation failed";
            
            freelancer = new Freelancer("Jane", "Smith", 75.0, 40.0);
            payment = freelancer.calculatePayment();
            assert payment == 3000.0 : "40 hours payment calculation failed";
            
            System.out.println("✓ Regular hours payment test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ Regular hours payment test failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testOvertimePayment() {
        try {
            // Test overtime calculation: 40 regular + 5 overtime at 1.5x
            Freelancer freelancer = new Freelancer("John", "Doe", 60.0, 45.0);
            double payment = freelancer.calculatePayment();
            // Regular: 40 * 60 = 2400, Overtime: 5 * 60 * 1.5 = 450, Total: 2850
            assert payment == 2850.0 : "Overtime payment calculation failed: expected 2850, got " + payment;
            
            // Test with more overtime hours
            freelancer = new Freelancer("Jane", "Smith", 50.0, 50.0);
            payment = freelancer.calculatePayment();
            // Regular: 40 * 50 = 2000, Overtime: 10 * 50 * 1.5 = 750, Total: 2750
            assert payment == 2750.0 : "Extended overtime payment calculation failed: expected 2750, got " + payment;
            
            System.out.println("✓ Overtime payment test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ Overtime payment test failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testEdgeCasePayments() {
        try {
            // Test zero hours
            Freelancer freelancer = new Freelancer("John", "Doe", 50.0, 0.0);
            double payment = freelancer.calculatePayment();
            assert payment == 0.0 : "Zero hours payment should be 0";
            
            // Test exactly 40 hours (no overtime)
            freelancer = new Freelancer("Jane", "Smith", 75.0, 40.0);
            payment = freelancer.calculatePayment();
            assert payment == 3000.0 : "Exactly 40 hours should not trigger overtime";
            
            // Test 40.1 hours (minimal overtime)
            freelancer = new Freelancer("Bob", "Jones", 100.0, 40.1);
            payment = freelancer.calculatePayment();
            double expected = 40 * 100 + 0.1 * 100 * 1.5; // 4000 + 15 = 4015
            assert Math.abs(payment - expected) < 0.01 : "Minimal overtime calculation failed";
            
            System.out.println("✓ Edge case payments test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ Edge case payments test failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testInputValidation() {
        try {
            // Test negative hourly rate
            try {
                new Freelancer("John", "Doe", -10.0, 40.0);
                assert false : "Should throw exception for negative hourly rate";
            } catch (IllegalArgumentException e) {
                // Expected behavior
            }
            
            // Test negative hours worked
            try {
                new Freelancer("Jane", "Smith", 50.0, -5.0);
                assert false : "Should throw exception for negative hours worked";
            } catch (IllegalArgumentException e) {
                // Expected behavior
            }
            
            // Test setters with negative values
            Freelancer freelancer = new Freelancer("Bob", "Jones", 50.0, 40.0);
            try {
                freelancer.setHourlyRate(-20.0);
                assert false : "Should throw exception for negative hourly rate setter";
            } catch (IllegalArgumentException e) {
                // Expected behavior
            }
            
            try {
                freelancer.setHoursWorked(-10.0);
                assert false : "Should throw exception for negative hours worked setter";
            } catch (IllegalArgumentException e) {
                // Expected behavior
            }
            
            System.out.println("✓ Input validation test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ Input validation test failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testPayableInterfaceMethods() {
        try {
            Freelancer freelancer = new Freelancer("Alice", "Johnson", 65.0, 35.0);
            
            // Test getPayeeName
            String payeeName = freelancer.getPayeeName();
            assert payeeName.equals("Alice Johnson") : "getPayeeName should return full name";
            
            // Test calculatePayment through interface
            Payable payable = freelancer;
            double payment = payable.calculatePayment();
            assert payment == freelancer.calculatePayment() : "Interface method should match class method";
            
            System.out.println("✓ Payable interface methods test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ Payable interface methods test failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testPrintMethod() {
        try {
            Freelancer freelancer = new Freelancer("Test", "User", 50.0, 20.0);
            
            // This test just ensures print() doesn't throw exceptions
            freelancer.print();
            
            System.out.println("✓ Print method test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ Print method test failed: " + e.getMessage());
        }
        totalTests++;
    }
}