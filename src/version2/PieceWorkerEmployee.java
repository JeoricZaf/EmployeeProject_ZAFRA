/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package version2;

/**
 *
 * @author User
 */
public class PieceWorkerEmployee {
    
    private int empID;
    private Name empName;
    private MyDate birthDate;
    private MyDate hireDate;

    private int totalPiecesFinished;
    private double ratePerPiece;

    public PieceWorkerEmployee() {
        this.empID = 0;
        this.empName = new Name("No_Name");
        this.birthDate = new MyDate(); //by default both dates will be jan 1 2026
        this.hireDate = new MyDate();

        this.totalPiecesFinished = 0;
        this.ratePerPiece = 0;
    }
    
    public PieceWorkerEmployee(int empID, String fName, String lName, int day, int month, int year) {
        this.empID = empID;
        this.empName = new Name(fName, lName); ;
        this.hireDate = new MyDate(day, month, year);
        this.totalPiecesFinished = 0;
        this.ratePerPiece = 0;
    }
    public PieceWorkerEmployee(int empID, String fName, String lName, String mName, int totalPiecesFinished, double ratePerPiece, int bday, int bmonth, int byear, int Hireday, int Hiremonth, int Hireyear) {
        this.empID = empID;
        this.empName = new Name(fName, mName, lName );
        this.birthDate = new MyDate(bday, bmonth, byear);
        this.hireDate = new MyDate(Hireday, Hiremonth, Hireyear);

        this.totalPiecesFinished = totalPiecesFinished;
        this.ratePerPiece = ratePerPiece;
    }

    public int getEmpID() {return empID;}
    public void setEmpID(int empID) {this.empID = empID;}

    public Name getEmpName() {return empName;}
    public void setEmpName(String firstName, String middleName, String lastName) {
        this.empName.setFirstName(firstName);
        this.empName.setMiddleName(middleName);
        this.empName.setLastName(lastName);
    }


    public MyDate getBirthDate() {return this.birthDate;}
    public void setBirthDate(int day, int month, int year) {
        this.birthDate.setDay(day) ; 
        this.birthDate.setMonth(month); 
        this.birthDate.setYear(year); 
    }

    public MyDate getHireDate() {return this.hireDate;}
    public void setHireDate(int day, int month, int year) {
        this.hireDate.setDay(day) ; 
        this.hireDate.setMonth(month); 
        this.hireDate.setYear(year);  
    
    
    }



    public int getTotalPiecesFinished() {return totalPiecesFinished;}
    public void setTotalPiecesFinished(int totalPiecesFinished) {
        this.totalPiecesFinished = totalPiecesFinished;
    }

    public double getRatePerPiece() {return ratePerPiece;}
    public void setRatePerPiece(double ratePerPiece) {
        this.ratePerPiece = ratePerPiece;
    }
    
    
    public double computeSalary() {
//        
//        Base pay: totalPiecesFinished * ratePerPiece.
    //Bonus rule: For every complete hundred (100) pieces finished, add a bonus equal to 10 * ratePerPiece.
    //Bonus pieces factor: floor(totalPiecesFinished / 100) * (10 * ratePerPiece).
    //Total Salary = Base Pay + Bonus Pay. 
        
        double BasePay = this.totalPiecesFinished * this.ratePerPiece;
        
        double BonusPay = Math.floor(this.totalPiecesFinished / 100) * (this.ratePerPiece * 10);
        
        return BasePay + BonusPay;

    }

    public double computeSalary(int currentMonth) {

        double new_salary = this.computeSalary();

        //if current month is birthmonth, add bonus 5000 salary
        if (currentMonth == this.birthDate.getMonth()) {
            new_salary += 5000;
        }

        return new_salary;
    }

    
    public void displayBasePlusCommissionEmployee() {
        
        System.out.printf("%-44s","Employee Type: PieceWorkerEmployee");
        System.out.printf(" | ID: %-3s",this.empID);
        System.out.print(" | Name: "+ this.empName);
        System.out.print(" | Total Pieces Finished: "+ this.totalPiecesFinished);
        System.out.print(" | Rate Per Piece: "+ this.ratePerPiece);
        System.out.print(" | Total Salary: " + this.computeSalary());
        System.out.print(" | BirthMonth Salary: " + this.computeSalary(this.birthDate.getMonth()) );
    }   
    
    
    @Override
        public String toString() {
            return 
                    String.format("%-44s", "Employee Type: PieceWorkerEmployee") +
                    String.format(" | ID: %-3s", this.empID) +
                   " | Name: " + this.empName +
                   " | Total Pieces Finished: " + this.totalPiecesFinished+
                   " | Rate Per Piece: " + this.ratePerPiece +
                   " | Total Salary: " + this.computeSalary();
            
        }
    
    
    
}
//
//Class 2: PieceWorkerEmployee
//Attributes (Private)
//    empID: int
//    empName: String
//    totalPiecesFinished: int
//    ratePerPiece: double
//Constructors
//    Default-like Constructor: PieceWorkerEmployee() — defaults numeric values to 0 and string to "N/A".
//    Partial Constructor: PieceWorkerEmployee(int empID, String empName) — initializes ID and name, leaves piece counts at 0.
//    Full Constructor: PieceWorkerEmployee(int empID, String empName, int totalPiecesFinished, double ratePerPiece) — initializes all fields.
//Methods
//    Getters and Setters: Complete set for all 4 attributes.
//    computeSalary(): double
//        Base pay: $\text{totalPiecesFinished} \times \text{ratePerPiece}$.
//        Bonus rule: For every complete hundred (100) pieces finished, add a bonus equal to $10 \times \text{ratePerPiece}$.
//        Bonus pieces factor: $\lfloor \frac{\text{totalPiecesFinished}}{100} \rfloor \times (10 \times \text{ratePerPiece})$.
//        Total Salary = Base Pay + Bonus Pay.
//    displayPieceWorkerEmployee(): void
//        Prints empID, empName, totalPiecesFinished, and ratePerPiece.
//    toString(): String (Overridden) 
//        Returns formatted string of all details including computeSalary().
