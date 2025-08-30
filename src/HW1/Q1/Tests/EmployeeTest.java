public class EmployeeTest {
    private static int testsPassed = 0;
    private static int totalTests = 0;
    
    public static void runTests() {
        System.out.println("Testing Employee Base Class");
        System.out.println("===========================");
        
        testConstructor();
        testGettersAndSetters();
        testToString();
        testNullValues();
        testEmptyValues();
        
        System.out.println("\nEmployee Test Results: " + testsPassed + "/" + totalTests + " tests passed\n");
    }
    
    private static void testConstructor() {
        try {
            Employee emp = new Employee("John", "Doe", "123-45-6789");
            assert emp.getFirstName().equals("John") : "Constructor failed for firstName";
            assert emp.getLastName().equals("Doe") : "Constructor failed for lastName";
            assert emp.getSocialSecurityNumber().equals("123-45-6789") : "Constructor failed for SSN";
            System.out.println("✓ Constructor test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ Constructor test failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testGettersAndSetters() {
        try {
            Employee emp = new Employee("John", "Doe", "123-45-6789");
            
            emp.setFirstName("Jane");
            assert emp.getFirstName().equals("Jane") : "setFirstName/getFirstName failed";
            
            emp.setLastName("Smith");
            assert emp.getLastName().equals("Smith") : "setLastName/getLastName failed";
            
            emp.setSocialSecurityNumber("987-65-4321");
            assert emp.getSocialSecurityNumber().equals("987-65-4321") : "setSocialSecurityNumber/getSocialSecurityNumber failed";
            
            System.out.println("✓ Getters and Setters test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ Getters and Setters test failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testToString() {
        try {
            Employee emp = new Employee("John", "Doe", "123-45-6789");
            String result = emp.toString();
            assert result.contains("John") : "toString doesn't contain firstName";
            assert result.contains("Doe") : "toString doesn't contain lastName";
            assert result.contains("123-45-6789") : "toString doesn't contain SSN";
            System.out.println("✓ toString test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ toString test failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testNullValues() {
        try {
            Employee emp = new Employee(null, null, null);
            emp.setFirstName(null);
            emp.setLastName(null);
            emp.setSocialSecurityNumber(null);
            System.out.println("✓ Null values test passed (no exceptions thrown)");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ Null values test failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testEmptyValues() {
        try {
            Employee emp = new Employee("", "", "");
            emp.setFirstName("");
            emp.setLastName("");
            emp.setSocialSecurityNumber("");
            System.out.println("✓ Empty values test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ Empty values test failed: " + e.getMessage());
        }
        totalTests++;
    }
}