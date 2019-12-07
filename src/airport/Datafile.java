/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airport;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.io.IOException;


//import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class Datafile{

    private Semaphore semaphore;
    private String text; 
    private Controller controller;

    

    public Datafile() {
        semaphore = new Semaphore(1);
        text = new String();
        controller = new Controller();
    }

    public void Conveyor(ArrayList<Suitcase> conveyor){
        try {

            semaphore.acquire();

            try {

                int i = 1;

                System.out.println("La CINTA tiene: ");
                text = "La CINTA tiene: ";
                for (Suitcase suitcases : conveyor){
                    System.out.print(i + (".-") + suitcases.getSuitcase() + " // ");
                    text += i + (".-") + suitcases.getSuitcase() + " // ";
                    i++;
                }
                System.out.println(" ");
                System.out.println(" ");

                controller.doLogging(this.text);
            } catch (IOException ioe){}

        } catch(InterruptedException ie){ }
        finally{
            semaphore.release();
        }
    }

    public void PassengerCreated(Passenger passenger) throws IOException {
        try {

            semaphore.acquire();

            System.out.println("Se ha creado el " + passenger.getId_passenger());
            text = "Se ha creado el " + passenger.getId_passenger();
            controller.doLogging(this.text);
        } catch(InterruptedException ie){ }
        finally{
            semaphore.release();
        }
    }
    
    public void PassengerLaunched(Passenger passenger) throws IOException{

        try {

            semaphore.acquire();
            
            System.out.println("Se ha lanzado el " + passenger.getId_passenger());
            text = "Se ha lanzado el " + passenger.getId_passenger();
            controller.doLogging(this.text);
        } catch(InterruptedException ie){ }
        finally{
            semaphore.release();
        }
    }
    
    public void EmployeeCreated(Employee employee) throws IOException {
        try {

            semaphore.acquire();

            System.out.println("Se ha creado el " + employee.getId_employee());
            text = "Se ha creado el " + employee.getId_employee();
            controller.doLogging(this.text);
            
        } catch(InterruptedException ie){ }
        finally{
            semaphore.release();
        }
    }

    public void EmployeeLaunched(Employee employee) throws IOException {
        try {

            semaphore.acquire();

            System.out.println("Se ha lanzado el " + employee.getId_employee());
            text = "Se ha lanzado el " + employee.getId_employee();
            controller.doLogging(this.text);
            
        } catch(InterruptedException ie){ }
        finally{
            semaphore.release();
        }
    }

    public void EmployeeCarrySuitcase(Employee employee, Suitcase suitcase){
        try {

            semaphore.acquire();

            try{
                System.out.println("El "+ employee.getId_employee() + " lleva " + suitcase.getSuitcase());
                System.out.println("");
                text = "El "+ employee.getId_employee() + " lleva " + suitcase.getSuitcase();
                controller.doLogging(this.text);
            } catch (IOException ioe){}

        } catch(InterruptedException ie){ }
        finally{
            semaphore.release();
        }
    }

    public void EmployeeGettingBack(Employee employee){
        try {

            semaphore.acquire();

            try{
                System.out.println("El "+ employee.getId_employee() + " está volviendo");
                System.out.println("");
                text = "El "+ employee.getId_employee() + " está volviendo";
                controller.doLogging(this.text);
            } catch (IOException ioe){}

        } catch(InterruptedException ie){ }
        finally{
            semaphore.release();
        }
    }

    public void AirplaneHold(ArrayList<Suitcase> hold){
        /*System.out.println("El AVIÓN tiene: ");
        for (Suitcase suitcases : hold){
            System.out.print(suitcases.getSuitcase() + " // ");
        }
        System.out.println("");
        System.out.println("");*/

        try {

            int i = 1;

            System.out.println("El AVIÓN tiene: ");
            text = "El AVIÓN tiene: ";
            for (Suitcase suitcases : hold){
                System.out.print(i + (".-") + suitcases.getSuitcase() + " // ");
                text += i + (".-") + suitcases.getSuitcase() + " // ";
                i++;
            }
            System.out.println(" ");
            System.out.println(" ");

            controller.doLogging(this.text);
        } catch (IOException ioe){}
    }

}