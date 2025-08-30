import java.util.ArrayList;
import java.util.List;

public class EmployeeDriver {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        
        employees.add(new SalariedEmployee("Joe", "Jones", "111-11-1111", 2500.00));
        employees.add(new HourlyEmployee("Stephanie", "Smith", "222-22-2222", 25.00, 32));
        employees.add(new HourlyEmployee("Mary", "Quinn", "333-33-3333", 19.00, 47));
        employees.add(new CommissionEmployee("Nicole", "Dior", "444-44-4444", 0.15, 50000.00));
        employees.add(new SalariedEmployee("Renwa", "Chanel", "555-55-5555", 1700.00));
        employees.add(new BaseEmployee("Mike", "Davenport", "666-66-6666", 95000.00));
        employees.add(new CommissionEmployee("Mahnaz", "Vaziri", "777-77-7777", 0.22, 40000.00));
        
        System.out.println("Employee Details:");
        System.out.println("=================");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        
        System.out.println("\nTesting Individual Employee Methods:");
        System.out.println("===================================");
        
        SalariedEmployee salariedEmp = (SalariedEmployee) employees.get(0);
        System.out.println("Testing SalariedEmployee getter: " + salariedEmp.getWeeklySalary());
        salariedEmp.setWeeklySalary(3000.00);
        System.out.println("After setter update: " + salariedEmp.getWeeklySalary());
        
        HourlyEmployee hourlyEmp = (HourlyEmployee) employees.get(1);
        System.out.println("Testing HourlyEmployee getters: Wage=" + hourlyEmp.getWage() + ", Hours=" + hourlyEmp.getHoursWorked());
        hourlyEmp.setWage(30.00);
        hourlyEmp.setHoursWorked(40);
        System.out.println("After setter updates: Wage=" + hourlyEmp.getWage() + ", Hours=" + hourlyEmp.getHoursWorked());
        
        CommissionEmployee commissionEmp = (CommissionEmployee) employees.get(3);
        System.out.println("Testing CommissionEmployee getters: Rate=" + commissionEmp.getCommissionRate() + ", Sales=" + commissionEmp.getGrossSales());
        
        BaseEmployee baseEmp = (BaseEmployee) employees.get(5);
        System.out.println("Testing BaseEmployee getter: " + baseEmp.getBaseSalary());
        baseEmp.setBaseSalary(100000.00);
        System.out.println("After setter update: " + baseEmp.getBaseSalary());
    }
}