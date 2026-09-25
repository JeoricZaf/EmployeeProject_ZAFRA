/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package version3;

/**
 *
 * @author User
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
        this.totalSale = totalSale;
    }


    public double getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(double totalSale) {
        this.totalSale = totalSale;
    }
    
    @Override
    public double computeSalary() {
//        Below PHP 50,000: 5% commission (0.05 * totalSale)
//        PHP 50,000 to below PHP 100,000: 10% commission (0.10 * totalSale)
//        PHP 100,000 to below PHP 500,000: 15% commission (0.15 * totalSale)
//        PHP 500,000 and above: 20% commission (0.20 * totalSale)

        
        double Commission = 0;
        
        if (this.totalSale < 50_000) {
            //5% commission
            Commission = 0.05 * this.totalSale;
        }
        else if (this.totalSale >= 50_000 && this.totalSale < 100_000) {
            //10% commission
            Commission = 0.10 * this.totalSale;
        }
        else if (this.totalSale >= 100_000 && this.totalSale < 500_000) {
            //15% commission
            Commission = 0.15 * this.totalSale;
        }
        else if (this.totalSale >= 500_000) {
            //20% commission
            Commission = 0.20 * this.totalSale;
        }
        else {System.out.println("Something went wrong");}
            
         
        return Commission;
        
    }
    
    public void displayCommissionEmployee() {
        
        System.out.printf("%-45s","Employee Type: CommissionEmployee ");
        System.out.print("| ID: "+ getEmpID());
        System.out.print("| Name: "+ getEmpName());
        System.out.println("| Total Sale: "+ totalSale);
    }
    
    
    @Override
        public String toString() {
            return "Employee Type: CommissionEmployee " + 
                   " | ID: " + super.getID() +
                   " | Name: " + super.getName() +
                   " | Total Sale: " + this.totalSale +
                   " | Commission Pay: " + this.computeSalary();
            
        }
    
    

}
