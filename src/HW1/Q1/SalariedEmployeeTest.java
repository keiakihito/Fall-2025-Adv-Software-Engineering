public class SalariedEmployeeTest {
    private static int testsPassed = 0;
    private static int totalTests = 0;
    
    public static void runTests() {
        System.out.println("Testing SalariedEmployee Class");
        System.out.println("==============================");
        
        testConstructor();
        testInheritance();
        testWeeklySalaryGetterSetter();
        testToString();
        testNegativeSalary();
        testZeroSalary();
        testLargeSalary();
        
        System.out.println("\nSalariedEmployee Test Results: " + testsPassed + "/" + totalTests + " tests passed\n");
    }
    
    private static void testConstructor() {
        try {
            SalariedEmployee emp = new SalariedEmployee("John", "Doe", "123-45-6789", 2500.0);
            assert emp.getFirstName().equals("John") : "Constructor failed for firstName";
            assert emp.getLastName().equals("Doe") : "Constructor failed for lastName";
            assert emp.getSocialSecurityNumber().equals("123-45-6789") : "Constructor failed for SSN";
            assert emp.getWeeklySalary() == 2500.0 : "Constructor failed for weeklySalary";
            System.out.println("✓ Constructor test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ Constructor test failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testInheritance() {
        try {
            SalariedEmployee emp = new SalariedEmployee("John", "Doe", "123-45-6789", 2500.0);
            assert emp instanceof Employee : "SalariedEmployee should be instance of Employee";
            assert emp instanceof SalariedEmployee : "SalariedEmployee should be instance of itself";
            System.out.println("✓ Inheritance test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ Inheritance test failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testWeeklySalaryGetterSetter() {
        try {
            SalariedEmployee emp = new SalariedEmployee("John", "Doe", "123-45-6789", 2500.0);
            
            emp.setWeeklySalary(3000.0);
            assert emp.getWeeklySalary() == 3000.0 : "setWeeklySalary/getWeeklySalary failed";
            
            emp.setWeeklySalary(1500.75);
            assert emp.getWeeklySalary() == 1500.75 : "Decimal salary failed";
            
            System.out.println("✓ WeeklySalary getter/setter test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ WeeklySalary getter/setter test failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testToString() {
        try {
            SalariedEmployee emp = new SalariedEmployee("John", "Doe", "123-45-6789", 2500.0);
            String result = emp.toString();
            assert result.contains("John") : "toString doesn't contain firstName";
            assert result.contains("Doe") : "toString doesn't contain lastName";
            assert result.contains("2500") : "toString doesn't contain salary";
            assert result.contains("Weekly Salary") : "toString doesn't contain salary label";
            System.out.println("✓ toString test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ toString test failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testNegativeSalary() {
        try {
            SalariedEmployee emp = new SalariedEmployee("John", "Doe", "123-45-6789", -1000.0);
            emp.setWeeklySalary(-500.0);
            System.out.println("✓ Negative salary test passed (no validation enforced)");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ Negative salary test failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testZeroSalary() {
        try {
            SalariedEmployee emp = new SalariedEmployee("John", "Doe", "123-45-6789", 0.0);
            assert emp.getWeeklySalary() == 0.0 : "Zero salary failed";
            System.out.println("✓ Zero salary test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ Zero salary test failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testLargeSalary() {
        try {
            SalariedEmployee emp = new SalariedEmployee("John", "Doe", "123-45-6789", 999999.99);
            assert emp.getWeeklySalary() == 999999.99 : "Large salary failed";
            System.out.println("✓ Large salary test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ Large salary test failed: " + e.getMessage());
        }
        totalTests++;
    }
}