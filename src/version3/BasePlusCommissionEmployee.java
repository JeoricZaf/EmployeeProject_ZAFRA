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
    public double computeSalary() {
        
        double Commission = super.computeSalary();
        return Commission + baseSalary;

    }
    
    public void displayBasePlusCommissionEmployee() {
        
        displayCommissionEmployee();
        System.out.print("| Base Salary: "+ baseSalary);
        
    }
    
    
    @Override
        public String toString() {
            return 
                String.format("%-28s  [ID: %-3s, Name: %s,  Total Sales: %s, Commission Rate: %s, Base Salary: %s, Total Base Plus Commission: %s",
            "BasePlusCommissionEmployee",getEmpID(), getEmpName(), getTotalSale(), getCommissionRate(), baseSalary,         computeSalary() );
             
        }
    
}

