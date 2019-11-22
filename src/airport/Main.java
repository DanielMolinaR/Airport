/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airport;

import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ArrayList<Passenger> passenger_queu = new ArrayList<>();
        passenger_queu = Airport.CreatePassenger(passenger_queu);
        Airport.StartPassenger(passenger_queu);
        ArrayList<Employee> employee_queu = new ArrayList<>();
        employee_queu = Airport.CreateEmployee(employee_queu);
        Airport.StartEmployee(employee_queu);
    }
    
}
