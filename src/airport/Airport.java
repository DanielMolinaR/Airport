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
public class Airport {

    private static Suitcase suitcase;

    public static ArrayList<Passenger> CreatePassenger(ArrayList<Passenger> passenger_queu) {

        for (int i = 0; i < 40; i++) {
            Passenger passenger = new Passenger("Pasajero_", suitcase, suitcase);
            passenger.setId_passenger("Pasajeor_"+ (i+1));
            passenger_queu.add(passenger);
            System.out.println("Se ha creado el "+ passenger.getId_passenger());
        }
        return passenger_queu;
    }

    public static void StartPassenger(ArrayList<Passenger> passenger_queu){

        for (Passenger passenger : passenger_queu){
            passenger.start();
            System.out.println("Se ha lanzado el "+ passenger.getId_passenger());
        }
    }

    public static ArrayList<Employee> CreateEmployee(ArrayList<Employee> employee_queu) {

        for (int i = 0; i < 2; i++) {
            Employee employee = new Employee("Empleado_");
            employee.setId_employee("Empleado_"+ (i+1));
            employee_queu.add(employee);
            System.out.println("Se ha creado el "+ employee.getId_employee());
        }
        return employee_queu;
    }

    public static void StartEmployee(ArrayList<Employee> employee_queu){

        for (Employee employee : employee_queu){
            employee.start();
            System.out.println("Se ha lanzado el "+ employee.getId_employee());
        }
    }
}
