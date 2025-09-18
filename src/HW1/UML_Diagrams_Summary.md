# HW1 UML Diagrams Summary

## Overview
This document provides a comprehensive overview of the UML class diagrams created for CS5800 HW1. The diagrams illustrate four fundamental object-oriented programming concepts: inheritance, interface implementation, polymorphism, and aggregation.

## Files Created
1. `HW1_UML_Diagrams.puml` - Comprehensive diagram containing all four questions
2. `Q1_Employee_Hierarchy_UML.puml` - Employee inheritance hierarchy
3. `Q2_Payable_Interface_UML.puml` - Payable interface implementation
4. `Q3_Ship_Hierarchy_UML.puml` - Ship inheritance with method overriding
5. `Q4_Course_Aggregation_UML.puml` - Course aggregation relationships

## Question 1: Employee Inheritance Hierarchy (IS-A Relationships)

### Design Pattern: Inheritance
- **Base Class**: `Employee`
- **Derived Classes**: `SalariedEmployee`, `HourlyEmployee`, `CommissionEmployee`, `BaseEmployee`

### Key Features:
- Demonstrates **inheritance (IS-A relationship)**
- Common attributes in base class: `firstName`, `lastName`, `socialSecurityNumber`
- Each subclass adds specific attributes related to their payment structure
- All classes override `toString()` method for specialized display

### Class Relationships:
```
Employee
├── SalariedEmployee (weeklySalary)
├── HourlyEmployee (wage, hoursWorked)
├── CommissionEmployee (commissionRate, grossSales)
└── BaseEmployee (baseSalary)
```

## Question 2: Payable Interface Implementation

### Design Pattern: Interface Implementation & Polymorphism
- **Interface**: `Payable`
- **Implementing Classes**: `Freelancer`, `VendorInvoice`

### Key Features:
- Demonstrates **interface implementation**
- Enables **polymorphic treatment** of different payable entities
- Common contract: `calculatePayment()` and `getPayeeName()`
- Different payment calculation logic for each implementation

### Payment Logic:
- **Freelancer**: `hourlyRate × hoursWorked` (with 1.5× overtime for hours > 40)
- **VendorInvoice**: Simply returns `amountDue`

## Question 3: Ship Inheritance Hierarchy

### Design Pattern: Inheritance with Method Overriding
- **Base Class**: `Ship`
- **Derived Classes**: `CruiseShip`, `CargoShip`

### Key Features:
- Demonstrates **method overriding** and **polymorphism**
- Base `print()` method shows ship name and year built
- Subclasses override `print()` to show specialized information
- **Dynamic method dispatch** - correct `print()` called at runtime

### Polymorphic Behavior:
- `Ship[]` array can hold different ship types
- `CruiseShip.print()` shows name + max passengers
- `CargoShip.print()` shows name + cargo capacity

## Question 4: Course Aggregation (HAS-A Relationships)

### Design Pattern: Aggregation
- **Container Class**: `Course`
- **Component Classes**: `Instructor`, `Textbook`

### Key Features:
- Demonstrates **aggregation (HAS-A relationship)**
- Course **HAS** Instructor(s) and Textbook(s)
- Supports both single and multiple instructors/textbooks
- Component objects exist independently of Course

### Aggregation vs Composition:
- **Aggregation**: Parts can exist independently (used here)
- **Composition**: Parts cannot exist without whole
- Instructors and Textbooks can be shared between courses

## OOP Concepts Demonstrated

### 1. Encapsulation
- All attributes are `private`
- Public getter/setter methods provide controlled access
- Constructor validation ensures data integrity

### 2. Inheritance
- **Q1**: Employee hierarchy showing IS-A relationships
- **Q3**: Ship hierarchy with method overriding
- Code reuse through inheritance

### 3. Polymorphism
- **Q2**: Interface implementation enables treating different objects uniformly
- **Q3**: Method overriding allows runtime method selection
- **Runtime binding** determines correct method to call

### 4. Abstraction
- **Q2**: `Payable` interface abstracts payment concept
- Clients work with abstractions rather than concrete implementations

### 5. Aggregation
- **Q4**: Course aggregates Instructor and Textbook objects
- Demonstrates "whole-part" relationships where parts are independent

## Design Principles Applied

### Single Responsibility Principle
- Each class has a single, well-defined purpose
- Employee types focus on their specific payment structure

### Open/Closed Principle
- Classes are open for extension (inheritance) but closed for modification
- New employee types can be added without changing existing code

### Interface Segregation
- `Payable` interface is focused and minimal
- Contains only essential payment-related methods

### Dependency Inversion
- `Course` depends on abstractions (`Instructor`, `Textbook`) not concretions
- Enables flexible composition

## How to Use PlantUML Files

1. **Install PlantUML**: Download from http://plantuml.com/
2. **Generate Diagrams**: Use PlantUML to convert `.puml` files to images
3. **Command Line**: `java -jar plantuml.jar *.puml`
4. **Online**: Use PlantUML online editor
5. **IDE Integration**: Many IDEs have PlantUML plugins

## Testing and Validation

Each implementation includes:
- **Driver classes** (`Main.java`) demonstrating functionality
- **Test cases** validating class behavior
- **Polymorphic usage** showing runtime behavior
- **Input validation** ensuring robust error handling

## Conclusion

These UML diagrams comprehensively illustrate the implementation of fundamental OOP concepts in Java. The designs follow established software engineering principles and demonstrate clean, maintainable code architecture through proper use of inheritance, interfaces, and composition patterns.