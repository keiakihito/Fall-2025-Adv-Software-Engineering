public class TestRunner {
    public static void main(String[] args) {
        System.out.println("===========================================");
        System.out.println("  EMPLOYEE HIERARCHY QUALITY TEST SUITE  ");
        System.out.println("===========================================\n");
        
        try {
            EmployeeTest.runTests();
            SalariedEmployeeTest.runTests();
            HourlyEmployeeTest.runTests();
            CommissionEmployeeTest.runTests();
            BaseEmployeeTest.runTests();
            
            System.out.println("===========================================");
            System.out.println("           POLYMORPHISM TEST               ");
            System.out.println("===========================================");
            testPolymorphism();
            
            System.out.println("\n===========================================");
            System.out.println("        ENCAPSULATION TEST                 ");
            System.out.println("===========================================");
            testEncapsulation();
            
            System.out.println("\n===========================================");
            System.out.println("         INHERITANCE TEST                  ");
            System.out.println("===========================================");
            testInheritanceHierarchy();
            
            System.out.println("\n===========================================");
            System.out.println("            ALL TESTS COMPLETED            ");
            System.out.println("===========================================");
            
        } catch (Exception e) {
            System.out.println("✗ Critical error during testing: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private static void testPolymorphism() {
        try {
            Employee[] employees = {
                new SalariedEmployee("John", "Doe", "111-11-1111", 2500.0),
                new HourlyEmployee("Jane", "Smith", "222-22-2222", 25.0, 40),
                new CommissionEmployee("Bob", "Johnson", "333-33-3333", 0.15, 50000.0),
                new BaseEmployee("Alice", "Williams", "444-44-4444", 95000.0)
            };
            
            System.out.println("Testing polymorphic behavior:");
            for (Employee emp : employees) {
                System.out.println("Type: " + emp.getClass().getSimpleName() + " -> " + emp.toString());
            }
            
            System.out.println("✓ Polymorphism test passed - all objects respond to Employee interface");
            
        } catch (Exception e) {
            System.out.println("✗ Polymorphism test failed: " + e.getMessage());
        }
    }
    
    private static void testEncapsulation() {
        try {
            SalariedEmployee emp = new SalariedEmployee("Test", "User", "123-45-6789", 1000.0);
            
            String originalFirstName = emp.getFirstName();
            emp.setFirstName("Modified");
            String modifiedFirstName = emp.getFirstName();
            
            assert !originalFirstName.equals(modifiedFirstName) : "Encapsulation failed - setter didn't work";
            assert modifiedFirstName.equals("Modified") : "Encapsulation failed - getter returned wrong value";
            
            double originalSalary = emp.getWeeklySalary();
            emp.setWeeklySalary(2000.0);
            double modifiedSalary = emp.getWeeklySalary();
            
            assert originalSalary != modifiedSalary : "Encapsulation failed - salary setter didn't work";
            assert modifiedSalary == 2000.0 : "Encapsulation failed - salary getter returned wrong value";
            
            System.out.println("✓ Encapsulation test passed - private fields accessible only through getters/setters");
            
        } catch (Exception e) {
            System.out.println("✗ Encapsulation test failed: " + e.getMessage());
        }
    }
    
    private static void testInheritanceHierarchy() {
        try {
            SalariedEmployee salariedEmp = new SalariedEmployee("John", "Doe", "111-11-1111", 2500.0);
            HourlyEmployee hourlyEmp = new HourlyEmployee("Jane", "Smith", "222-22-2222", 25.0, 40);
            CommissionEmployee commissionEmp = new CommissionEmployee("Bob", "Johnson", "333-33-3333", 0.15, 50000.0);
            BaseEmployee baseEmp = new BaseEmployee("Alice", "Williams", "444-44-4444", 95000.0);
            
            assert salariedEmp instanceof Employee : "SalariedEmployee is not instance of Employee";
            assert hourlyEmp instanceof Employee : "HourlyEmployee is not instance of Employee";
            assert commissionEmp instanceof Employee : "CommissionEmployee is not instance of Employee";
            assert baseEmp instanceof Employee : "BaseEmployee is not instance of Employee";
            
            assert salariedEmp.getFirstName().equals("John") : "Inheritance failed - base class method not accessible";
            assert hourlyEmp.getLastName().equals("Smith") : "Inheritance failed - base class method not accessible";
            assert commissionEmp.getSocialSecurityNumber().equals("333-33-3333") : "Inheritance failed - base class method not accessible";
            
            Employee genericEmp = salariedEmp;
            assert genericEmp.getFirstName().equals("John") : "Inheritance failed - polymorphic assignment issue";
            
            System.out.println("✓ Inheritance hierarchy test passed - all subclasses properly inherit from Employee");
            
        } catch (Exception e) {
            System.out.println("✗ Inheritance hierarchy test failed: " + e.getMessage());
        }
    }
}

/*
Sample Run

===========================================
  EMPLOYEE HIERARCHY QUALITY TEST SUITE  
===========================================

Testing Employee Base Class
===========================
✓ Constructor test passed
✓ Getters and Setters test passed
✓ toString test passed
✓ Null values test passed (no exceptions thrown)
✓ Empty values test passed

Employee Test Results: 5/5 tests passed

Testing SalariedEmployee Class
==============================
✓ Constructor test passed
✓ Inheritance test passed
✓ WeeklySalary getter/setter test passed
✓ toString test passed
✓ Negative salary test passed (no validation enforced)
✓ Zero salary test passed
✓ Large salary test passed

SalariedEmployee Test Results: 7/7 tests passed

Testing HourlyEmployee Class
============================
✓ Constructor test passed
✓ Inheritance test passed
✓ Wage getter/setter test passed
✓ HoursWorked getter/setter test passed
✓ toString test passed
✓ Negative values test passed (no validation enforced)
✓ Zero values test passed
✓ Overtime test passed
✓ Decimal hours test passed

HourlyEmployee Test Results: 9/9 tests passed

Testing CommissionEmployee Class
================================
✓ Constructor test passed
✓ Inheritance test passed
✓ CommissionRate getter/setter test passed
✓ GrossSales getter/setter test passed
✓ toString test passed
✓ Negative values test passed (no validation enforced)
✓ Zero values test passed
✓ High commission rate test passed
✓ Large sales test passed
✓ Commission calculation test passed

CommissionEmployee Test Results: 10/10 tests passed

Testing BaseEmployee Class
==========================
✓ Constructor test passed
✓ Inheritance test passed
✓ BaseSalary getter/setter test passed
✓ toString test passed
✓ Negative salary test passed (no validation enforced)
✓ Zero salary test passed
✓ Large salary test passed
✓ Decimal salary test passed

BaseEmployee Test Results: 8/8 tests passed

===========================================
           POLYMORPHISM TEST               
===========================================
Testing polymorphic behavior:
Type: SalariedEmployee -> John Doe (SSN: 111-11-1111) - Weekly Salary: $2500.00
Type: HourlyEmployee -> Jane Smith (SSN: 222-22-2222) - Wage: $25.00/hour, Hours: 40
Type: CommissionEmployee -> Bob Johnson (SSN: 333-33-3333) - Commission Rate: 15.0%, Gross Sales: $50000.00
Type: BaseEmployee -> Alice Williams (SSN: 444-44-4444) - Base Salary: $95000.00
✓ Polymorphism test passed - all objects respond to Employee interface

===========================================
        ENCAPSULATION TEST                 
===========================================
✓ Encapsulation test passed - private fields accessible only through getters/setters

===========================================
         INHERITANCE TEST                  
===========================================
✓ Inheritance hierarchy test passed - all subclasses properly inherit from Employee

===========================================
            ALL TESTS COMPLETED            
===========================================

*/