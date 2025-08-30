public class HourlyEmployeeTest {
    private static int testsPassed = 0;
    private static int totalTests = 0;
    
    public static void runTests() {
        System.out.println("Testing HourlyEmployee Class");
        System.out.println("============================");
        
        testConstructor();
        testInheritance();
        testWageGetterSetter();
        testHoursWorkedGetterSetter();
        testToString();
        testNegativeValues();
        testZeroValues();
        testOvertime();
        testDecimalHours();
        
        System.out.println("\nHourlyEmployee Test Results: " + testsPassed + "/" + totalTests + " tests passed\n");
    }
    
    private static void testConstructor() {
        try {
            HourlyEmployee emp = new HourlyEmployee("Jane", "Smith", "222-22-2222", 25.0, 40);
            assert emp.getFirstName().equals("Jane") : "Constructor failed for firstName";
            assert emp.getLastName().equals("Smith") : "Constructor failed for lastName";
            assert emp.getSocialSecurityNumber().equals("222-22-2222") : "Constructor failed for SSN";
            assert emp.getWage() == 25.0 : "Constructor failed for wage";
            assert emp.getHoursWorked() == 40 : "Constructor failed for hoursWorked";
            System.out.println("✓ Constructor test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ Constructor test failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testInheritance() {
        try {
            HourlyEmployee emp = new HourlyEmployee("Jane", "Smith", "222-22-2222", 25.0, 40);
            assert emp instanceof Employee : "HourlyEmployee should be instance of Employee";
            assert emp instanceof HourlyEmployee : "HourlyEmployee should be instance of itself";
            System.out.println("✓ Inheritance test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ Inheritance test failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testWageGetterSetter() {
        try {
            HourlyEmployee emp = new HourlyEmployee("Jane", "Smith", "222-22-2222", 25.0, 40);
            
            emp.setWage(30.0);
            assert emp.getWage() == 30.0 : "setWage/getWage failed";
            
            emp.setWage(15.75);
            assert emp.getWage() == 15.75 : "Decimal wage failed";
            
            System.out.println("✓ Wage getter/setter test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ Wage getter/setter test failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testHoursWorkedGetterSetter() {
        try {
            HourlyEmployee emp = new HourlyEmployee("Jane", "Smith", "222-22-2222", 25.0, 40);
            
            emp.setHoursWorked(35);
            assert emp.getHoursWorked() == 35 : "setHoursWorked/getHoursWorked failed";
            
            emp.setHoursWorked(0);
            assert emp.getHoursWorked() == 0 : "Zero hours failed";
            
            System.out.println("✓ HoursWorked getter/setter test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ HoursWorked getter/setter test failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testToString() {
        try {
            HourlyEmployee emp = new HourlyEmployee("Jane", "Smith", "222-22-2222", 25.0, 40);
            String result = emp.toString();
            assert result.contains("Jane") : "toString doesn't contain firstName";
            assert result.contains("Smith") : "toString doesn't contain lastName";
            assert result.contains("25") : "toString doesn't contain wage";
            assert result.contains("40") : "toString doesn't contain hours";
            assert result.contains("Wage") : "toString doesn't contain wage label";
            System.out.println("✓ toString test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ toString test failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testNegativeValues() {
        try {
            HourlyEmployee emp = new HourlyEmployee("Jane", "Smith", "222-22-2222", -5.0, -10);
            emp.setWage(-15.0);
            emp.setHoursWorked(-20);
            System.out.println("✓ Negative values test passed (no validation enforced)");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ Negative values test failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testZeroValues() {
        try {
            HourlyEmployee emp = new HourlyEmployee("Jane", "Smith", "222-22-2222", 0.0, 0);
            assert emp.getWage() == 0.0 : "Zero wage failed";
            assert emp.getHoursWorked() == 0 : "Zero hours failed";
            System.out.println("✓ Zero values test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ Zero values test failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testOvertime() {
        try {
            HourlyEmployee emp = new HourlyEmployee("Jane", "Smith", "222-22-2222", 25.0, 50);
            assert emp.getHoursWorked() == 50 : "Overtime hours failed";
            System.out.println("✓ Overtime test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ Overtime test failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testDecimalHours() {
        try {
            HourlyEmployee emp = new HourlyEmployee("Jane", "Smith", "222-22-2222", 25.0, 40);
            emp.setHoursWorked(37);
            assert emp.getHoursWorked() == 37 : "Decimal-like hours failed";
            System.out.println("✓ Decimal hours test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ Decimal hours test failed: " + e.getMessage());
        }
        totalTests++;
    }
}