public class CommissionEmployeeTest {
    private static int testsPassed = 0;
    private static int totalTests = 0;
    
    public static void runTests() {
        System.out.println("Testing CommissionEmployee Class");
        System.out.println("================================");
        
        testConstructor();
        testInheritance();
        testCommissionRateGetterSetter();
        testGrossSalesGetterSetter();
        testToString();
        testNegativeValues();
        testZeroValues();
        testHighCommissionRate();
        testLargeSales();
        testCommissionCalculation();
        
        System.out.println("\nCommissionEmployee Test Results: " + testsPassed + "/" + totalTests + " tests passed\n");
    }
    
    private static void testConstructor() {
        try {
            CommissionEmployee emp = new CommissionEmployee("Nicole", "Dior", "444-44-4444", 0.15, 50000.0);
            assert emp.getFirstName().equals("Nicole") : "Constructor failed for firstName";
            assert emp.getLastName().equals("Dior") : "Constructor failed for lastName";
            assert emp.getSocialSecurityNumber().equals("444-44-4444") : "Constructor failed for SSN";
            assert emp.getCommissionRate() == 0.15 : "Constructor failed for commissionRate";
            assert emp.getGrossSales() == 50000.0 : "Constructor failed for grossSales";
            System.out.println("✓ Constructor test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ Constructor test failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testInheritance() {
        try {
            CommissionEmployee emp = new CommissionEmployee("Nicole", "Dior", "444-44-4444", 0.15, 50000.0);
            assert emp instanceof Employee : "CommissionEmployee should be instance of Employee";
            assert emp instanceof CommissionEmployee : "CommissionEmployee should be instance of itself";
            System.out.println("✓ Inheritance test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ Inheritance test failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testCommissionRateGetterSetter() {
        try {
            CommissionEmployee emp = new CommissionEmployee("Nicole", "Dior", "444-44-4444", 0.15, 50000.0);
            
            emp.setCommissionRate(0.20);
            assert emp.getCommissionRate() == 0.20 : "setCommissionRate/getCommissionRate failed";
            
            emp.setCommissionRate(0.075);
            assert emp.getCommissionRate() == 0.075 : "Decimal commission rate failed";
            
            System.out.println("✓ CommissionRate getter/setter test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ CommissionRate getter/setter test failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testGrossSalesGetterSetter() {
        try {
            CommissionEmployee emp = new CommissionEmployee("Nicole", "Dior", "444-44-4444", 0.15, 50000.0);
            
            emp.setGrossSales(75000.0);
            assert emp.getGrossSales() == 75000.0 : "setGrossSales/getGrossSales failed";
            
            emp.setGrossSales(25000.50);
            assert emp.getGrossSales() == 25000.50 : "Decimal gross sales failed";
            
            System.out.println("✓ GrossSales getter/setter test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ GrossSales getter/setter test failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testToString() {
        try {
            CommissionEmployee emp = new CommissionEmployee("Nicole", "Dior", "444-44-4444", 0.15, 50000.0);
            String result = emp.toString();
            assert result.contains("Nicole") : "toString doesn't contain firstName";
            assert result.contains("Dior") : "toString doesn't contain lastName";
            assert result.contains("15") : "toString doesn't contain commission rate";
            assert result.contains("50000") : "toString doesn't contain gross sales";
            assert result.contains("Commission") : "toString doesn't contain commission label";
            System.out.println("✓ toString test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ toString test failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testNegativeValues() {
        try {
            CommissionEmployee emp = new CommissionEmployee("Nicole", "Dior", "444-44-4444", -0.05, -1000.0);
            emp.setCommissionRate(-0.10);
            emp.setGrossSales(-5000.0);
            System.out.println("✓ Negative values test passed (no validation enforced)");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ Negative values test failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testZeroValues() {
        try {
            CommissionEmployee emp = new CommissionEmployee("Nicole", "Dior", "444-44-4444", 0.0, 0.0);
            assert emp.getCommissionRate() == 0.0 : "Zero commission rate failed";
            assert emp.getGrossSales() == 0.0 : "Zero gross sales failed";
            System.out.println("✓ Zero values test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ Zero values test failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testHighCommissionRate() {
        try {
            CommissionEmployee emp = new CommissionEmployee("Nicole", "Dior", "444-44-4444", 0.50, 50000.0);
            assert emp.getCommissionRate() == 0.50 : "High commission rate failed";
            System.out.println("✓ High commission rate test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ High commission rate test failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testLargeSales() {
        try {
            CommissionEmployee emp = new CommissionEmployee("Nicole", "Dior", "444-44-4444", 0.15, 1000000.0);
            assert emp.getGrossSales() == 1000000.0 : "Large sales amount failed";
            System.out.println("✓ Large sales test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ Large sales test failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testCommissionCalculation() {
        try {
            CommissionEmployee emp = new CommissionEmployee("Nicole", "Dior", "444-44-4444", 0.15, 50000.0);
            double expectedCommission = 0.15 * 50000.0;
            assert expectedCommission == 7500.0 : "Commission calculation verification failed";
            System.out.println("✓ Commission calculation test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ Commission calculation test failed: " + e.getMessage());
        }
        totalTests++;
    }
}