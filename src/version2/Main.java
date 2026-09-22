/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package version2;

/**
 *
 * @author User
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        MyDate date = new MyDate(2,3,2003);

        date.display();
        System.out.println();

        Name myName = new Name("Jack", "Horner");
        myName.display();

        System.out.println(myName);
        System.out.println(date);

         Name myName2 = new Name("Jack", "Son", "Horner");
         myName2.display();

         HourlyEmployee emp = new HourlyEmployee();
         emp.displayHourlyEmployee();

    }
}

//4. Main Driver Program (Main.java)