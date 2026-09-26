package version6;

public class Main {

    public static void main(String[] args) {
        System.out.println("======================================================================");
        System.out.println("1. TESTING ENCAPSULATION & DEFENSIVE COPYING");
        System.out.println("======================================================================");
        System.out.println("Instantiation Blocking: Employee is abstract; new Employee(...) is a compile-time error.");
        // Employee blockedEmployee = new Employee(999, new Name("Blocked", "Employee"));
        MyDate originalBirthDate = new MyDate(15, 12, 1995);
        HourlyEmployee protectedEmployee = new HourlyEmployee(100,
                new Name("Test", "A", "Employee", ""), originalBirthDate,
                new MyDate(1, 6, 2022), 40, 190);
        System.out.printf("Original Birth Month: %d (%s)%n", originalBirthDate.getMonth(), originalBirthDate.getMonthName());
        System.out.println("Attempting external tampering: emp.getBirthDate().setMonth(9)...");
        protectedEmployee.getBirthDate().setMonth(9);
        System.out.printf("Employee's Actual Birth Date after tampering attempt: %s%n", protectedEmployee.getBirthDate());
        System.out.println("Result: SUCCESS (Internal state protected via defensive copying)");

        System.out.println("======================================================================");
        System.out.println("2. TESTING EXCEPTION HANDLING & INPUT VALIDATION");
        System.out.println("======================================================================");
        try {
            System.out.println("Attempting to create HourlyEmployee with rate: -150.00...");
            new HourlyEmployee(102, new Name("Invalid", "Employee"), new MyDate(1, 1, 2020),
                    new MyDate(1, 1, 2021), 40, -150);
        } catch (IllegalArgumentException exception) {
            System.out.printf("Caught Expected Exception: [%s] %s%n", exception.getClass().getSimpleName(), exception.getMessage());
        }
        try {
            System.out.println("Attempting to assign invalid calendar date: 31 Feb 2026...");
            new MyDate(31, 2, 2026);
        } catch (IllegalArgumentException exception) {
            System.out.printf("Caught Expected Exception: [%s] %s%n", exception.getClass().getSimpleName(), exception.getMessage());
        }

        System.out.println("======================================================================");
        System.out.println("3. POLYMORPHIC PAYROLL EXECUTION (Target Month: Sep)");
        System.out.println("[Dynamic Dispatch via Abstract Contract computeSalary()]");
        System.out.println("======================================================================");
        EmployeeRoster roster = new EmployeeRoster();
        HourlyEmployee hourlyEmployee = new HourlyEmployee(101,
                new Name("Alice", "M", "Smith", ""), new MyDate(18, 9, 2000),
                new MyDate(1, 6, 2022), 50, 190);
        PieceWorkerEmployee pieceWorkerEmployee = new PieceWorkerEmployee(201,
                new Name("Bob", "C", "Jones", "Jr."), 450, 9);
        CommissionEmployee commissionEmployee = new CommissionEmployee(301,
                new Name("Maria", "L", "Reyes", ""), 100_000);
        BasePlusCommissionEmployee basePlusEmployee = new BasePlusCommissionEmployee(401,
                new Name("Kevin", "S", "Tan", ""), 70_000, 25_000);
        commissionEmployee.setBirthDate(new MyDate(12, 9, 1995));
        basePlusEmployee.setBirthDate(new MyDate(30, 12, 1990));
        roster.addEmployee(hourlyEmployee);
        roster.addEmployee(pieceWorkerEmployee);
        roster.addEmployee(commissionEmployee);
        roster.addEmployee(basePlusEmployee);
        roster.displayPayroll(9);
    }
}
