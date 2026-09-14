/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package version1;

/**
 *
 * @author User
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
//        Instantiation
        HourlyEmployee Emp1 = new HourlyEmployee();
            Emp1.setEmpID(56);
            Emp1.setEmpName("Beebee");
            Emp1.setRatePerHour(123);
            Emp1.setTotalHoursWorked(50);
        
        HourlyEmployee Emp2 = new HourlyEmployee(101, "Bob", 15, 100);
        
        
        
        PieceWorkerEmployee Emp3 = new PieceWorkerEmployee(102, "Henry");
            Emp3.setRatePerPiece(123);
            Emp3.setTotalPiecesFinished(50);
        
        PieceWorkerEmployee Emp4 = new PieceWorkerEmployee(120, "Jenry", 23, 300);
        
        
        
        CommissionEmployee Emp5 = new CommissionEmployee();
            //no sets for this
            
        CommissionEmployee Emp6 = new CommissionEmployee(134, "Benry", 55000);
        
        
        
        
        BasePlusCommissionEmployee Emp7 = new BasePlusCommissionEmployee(321, "Benson" );
        BasePlusCommissionEmployee Emp8 = new BasePlusCommissionEmployee(332, "Hendrickson", 433000, 1000  );
        
//        Display Execution
 System.out.println("DISPLAY EXECUTION");
        Emp1.displayHourlyEmployee();
        Emp2.displayHourlyEmployee();
        Emp3.displayBasePlusCommissionEmployee();
        Emp4.displayBasePlusCommissionEmployee();
        Emp5.displayCommissionEmployee();
        Emp6.displayCommissionEmployee();
        Emp7.displayBasePlusCommissionEmployee();
        Emp8.displayBasePlusCommissionEmployee();
        
        System.out.println("\n\n");
//        String Conversion Execution
System.out.println("STRING CONVERSION EXECUTION");

        System.out.println(Emp1);
        System.out.println(Emp2);
        System.out.println(Emp3);
        System.out.println(Emp4);
        System.out.println(Emp5);
        System.out.println(Emp6);
        System.out.println(Emp7);
        System.out.println(Emp8);
        
    }
    
}

//4. Main Driver Program (Main.java)
//Create a test class with a main method that executes the following test routine:
//Instantiation:
//Create at least two instances per employee type:
//One instance initialized using the default/partial constructor followed by setter calls.
//One instance initialized directly using the full-argument constructor.
//Display Execution:
//Invoke the dedicated display...() method on each instance to show pure record data.
//String Conversion Execution:
//Print each object directly using System.out.println(instance) to trigger and test the overridden toString() implementation with computed payroll numbers.
