package version6;

import java.util.Objects;

public class HourlyEmployee extends Employee {

    private float totalHoursWorked;
    private double ratePerHour;

    public HourlyEmployee() {
        super();
        this.totalHoursWorked = 0;
        this.ratePerHour = 0;

    }

    public HourlyEmployee(int empID, Name empName, MyDate birthDate, MyDate hireDate, float totalHoursWorked, double ratePerHour) {
        super(empID, empName, birthDate, hireDate);
        validateValues(totalHoursWorked, ratePerHour);
        this.totalHoursWorked = totalHoursWorked;
        this.ratePerHour = ratePerHour;

    }

    public float getTotalHoursWorked() {return totalHoursWorked;}
    public void setTotalHoursWorked(float totalHoursWorked) {validateValues(totalHoursWorked, ratePerHour); this.totalHoursWorked = totalHoursWorked;}

    public double getRatePerHour() {return ratePerHour;}
    public void setRatePerHour(double ratePerHour) {validateValues(totalHoursWorked, ratePerHour); this.ratePerHour = ratePerHour; }

    public void displayHourlyEmployee() {
        System.out.printf("[Hourly] ID: %d | Name: %s | Salary: ₱%.2f%n",
                getEmpID(), getEmpName(), computeSalary());
    }

    @Override
    public void displayEmployee() {displayHourlyEmployee();}

    @Override
    public void display(){displayHourlyEmployee();System.out.println();}

    @Override
    public String toString() {
        return String.format("HourlyEmployee [ID: %d, Name: %s, Total Salary: ₱%,.2f]",
            getEmpID(), getEmpName(), computeSalary());
    }

    public double computeSalary(int currentMonth) {
        double regularHours = Math.min(totalHoursWorked, 40);
        double overtimeHours = Math.max(totalHoursWorked - 40, 0);
        return regularHours * ratePerHour + overtimeHours * ratePerHour * 1.5 + getBirthdayBonus(currentMonth);

    }

    public double computeSalary() {return computeSalary(-1);}

    @Override
    public boolean equals(Object preTest) {
        if (this == preTest) return true;
        if (preTest == null || getClass() != preTest.getClass()) return false;

        HourlyEmployee other = (HourlyEmployee) preTest;
        return super.equals(other)
                && Float.compare(totalHoursWorked, other.totalHoursWorked) == 0
                && Double.compare(ratePerHour, other.ratePerHour) == 0;
    }

    @Override
    public int hashCode() {return Objects.hash(super.hashCode(), totalHoursWorked, ratePerHour);}

    @Override
    public HourlyEmployee clone() {return (HourlyEmployee) super.clone();}

    private void validateValues(float hours, double rate) {
        if (hours < 0) throw new IllegalArgumentException("Total hours worked cannot be negative");
        if (rate < 0) throw new IllegalArgumentException("Rate per hour cannot be negative");
    }

}
