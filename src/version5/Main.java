package version5;

public class Main {

    public static void main(String[] args) {
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

        System.out.println("======================================================================");
        System.out.println("DYNAMIC ROSTER INITIALIZATION (ArrayList Backend)");
        System.out.println("======================================================================");
        enroll(roster, hourlyEmployee, "Hourly");
        enroll(roster, pieceWorkerEmployee, "Piece Worker");
        enroll(roster, commissionEmployee, "Commission");
        enroll(roster, basePlusEmployee, "Base Plus Commission");
        System.out.printf("Total Roster Size: %d employees%n", roster.countEmployees());
        System.out.println("======================================================================");
        System.out.println("PURE POLYMORPHIC PAYROLL REPORT (Target Month: Sep)");
        System.out.println("[No downcasting; dynamic dispatch via Employee.computeSalary()]");
        System.out.println("======================================================================");
        roster.displayPayroll(9);

        System.out.println();
        System.out.println("======================================================================");
        System.out.println("COLLECTION REMOVAL TEST");
        System.out.println("======================================================================");
        System.out.printf("Removing Employee ID 201... %s%n",
                roster.removeEmployee(201) == null ? "Employee not found." : "Successfully removed.");
        System.out.printf("Updated Roster Size: %d%n", roster.countEmployees());
        System.out.println("Current Active Employees:");
        roster.displayAllEmployees();
        System.out.println("======================================================================");
    }

    private static void enroll(EmployeeRoster roster, Employee employee, String type) {
        if (roster.addEmployee(employee)) {
            System.out.printf("Enrolled: %s (%s)%n", employee.getEmpName(), type);
        }
    }
}
