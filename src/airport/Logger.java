/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airport;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

//import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class Logger{

    private final Semaphore semaphore;

    public Logger() {
        semaphore = new Semaphore(1);
    }

    public void Conveyor(ArrayList<Suitcase> conveyor){
        try {

            semaphore.acquire();

            System.out.print("La CINTA tiene: ");
            for (Suitcase suitcases : conveyor){
                System.out.print(suitcases.getSuitcase() + " // ");
            }
            System.out.println("");
            System.out.println("");
        } catch(InterruptedException ie){ }
        finally{
            semaphore.release();
        }
    }

    public void PassengerCreated(Passenger passenger){
        try {

            semaphore.acquire();

            System.out.println("Se ha creado el " + passenger.getId_passenger());
        } catch(InterruptedException ie){ }
        finally{
            semaphore.release();
        }
    }
    
    public void PassengerLaunched(Passenger passenger){
        try {

            semaphore.acquire();

            System.out.println("Se ha lanzado el " + passenger.getId_passenger());
        } catch(InterruptedException ie){ }
        finally{
            semaphore.release();
        }
    }
    
    public void EmployeeCreated(Employee employee){
        try {

            semaphore.acquire();

            System.out.println("Se ha creado el " + employee.getId_employee());
        } catch(InterruptedException ie){ }
        finally{
            semaphore.release();
        }
    }

    public void EmployeeLaunched(Employee employee){
        try {

            semaphore.acquire();

            System.out.println("Se ha lanzado el " + employee.getId_employee());
        } catch(InterruptedException ie){ }
        finally{
            semaphore.release();
        }
    }

    public void EmployeeCarrySuitcase(Employee employee, Suitcase suitcase){
        try {

            semaphore.acquire();

            System.out.println("El "+ employee.getId_employee() + " lleva " + suitcase.getSuitcase());
            System.out.println("");
        } catch(InterruptedException ie){ }
        finally{
            semaphore.release();
        }
    }

    public void EmployeeGettingBack(Employee employee){
        try {

            semaphore.acquire();

            System.out.println("El "+ employee.getId_employee() + " está volviendo");
            System.out.println("");
        } catch(InterruptedException ie){ }
        finally{
            semaphore.release();
        }
    }

    public void AirplaneHold(ArrayList<Suitcase> hold){
        System.out.print("El AVIÓN tiene: ");
        for (Suitcase suitcases : hold){
            System.out.print(suitcases.getSuitcase() + " // ");
        }
        System.out.println("");
        System.out.println("");
    }
}