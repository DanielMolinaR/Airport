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
    private Interface airport_interface;

    
    public Airport(Interface airport_interface) throws IOException{
        this.conveyor = new Conveyor(airport_interface);
        this.airplane = new Airplane(airport_interface);
        this.writefile = new WriteFile();
        this.passenger_queu = new ArrayList<>();
        this.employee_queu = new ArrayList<>();
    }

    public Conveyor getConveyor(){
        return this.conveyor;
    }

    public Airplane getAirplane(){
        return this.airplane;
    }
    

    public ArrayList<Passenger> CreatePassenger() throws IOException {

        for (int i = 0; i < 40; i++) {
            Passenger passenger = new Passenger("Pasajero_" + String.valueOf(i + 1), new Suitcase("Pasajero_" + String.valueOf(i + 1) + "-Maleta_1"), 
                                                new Suitcase("Pasajero_" + String.valueOf(i + 1) + "-Maleta_2"), this.conveyor);
            passenger_queu.add(passenger);

            System.out.println("Se ha creado el " + passenger.getId_passenger());
            text = "Se ha creado el " + passenger.getId_passenger();

            writefile.Writer(text);
        }
        return passenger_queu;
    }

    public void StartPassenger(ArrayList<Passenger> passenger_queu) throws IOException {

        for (Passenger passenger : passenger_queu) {
            passenger.start();

            System.out.println("Se ha lanzado el " + passenger.getId_passenger());
            text = "Se ha lanzado el " + passenger.getId_passenger();

            writefile.Writer(text);
        }
    }

    public ArrayList<Employee> CreateEmployee() throws IOException {

        for (int i = 0; i < 2; i++) {
            Employee employee = new Employee("Empleado_" + String.valueOf(i + 1), conveyor, this.airplane);
            employee_queu.add(employee);

            System.out.println("Se ha creado el " + employee.getId_employee());
            text = "Se ha creado el " + employee.getId_employee();

            writefile.Writer(text);
        }
        return employee_queu;
    }

    public  void StartEmployee(ArrayList<Employee> employee_queu) throws IOException {

        for (Employee employee : employee_queu) {
            employee.start();

            System.out.println("Se ha lanzado el " + employee.getId_employee());
            text = "Se ha lanzado el " + employee.getId_employee();

            writefile.Writer(text);
        } 
    }

    /*
    // Start and stop of threads
    public void Pause1Employee(ArrayList <Employee> employee_queu, String employee_stopped) {

        int i = 0;
        while (!employee_stopped.equals(employee_queu.get(i).getId_employee())){
            i++;
        }

        try {
            employee_queu.get(i).wait(); 
        }
        catch (InterruptedException ie){}

    }

    public void Launch1Employee(ArrayList <Employee> employee_queu, String employee_stopped){

        int i = 0;
        while (!employee_stopped.equals(employee_queu.get(i).getId_employee())){
            i++;
        }

        employee_queu.get(i).notify(); 

    }

    public void PauseAllEmployess(ArrayList <Employee> employee_queu){

        for (int i = 0; i<employee_queu.size(); i++){
            try {
                employee_queu.get(i).wait(); 
            }
            catch (InterruptedException ie){}
        }
    }

    public void LaunchAllEmployees(ArrayList <Employee> employee_queu){

        for (int i = 0; i<employee_queu.size(); i++){
            employee_queu.get(i).notify(); 
        }
    }

    public void PauseAll(ArrayList <Employee> employee_queu, ArrayList <Passenger> passenger_queu){

        PauseAllEmployess(employee_queu);

        for (int i = 0; i<passenger_queu.size(); i++){
            try {
                passenger_queu.get(i).wait();
            }
            catch (InterruptedException ie){}
        }
    }

    public void LaunchAll(ArrayList <Employee> employee_queu, ArrayList <Passenger> passenger_queu){

        LaunchAllEmployees(employee_queu);

        passenger_queu.notifyAll();
        /*for (int i = 0; i<passenger_queu.size(); i++){
            passenger_queu.get(i).notify();
        }
    }*/

}
