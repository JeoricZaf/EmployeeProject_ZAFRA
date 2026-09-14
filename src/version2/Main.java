/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package version2;

import version1.BasePlusCommissionEmployee;
import version1.CommissionEmployee;
import version1.HourlyEmployee;
import version1.PieceWorkerEmployee;


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

        Name myName = new Name("Jack", "Horner");
        myName.display();

        System.out.println(myName);
        System.out.println(date);

    }
}

//4. Main Driver Program (Main.java)