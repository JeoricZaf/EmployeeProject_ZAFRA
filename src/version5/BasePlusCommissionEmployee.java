package version5;

import java.util.Objects;

/**
 *
 */

public class BasePlusCommissionEmployee extends CommissionEmployee {

    private double baseSalary;

    BasePlusCommissionEmployee() {
        super(); //note parent is CommissionEmployee, not Employee

        this.baseSalary = 0;
    }
    BasePlusCommissionEmployee(int empID, Name empName) {
        super(empID, empName);

        this.baseSalary = 0;
    }
    BasePlusCommissionEmployee(int empID, Name empName, double totalSale, double baseSalary) {
        super(empID, empName, totalSale);

        this.baseSalary = baseSalary;
    }

    public double getBaseSalary() {return baseSalary;}
    public void setBaseSalary(double baseSalary) {this.baseSalary = baseSalary;}

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

}
