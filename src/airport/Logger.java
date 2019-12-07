/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airport;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class Logger{

    private Semaphore semaphore;
    String text; 

    public Logger() {
        semaphore = new Semaphore(1);
        text = new String();
    }

    public void Conveyor(ArrayList<Suitcase> conveyor){
        try {

            semaphore.acquire();

            System.out.println("La CINTA tiene: ");
            for (Suitcase suitcases : conveyor){
                System.out.print(suitcases.getSuitcase() + " // ");
            }
            System.out.println(" ");
            System.out.println(" ");
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
    
    public void PassengerLaunched(Passenger passenger) throws IOException{
        try {

            semaphore.acquire();

            System.out.println("Se ha lanzado el " + passenger.getId_passenger());
            text = "Se ha lanzado el " + passenger.getId_passenger();
            WriteFile(this.text);
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
        System.out.println("El AVIÓN tiene: ");
        for (Suitcase suitcases : hold){
            System.out.print(suitcases.getSuitcase() + " // ");
        }
        System.out.println("");
        System.out.println("");
    }

    public void WriteFile (String text) throws IOException{
        BufferedWriter out = new BufferedWriter(new FileWriter("Airport.txt"));
        out.write(text);
        out.flush();
        out.close();

        File airport = new File("Airport.txt");

        Desktop desktop = Desktop.getDesktop();
        desktop.print(airport);
    }
}