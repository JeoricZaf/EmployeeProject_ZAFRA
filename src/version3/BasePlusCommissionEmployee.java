/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package version3;

/**
 *
 * @author User
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
    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }
    
    @Override 
    public double computeSalary(int currentMonth) {
        
        double Commission = super.computeSalary(currentMonth);
        return Commission + baseSalary;

    }
    
    public void displayBasePlusCommissionEmployee() {
        System.out.printf("%-28s", "BasePlusCommissionEmployee");
        System.out.printf(" [%s | Base Salary: %.2f | Total Salary %s | Birthday Salary %s]", 
                        super.toString(), baseSalary, computeSalary(), computeSalary(getBirthDate().getMonth()));
        System.out.println();
    }
    
    
    @Override
        public String toString() {
            return 
                String.format("%s | Base Salary: %s",
                                    super.toString(), baseSalary );
             
        }
    
}

