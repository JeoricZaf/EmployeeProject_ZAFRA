package version6;

import java.util.Objects;

/**
 *
 */
public class CommissionEmployee extends Employee {

    private double totalSale;
    private double CommissionRate;

    public CommissionEmployee() {
        super();

        this.totalSale = 0;
    }

    public CommissionEmployee(int empID, Name empName) {
        super(empID, empName);

        this.totalSale = 0;

    }

    public CommissionEmployee(int empID, Name empName, double totalSale) {
        super(empID, empName);
        validateTotalSale(totalSale);
        this.totalSale = totalSale;
    }

    public double getTotalSale() {return totalSale;}

    public void setTotalSale(double totalSale) {validateTotalSale(totalSale); this.totalSale = totalSale;}

    public double getCommissionRate() {return CommissionRate;}

    public double computeSalary(int currentMonth) {
//        Below PHP 50,000: 5% commission (0.05 * totalSale)
//        PHP 50,000 to below PHP 100,000: 10% commission (0.10 * totalSale)
//        PHP 100,000 to below PHP 500,000: 15% commission (0.15 * totalSale)
//        PHP 500,000 and above: 20% commission (0.20 * totalSale)

        double Salary;

        if (this.totalSale < 50_000) {
            //5% commission
            this.CommissionRate = 0.05;
        }
        else if (this.totalSale >= 50_000 && this.totalSale < 100_000) {
            //10% commission
            this.CommissionRate = 0.10;
        }
        else if (this.totalSale >= 100_000 && this.totalSale < 500_000) {
            //15% commission
            this.CommissionRate = 0.15;
        }
        else if (this.totalSale >= 500_000) {
            //20% commission
            this.CommissionRate = 0.20;

        }
        else {System.out.println("Something went wrong"); return -1;}

        Salary = this.CommissionRate * this.totalSale;
        return Salary + getBirthdayBonus(currentMonth);

    }

    public double computeSalary() {return computeSalary(-1);}

    public void displayCommissionEmployee() { //will have the complete salaries
        System.out.printf("[Commission] ID: %d | Name: %s | Salary: ₱%.2f%n",
            getEmpID(), getEmpName(), computeSalary());
    }

    @Override
    public void displayEmployee() {displayCommissionEmployee();}

    @Override
    public void display(){displayCommissionEmployee();System.out.println();}

    @Override
        public String toString() {//to string wont have salary so that subclasses can append to it. salary is always last
            return String.format("CommissionEmployee [ID: %d, Name: %s, Total Salary: ₱%,.2f]",
                    getEmpID(), getEmpName(), computeSalary());

        }

     @Override
    public boolean equals(Object preTest) {
        if (this == preTest) return true;
        if (preTest == null || getClass() != preTest.getClass()) return false;

        CommissionEmployee other = (CommissionEmployee) preTest;
        return super.equals(other) && Double.compare(totalSale, other.totalSale) == 0;
    }

    @Override
    public int hashCode() {return Objects.hash(super.hashCode(), totalSale);}

    @Override
    public CommissionEmployee clone() {return (CommissionEmployee) super.clone();}

    private void validateTotalSale(double totalSale) {
        if (totalSale < 0) throw new IllegalArgumentException("Total sale cannot be negative");
    }

}
