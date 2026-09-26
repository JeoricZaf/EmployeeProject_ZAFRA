package version5;

import java.util.ArrayList;

public class EmployeeRoster {
    private final ArrayList<Employee> empList;

    public EmployeeRoster() {
        this.empList = new ArrayList<>();
    }

    public EmployeeRoster(int initialCapacity) {
        this.empList = new ArrayList<>(initialCapacity);
    }

    public boolean addEmployee(Employee emp) {
        if (emp == null) {
            return false;
        }
        return empList.add(emp);
    }

    public Employee removeEmployee(int empID) {
        int index = findIndex(empID);
        if (index == -1) {
            return null;
        }

        return empList.remove(index);
    }

    public Employee searchEmployee(int empID) {
        int index = findIndex(empID);
        return index == -1 ? null : empList.get(index);
    }

    public int countHE() {
        int total = 0;
        for (Employee employee : empList) {
            if (employee instanceof HourlyEmployee) {
                total++;
            }
        }
        return total;
    }

    public int countPWE() {
        int total = 0;
        for (Employee employee : empList) {
            if (employee instanceof PieceWorkerEmployee) {
                total++;
            }
        }
        return total;
    }

    public int countCE() {
        int total = 0;
        for (Employee employee : empList) {
            if (employee.getClass() == CommissionEmployee.class) {
                total++;
            }
        }
        return total;
    }

    public int countBPCE() {
        int total = 0;
        for (Employee employee : empList) {
            if (employee instanceof BasePlusCommissionEmployee) {
                total++;
            }
        }
        return total;
    }

    public void displayPayroll(int currentMonth) {
        for (Employee employee : empList) {
            double salary = employee.computeSalary(currentMonth);
            boolean birthdayBonus = employee.getBirthDate().getMonth() == currentMonth;
                System.out.printf("ID: %d | Name: %s | Payout: ₱%,.2f%s%n",
                    employee.getEmpID(), employee.getEmpName(), salary,
                    birthdayBonus ? " (Birthday Bonus Applied)" : "");
        }
    }

    public int countEmployees() {return empList.size();}

    public int getCount() {return countEmployees();}

    private int findIndex(int empID) {
        for (int index = 0; index < empList.size(); index++) {
            if (empList.get(index).getEmpID() == empID) {
                return index;
            }
        }
        return -1;
    }

    public void displayAllEmployees() {
        for (int index = 0; index < empList.size(); index++) {
            System.out.println((index + 1) + ". " + empList.get(index));
        }
    }
}
