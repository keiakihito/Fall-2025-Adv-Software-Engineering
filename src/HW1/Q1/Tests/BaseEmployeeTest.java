public class BaseEmployeeTest {
    private static int testsPassed = 0;
    private static int totalTests = 0;
    
    public static void runTests() {
        System.out.println("Testing BaseEmployee Class");
        System.out.println("==========================");
        
        testConstructor();
        testInheritance();
        testBaseSalaryGetterSetter();
        testToString();
        testNegativeSalary();
        testZeroSalary();
        testLargeSalary();
        testDecimalSalary();
        
        System.out.println("\nBaseEmployee Test Results: " + testsPassed + "/" + totalTests + " tests passed\n");
    }
    
    private static void testConstructor() {
        try {
            BaseEmployee emp = new BaseEmployee("Mike", "Davenport", "666-66-6666", 95000.0);
            assert emp.getFirstName().equals("Mike") : "Constructor failed for firstName";
            assert emp.getLastName().equals("Davenport") : "Constructor failed for lastName";
            assert emp.getSocialSecurityNumber().equals("666-66-6666") : "Constructor failed for SSN";
            assert emp.getBaseSalary() == 95000.0 : "Constructor failed for baseSalary";
            System.out.println("✓ Constructor test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ Constructor test failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testInheritance() {
        try {
            BaseEmployee emp = new BaseEmployee("Mike", "Davenport", "666-66-6666", 95000.0);
            assert emp instanceof Employee : "BaseEmployee should be instance of Employee";
            assert emp instanceof BaseEmployee : "BaseEmployee should be instance of itself";
            System.out.println("✓ Inheritance test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ Inheritance test failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testBaseSalaryGetterSetter() {
        try {
            BaseEmployee emp = new BaseEmployee("Mike", "Davenport", "666-66-6666", 95000.0);
            
            emp.setBaseSalary(100000.0);
            assert emp.getBaseSalary() == 100000.0 : "setBaseSalary/getBaseSalary failed";
            
            emp.setBaseSalary(85000.50);
            assert emp.getBaseSalary() == 85000.50 : "Decimal base salary failed";
            
            System.out.println("✓ BaseSalary getter/setter test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ BaseSalary getter/setter test failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testToString() {
        try {
            BaseEmployee emp = new BaseEmployee("Mike", "Davenport", "666-66-6666", 95000.0);
            String result = emp.toString();
            assert result.contains("Mike") : "toString doesn't contain firstName";
            assert result.contains("Davenport") : "toString doesn't contain lastName";
            assert result.contains("95000") : "toString doesn't contain base salary";
            assert result.contains("Base Salary") : "toString doesn't contain salary label";
            System.out.println("✓ toString test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ toString test failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testNegativeSalary() {
        try {
            BaseEmployee emp = new BaseEmployee("Mike", "Davenport", "666-66-6666", -50000.0);
            emp.setBaseSalary(-75000.0);
            System.out.println("✓ Negative salary test passed (no validation enforced)");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ Negative salary test failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testZeroSalary() {
        try {
            BaseEmployee emp = new BaseEmployee("Mike", "Davenport", "666-66-6666", 0.0);
            assert emp.getBaseSalary() == 0.0 : "Zero salary failed";
            System.out.println("✓ Zero salary test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ Zero salary test failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testLargeSalary() {
        try {
            BaseEmployee emp = new BaseEmployee("Mike", "Davenport", "666-66-6666", 999999.99);
            assert emp.getBaseSalary() == 999999.99 : "Large salary failed";
            System.out.println("✓ Large salary test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ Large salary test failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testDecimalSalary() {
        try {
            BaseEmployee emp = new BaseEmployee("Mike", "Davenport", "666-66-6666", 95000.75);
            assert emp.getBaseSalary() == 95000.75 : "Decimal salary failed";
            emp.setBaseSalary(87500.25);
            assert emp.getBaseSalary() == 87500.25 : "Decimal salary setter failed";
            System.out.println("✓ Decimal salary test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ Decimal salary test failed: " + e.getMessage());
        }
        totalTests++;
    }
}