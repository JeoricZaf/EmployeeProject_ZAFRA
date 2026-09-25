package version3;

public class Main {

    public static void main(String[] args) {
    int targetMonth = 9;
    MyDate hourlyBirthDate = new MyDate(18, 9, 2000);
    MyDate hourlyHireDate = new MyDate(1, 6, 2022);

    HourlyEmployee hourlyEmployee = new HourlyEmployee(
        101,
        new Name("Alice", "M", "Smith", ""),
        hourlyBirthDate,
        hourlyHireDate,
        50,
        190
    );

    PieceWorkerEmployee pieceWorkerEmployee = new PieceWorkerEmployee(
        201,
        new Name("Bob", "C", "Jones", "Jr."),
        450,
        9
    );
    pieceWorkerEmployee.setBirthDate(new MyDate(5, 4, 1998));
    pieceWorkerEmployee.setHireDate(new MyDate(15, 1, 2023));

    CommissionEmployee commissionEmployee = new CommissionEmployee(
        301,
        new Name("Carol", "D", "Brown", ""),
        120_000
    );
    commissionEmployee.setBirthDate(new MyDate(12, 9, 1995));
    commissionEmployee.setHireDate(new MyDate(10, 2, 2021));

    BasePlusCommissionEmployee basePlusEmployee =
        new BasePlusCommissionEmployee(401, new Name("David", "E", "Garcia", ""), 600_000, 25_000);
    basePlusEmployee.setBirthDate(new MyDate(30, 12, 1990));
    basePlusEmployee.setHireDate(new MyDate(20, 7, 2020));

    Employee[] employees = {
        hourlyEmployee,
        pieceWorkerEmployee,
        commissionEmployee,
        basePlusEmployee
    };

    System.out.println("======================================================================");
    System.out.println("POLYMORPHIC PAYROLL REPORT (Target Month: Sep)");
    System.out.println("======================================================================");
    for (Employee employee : employees) {
        System.out.printf("%s%n   Total Payout: ₱%.2f%n%n",
            employee.getClass().getSimpleName(), employee.computeSalary(targetMonth));
            employee.display();
    }

    System.out.println("======================================================================");
    System.out.println("OBJECT CONTRACT TESTS (equals & hashCode)");
    System.out.println("======================================================================");
    HourlyEmployee identicalEmployee = new HourlyEmployee(
        101,
        new Name("Alice", "M", "Smith", ""),
        new MyDate(18, 9, 2000),
        new MyDate(1, 6, 2022),
        50,
        190
    );
    System.out.println("equal values: " + hourlyEmployee.equals(identicalEmployee));
    System.out.println("matching hash codes: "
        + (hourlyEmployee.hashCode() == identicalEmployee.hashCode()));
    identicalEmployee.setRatePerHour(200);
    System.out.println("after modification: " + hourlyEmployee.equals(identicalEmployee));

    System.out.println("======================================================================");
    System.out.println("DEEP CLONE VERIFICATION");
    System.out.println("======================================================================");
    HourlyEmployee clonedEmployee = hourlyEmployee.clone();
    System.out.println("Original name before modification: " + hourlyEmployee.getEmpName());
    clonedEmployee.getEmpName().setFirstName("Taylor");
    clonedEmployee.getBirthDate().setMonth(10);
    System.out.println("Clone name after modification:       " + clonedEmployee.getEmpName());
    System.out.println("Clone birth month after modification: " + clonedEmployee.getBirthDate().getMonth());
    System.out.println("Original name after modification:  " + hourlyEmployee.getEmpName());
    System.out.println("Original birth month:               " + hourlyEmployee.getBirthDate().getMonth());

    }

}
