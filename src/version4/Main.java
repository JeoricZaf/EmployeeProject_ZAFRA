package version4;

public class Main {

    public static void main(String[] args) {
        int targetMonth = 9;
        EmployeeRoster roster = new EmployeeRoster(6);

        HourlyEmployee hourlyEmployee = new HourlyEmployee(101,
                new Name("Alice", "M", "Smith", ""), new MyDate(18, 9, 2000),
                new MyDate(1, 6, 2022), 50, 190);
        PieceWorkerEmployee pieceWorkerEmployee = new PieceWorkerEmployee(201,
                new Name("Bob", "C", "Jones", "Jr."), 450, 9);
        CommissionEmployee commissionEmployee = new CommissionEmployee(301,
                new Name("Maria", "L", "Reyes", ""), 120_000);
        BasePlusCommissionEmployee basePlusEmployee = new BasePlusCommissionEmployee(401,
                new Name("Kevin", "S", "Tan", ""), 60_000, 25_000);
        HourlyEmployee secondHourlyEmployee = new HourlyEmployee(102,
                new Name("David", "A", "White", ""), new MyDate(2, 4, 2001),
                new MyDate(1, 1, 2024), 40, 200);

        commissionEmployee.setBirthDate(new MyDate(12, 9, 1995));
        basePlusEmployee.setBirthDate(new MyDate(30, 12, 1990));

        System.out.println("======================================================================");
        System.out.println("EMPLOYEE ROSTER INITIALIZATION & ENROLLMENT");
        System.out.println("======================================================================");
        Employee[] employees = {hourlyEmployee, pieceWorkerEmployee, commissionEmployee,
                                basePlusEmployee, secondHourlyEmployee};
        for (Employee employee : employees) {
                        System.out.printf("Added: %s (%s) -> %s%n", formatName(employee), employeeType(employee),
                    roster.addEmployee(employee) ? "Success" : "Failed");
        }
                EmployeeRoster fullRoster = new EmployeeRoster(1);
                fullRoster.addEmployee(hourlyEmployee);
                System.out.println("Capacity check: " + (fullRoster.addEmployee(pieceWorkerEmployee) ? "Failed" : "Passed"));

        System.out.println("--- ROSTER COMPOSITION COUNTS ---");
        System.out.printf("Total Employees: %d / %d%nHourly Employees: %d%nPiece Worker Employees: %d%nCommission Employees (Pure): %d%nBase Plus Commission Employees: %d%n",
                roster.getCount(), roster.getMax(), roster.countHE(), roster.countPWE(),
                roster.countCE(), roster.countBPCE());

        System.out.println("--- EMPLOYEE SEARCH ---");
        Employee searchedEmployee = roster.searchEmployee(301);
        System.out.printf("Search Employee ID 301: %s%n",
                searchedEmployee == null ? "Not found." : formatName(searchedEmployee));

        System.out.println("======================================================================");
        System.out.println("ROSTER PAYROLL REPORT (Target Month: Sep)");
        System.out.println("======================================================================");
        roster.displayPayroll(targetMonth);

        System.out.println("======================================================================");
        System.out.println("CATEGORICAL DISPLAY");
        System.out.println("======================================================================");
        roster.displayHE();
        roster.displayPWE();
        roster.displayCE();
        roster.displayBPCE();

        System.out.println("======================================================================");
        System.out.println("TESTING EMPLOYEE REMOVAL & ARRAY COMPACTION");
        System.out.println("======================================================================");
        System.out.printf("Removing Employee ID 201 (%s)... %s%n", formatName(pieceWorkerEmployee),
                roster.removeEmployee(201) == null ? "Not found." : "Successfully removed.");
        System.out.println("Current Employee Count: " + roster.getCount());
        roster.displayAllEmployees();
        System.out.println("======================================================================");

    }

        private static String employeeType(Employee employee) {
                if (employee instanceof BasePlusCommissionEmployee) {
                        return "Base Plus Commission";
                }
                if (employee instanceof CommissionEmployee) {
                        return "Commission";
                }
                if (employee instanceof HourlyEmployee) {
                        return "Hourly";
                }
                return "Piece Worker";
        }

        private static String formatName(Employee employee) {
                Name name = employee.getEmpName();
                String middleInitial = name.getMiddleName().isEmpty()
                                ? ""
                                : " " + name.getMiddleName().charAt(0) + ".";
                String suffix = name.getSuffix().isEmpty() ? "" : " " + name.getSuffix();
                return String.format("%s, %s%s%s", name.getLastName(), name.getFirstName(),
                                middleInitial, suffix);

                                
        }

        
}
