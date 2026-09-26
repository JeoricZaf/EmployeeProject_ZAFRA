package version6;

import java.util.Objects;

/**
 *
 */

public final class BasePlusCommissionEmployee extends CommissionEmployee {

    private double baseSalary;

    public BasePlusCommissionEmployee() {
        super(); //note parent is CommissionEmployee, not Employee

        this.baseSalary = 0;
    }
    public BasePlusCommissionEmployee(int empID, Name empName) {
        super(empID, empName);

        this.baseSalary = 0;
    }
    public BasePlusCommissionEmployee(int empID, Name empName, double totalSale, double baseSalary) {
        super(empID, empName, totalSale);
        validateBaseSalary(baseSalary);
        this.baseSalary = baseSalary;
    }

    public double getBaseSalary() {return baseSalary;}
    public void setBaseSalary(double baseSalary) {validateBaseSalary(baseSalary); this.baseSalary = baseSalary;}

    public double computeSalary(int currentMonth) {

        double Commission = super.computeSalary(currentMonth);
        return Commission + baseSalary;

    }

    public double computeSalary() {return computeSalary(-1);}

    public void displayBasePlusCommissionEmployee() {
        System.out.printf("[Base Plus Commission] ID: %d | Name: %s | Salary: ₱%.2f%n",
                getEmpID(), getEmpName(), computeSalary());
    }

    @Override
    public void displayEmployee() {displayBasePlusCommissionEmployee();}

    @Override
    public void display(){displayBasePlusCommissionEmployee();System.out.println();}

    @Override
        public String toString() {
            return String.format("BasePlusCommissionEmployee [ID: %d, Name: %s, Total Salary: ₱%,.2f]",
                    getEmpID(), getEmpName(), computeSalary());

        }

    @Override
    public boolean equals(Object preTest) {
        if (this == preTest) return true;
        if (preTest == null || getClass() != preTest.getClass()) return false;

        BasePlusCommissionEmployee other = (BasePlusCommissionEmployee) preTest;
        return super.equals(other) && Double.compare(baseSalary, other.baseSalary) == 0;
    }

    @Override
    public int hashCode() {return Objects.hash(super.hashCode(), baseSalary);}

    @Override
    public BasePlusCommissionEmployee clone() {return (BasePlusCommissionEmployee) super.clone();}

    private void validateBaseSalary(double baseSalary) {
        if (baseSalary < 0) throw new IllegalArgumentException("Base salary cannot be negative");
    }

}
