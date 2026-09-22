package version3;

public class Employee {

    private int empID;
    private Name empName;
    private MyDate birthDate;
    private MyDate hireDate;

    public Employee() {
        this.empID = 0;
        this.empName = new Name();
        this.birthDate = new MyDate(); //by default both dates will be jan 1 2026
        this.hireDate = new MyDate();

    }

    public Employee(int empID, String fName, String lName, int day, int month, int year) {
        this.empID = empID;
        this.empName = new Name(fName, lName); ;
        this.hireDate = new MyDate(day, month, year);


    }
    
      public Employee(int empID, String fName, String lName, String mName, int bday, int bmonth, int byear, int Hireday, int Hiremonth, int Hireyear) {
        this.empID = empID;
        this.empName = new Name(fName, mName, lName );
        this.birthDate = new MyDate(bday, bmonth, byear);
        this.hireDate = new MyDate(Hireday, Hiremonth, Hireyear);
        
    }

    public int getEmpID() {return empID;}
    public void setEmpID(int empID) {this.empID = empID;}

    public Name getEmpName() {return empName;}
    public void setEmpName(String firstName, String middleName, String lastName) {
        this.empName.setFullName(firstName, middleName, lastName);
    }

    public MyDate getBirthDate() {return this.birthDate;}
    public void setBirthDate(int day, int month, int year) {
        this.birthDate.setFullDate(day, month, year);
    }

    public MyDate getHireDate() {return this.hireDate;}
    public void setHireDate(int day, int month, int year) {
        this.hireDate.setFullDate(day, month, year);
    }


    public double computeSalary() {
        double salary = 0;
        
        //idk whats the base pay here

        return salary;
        
    }

    public double computeSalary(int currentMonth) {
        //overloaded salary func

        double salary = this.computeSalary();

        //if current month is birthmonth, add bonus 5000 salary
        if (currentMonth == this.birthDate.getMonth()) {
            salary += 5000;
        }

        return salary;
    }


    public void displayEmployee(){
        
        System.out.printf("ID: %-3s",this.empID);
        System.out.print(" | Name: " + this.empName);
        System.out.print(" | DOB: " + this.birthDate); 
        System.out.print(" | Hired: " + this.hireDate); 
                
        
    }
    
    @Override
    public String toString() {
        return   
                String.format("%-28s", "Employee") +
                String.format(" [ID: %-3s", this.empID) +
                ", Name: " +  this.empName +
                ", DOB: " +   this.birthDate +
                ", Hired: " + this.hireDate +
                " ]"
                ;
    }

    @Override 
    public equals(Object obj) {

    }

    @Override 
    public hashCode() {
        
    }
    
    @Override 
    public clone() {
        
    }















}
