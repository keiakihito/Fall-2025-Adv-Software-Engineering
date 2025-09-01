public class VendorInvoiceTest {
    private static int testsPassed = 0;
    private static int totalTests = 0;
    
    public static void runTests() {
        System.out.println("Testing VendorInvoice Class");
        System.out.println("===========================");
        
        testConstructor();
        testGettersAndSetters();
        testPaymentCalculation();
        testInputValidation();
        testPayableInterfaceMethods();
        testPrintMethod();
        testEdgeCases();
        
        System.out.println("\nVendorInvoice Test Results: " + testsPassed + "/" + totalTests + " tests passed\n");
    }
    
    private static void testConstructor() {
        try {
            VendorInvoice invoice = new VendorInvoice("Tech Corp", "INV-001", 2500.0);
            assert invoice.getVendorName().equals("Tech Corp") : "Constructor failed for vendorName";
            assert invoice.getInvoiceNumber().equals("INV-001") : "Constructor failed for invoiceNumber";
            assert invoice.getAmountDue() == 2500.0 : "Constructor failed for amountDue";
            System.out.println("✓ Constructor test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ Constructor test failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testGettersAndSetters() {
        try {
            VendorInvoice invoice = new VendorInvoice("Tech Corp", "INV-001", 2500.0);
            
            invoice.setVendorName("New Tech Corp");
            assert invoice.getVendorName().equals("New Tech Corp") : "setVendorName/getVendorName failed";
            
            invoice.setInvoiceNumber("INV-002");
            assert invoice.getInvoiceNumber().equals("INV-002") : "setInvoiceNumber/getInvoiceNumber failed";
            
            invoice.setAmountDue(3000.0);
            assert invoice.getAmountDue() == 3000.0 : "setAmountDue/getAmountDue failed";
            
            System.out.println("✓ Getters and Setters test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ Getters and Setters test failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testPaymentCalculation() {
        try {
            VendorInvoice invoice = new VendorInvoice("Office Supply", "INV-100", 1500.75);
            double payment = invoice.calculatePayment();
            assert payment == 1500.75 : "Payment calculation should return amountDue";
            
            invoice.setAmountDue(2000.50);
            payment = invoice.calculatePayment();
            assert payment == 2000.50 : "Payment calculation should update with new amountDue";
            
            // Test with zero amount
            invoice.setAmountDue(0.0);
            payment = invoice.calculatePayment();
            assert payment == 0.0 : "Zero amount should return zero payment";
            
            System.out.println("✓ Payment calculation test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ Payment calculation test failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testInputValidation() {
        try {
            // Test negative amount due in constructor
            try {
                new VendorInvoice("Bad Vendor", "INV-001", -100.0);
                assert false : "Should throw exception for negative amount due in constructor";
            } catch (IllegalArgumentException e) {
                // Expected behavior
            }
            
            // Test negative amount due in setter
            VendorInvoice invoice = new VendorInvoice("Good Vendor", "INV-002", 1000.0);
            try {
                invoice.setAmountDue(-50.0);
                assert false : "Should throw exception for negative amount due in setter";
            } catch (IllegalArgumentException e) {
                // Expected behavior
            }
            
            // Test that valid zero amount is accepted
            invoice.setAmountDue(0.0);
            assert invoice.getAmountDue() == 0.0 : "Zero amount should be valid";
            
            System.out.println("✓ Input validation test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ Input validation test failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testPayableInterfaceMethods() {
        try {
            VendorInvoice invoice = new VendorInvoice("Service Provider Inc.", "SRV-2024-001", 3500.0);
            
            // Test getPayeeName
            String payeeName = invoice.getPayeeName();
            assert payeeName.equals("Service Provider Inc.") : "getPayeeName should return vendor name";
            
            // Test calculatePayment through interface
            Payable payable = invoice;
            double payment = payable.calculatePayment();
            assert payment == invoice.calculatePayment() : "Interface method should match class method";
            assert payment == 3500.0 : "Interface calculatePayment should return correct amount";
            
            String interfacePayeeName = payable.getPayeeName();
            assert interfacePayeeName.equals(invoice.getPayeeName()) : "Interface getPayeeName should match class method";
            
            System.out.println("✓ Payable interface methods test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ Payable interface methods test failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testPrintMethod() {
        try {
            VendorInvoice invoice = new VendorInvoice("Test Vendor", "TEST-001", 1234.56);
            
            // This test just ensures print() doesn't throw exceptions
            invoice.print();
            
            System.out.println("✓ Print method test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ Print method test failed: " + e.getMessage());
        }
        totalTests++;
    }
    
    private static void testEdgeCases() {
        try {
            // Test with very large amounts
            VendorInvoice largeInvoice = new VendorInvoice("Big Corp", "BIG-001", 999999.99);
            assert largeInvoice.calculatePayment() == 999999.99 : "Large amount calculation failed";
            
            // Test with very small amounts
            VendorInvoice smallInvoice = new VendorInvoice("Small Vendor", "SMALL-001", 0.01);
            assert smallInvoice.calculatePayment() == 0.01 : "Small amount calculation failed";
            
            // Test with empty strings (should be allowed)
            VendorInvoice emptyStrings = new VendorInvoice("", "", 100.0);
            assert emptyStrings.getVendorName().equals("") : "Empty vendor name should be allowed";
            assert emptyStrings.getInvoiceNumber().equals("") : "Empty invoice number should be allowed";
            
            // Test with null strings (should be allowed, though not recommended)
            VendorInvoice nullStrings = new VendorInvoice(null, null, 200.0);
            assert nullStrings.getVendorName() == null : "Null vendor name should be stored";
            assert nullStrings.getInvoiceNumber() == null : "Null invoice number should be stored";
            
            System.out.println("✓ Edge cases test passed");
            testsPassed++;
        } catch (Exception e) {
            System.out.println("✗ Edge cases test failed: " + e.getMessage());
        }
        totalTests++;
    }
}