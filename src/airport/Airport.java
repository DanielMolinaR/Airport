/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airport;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel
 */
public class Airport {

    private final Conveyor conveyor ;
    private Airplane airplane;
    private WriteFile writefile;
    private String text;
    private ArrayList<Passenger> passenger_queu;
    private ArrayList<Employee> employee_queu;
    private Server airport_interface;
    private Button button;

    
    public Airport(Server airport_interface, Button button) throws IOException{
        this.conveyor = new Conveyor(airport_interface);
        this.airplane = new Airplane(airport_interface);
        this.writefile = new WriteFile();
        this.passenger_queu = new ArrayList<>();
        this.employee_queu = new ArrayList<>();
        this.button = button;
    }

    public Airport() {
        this.conveyor = new Conveyor();
        this.airplane = new Airplane();
        this.writefile = new WriteFile();
        this.passenger_queu = new ArrayList<>();
        this.employee_queu = new ArrayList<>();

    }

    public ArrayList<Passenger> CreatePassenger() throws IOException {

        for (int i = 0; i < 40; i++) {
            Passenger passenger = new Passenger("Pasajero_" + String.valueOf(i + 1), new Suitcase("Pasajero_" + String.valueOf(i + 1) + "-Maleta_1"), 
                                                new Suitcase("Pasajero_" + String.valueOf(i + 1) + "-Maleta_2"), this.conveyor, button);
            passenger_queu.add(passenger);

            text = "Se ha creado el " + passenger.getId_passenger();

            writefile.Writer(text);
        }
        return passenger_queu;
    }

    public void StartPassenger(ArrayList<Passenger> passenger_queu) throws IOException {

        for (Passenger passenger : passenger_queu) {
            passenger.start();

            text = "Se ha lanzado el " + passenger.getId_passenger();

            writefile.Writer(text);
        }
    }

    public ArrayList<Employee> CreateEmployee() throws IOException {

        for (int i = 0; i < 2; i++) {
            Employee employee = new Employee("Empleado_" + String.valueOf(i + 1), conveyor, this.airplane, button);
            employee_queu.add(employee);

            text = "Se ha creado el " + employee.getId_employee();

            writefile.Writer(text);
        }
        return employee_queu;
    }

    public  void StartEmployee(ArrayList<Employee> employee_queu) throws IOException {

        for (Employee employee : employee_queu) {
            employee.start();

            text = "Se ha lanzado el " + employee.getId_employee();

            writefile.Writer(text);
        } 
    }
}
