package version4;

public class EmployeeRoster {
    private Employee[] empList;
    private int max;
    private int count;

    public EmployeeRoster() {
        this(10);
    }

    public EmployeeRoster(int max) {
        if (max < 1) {
            throw new IllegalArgumentException("Roster capacity must be positive");
        }
        this.max = max;
        this.empList = new Employee[max];
        this.count = 0;
    }

    public boolean addEmployee(Employee emp) {
        if (emp == null || count >= max) {
            return false;
        }
        empList[count++] = emp;
        return true;
    }

    public Employee removeEmployee(int empID) {
        int index = findIndex(empID);
        if (index == -1) {
            return null;
        }

        Employee removed = empList[index];
        for (int current = index; current < count - 1; current++) {
            empList[current] = empList[current + 1];
        }
        empList[--count] = null;
        return removed;
    }

    public Employee searchEmployee(int empID) {
        int index = findIndex(empID);
        return index == -1 ? null : empList[index];
    }

    public int countHE() {
        int total = 0;
        for (int index = 0; index < count; index++) {
            if (empList[index] instanceof HourlyEmployee) {
                total++;
            }
        }
        return total;
    }

    public int countPWE() {
        int total = 0;
        for (int index = 0; index < count; index++) {
            if (empList[index] instanceof PieceWorkerEmployee) {
                total++;
            }
        }
        return total;
    }

    public int countCE() {
        int total = 0;
        for (int index = 0; index < count; index++) {
            if (empList[index].getClass() == CommissionEmployee.class) {
                total++;
            }
        }
        return total;
    }

    public int countBPCE() {
        int total = 0;
        for (int index = 0; index < count; index++) {
            if (empList[index] instanceof BasePlusCommissionEmployee) {
                total++;
            }
        }
        return total;
    }

    public void displayHE() {
        for (int index = 0; index < count; index++) {
            if (empList[index] instanceof HourlyEmployee employee) {
                employee.displayHourlyEmployee();
            }
        }
    }

    public void displayPWE() {
        for (int index = 0; index < count; index++) {
            if (empList[index] instanceof PieceWorkerEmployee employee) {
                employee.displayPieceWorkerEmployee();
            }
        }
    }

    public void displayCE() {
        for (int index = 0; index < count; index++) {
            if (empList[index].getClass() == CommissionEmployee.class) {
                ((CommissionEmployee) empList[index]).displayCommissionEmployee();
            }
        }
    }

    public void displayBPCE() {
        for (int index = 0; index < count; index++) {
            if (empList[index] instanceof BasePlusCommissionEmployee employee) {
                employee.displayBasePlusCommissionEmployee();
            }
        }
    }

    public void displayAllEmployees() {
        for (int index = 0; index < count; index++) {
            Employee employee = empList[index];
            System.out.printf("%d. ID: %d | Name: %s | Type: %s%n",
                    index + 1, employee.getEmpID(), formatName(employee),
                    employee.getClass().getSimpleName());
        }
    }

    public void displayPayroll(int currentMonth) {
        for (int index = 0; index < count; index++) {
            Employee employee = empList[index];
            double salary;
            String type;

            if (employee instanceof BasePlusCommissionEmployee basePlusEmployee) {
                salary = basePlusEmployee.computeSalary(currentMonth);
                type = "Base Plus Commission";
            } else if (employee instanceof CommissionEmployee commissionEmployee) {
                salary = commissionEmployee.computeSalary(currentMonth);
                type = "Commission";
            } else if (employee instanceof HourlyEmployee hourlyEmployee) {
                salary = hourlyEmployee.computeSalary(currentMonth);
                type = "Hourly";
            } else if (employee instanceof PieceWorkerEmployee pieceWorkerEmployee) {
                salary = pieceWorkerEmployee.computeSalary(currentMonth);
                type = "Piece Worker";
            } else {
                continue;
            }

            boolean birthdayBonus = employee.getBirthDate().getMonth() == currentMonth;
            System.out.printf("[%s] ID: %d | Name: %s | Salary: ₱%.2f%s%n",
                    type, employee.getEmpID(), formatName(employee), salary,
                    birthdayBonus ? " (Birthday Bonus Applied)" : "");
        }
    }

    public int getCount() {
        return count;
    }

    public int getMax() {
        return max;
    }

    private int findIndex(int empID) {
        for (int index = 0; index < count; index++) {
            if (empList[index].getEmpID() == empID) {
                return index;
            }
        }
        return -1;
    }

    private String formatName(Employee employee) {
        Name name = employee.getEmpName();
        String middleInitial = name.getMiddleName().isEmpty()
                ? ""
                : " " + name.getMiddleName().charAt(0) + ".";
        String suffix = name.getSuffix().isEmpty() ? "" : " " + name.getSuffix();
        return String.format("%s, %s%s%s", name.getLastName(), name.getFirstName(),
                middleInitial, suffix);
    }
}