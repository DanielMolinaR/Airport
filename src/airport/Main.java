/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airport;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        Airport airport = new Airport();
        ArrayList<Passenger> passenger_queu = new ArrayList<>();
        passenger_queu = airport.CreatePassenger(passenger_queu);
        airport.StartPassenger(passenger_queu);
        ArrayList<Employee> employee_queu = new ArrayList<>();
        employee_queu = airport.CreateEmployee(employee_queu);
        airport.StartEmployee(employee_queu);
    }
    
}
