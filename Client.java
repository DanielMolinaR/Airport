/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;
import java.rmi.*;
import java.io.*;
import static java.lang.Thread.sleep;
import java.rmi.server.RemoteObject;

/**
 *
 * @author Antonio
 */
public class Client {
    public static void main(String args[])
    {
        String respuesta = "";
        try
        {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("¿Que quiere consultar? C = cinta, P= pasajero , E = empleado:");
            String consulta = entrada.readLine();
            RemoteObject = (CommonInterface) Naming.lookup("//127.0.0.1/Airport"); //Localiza el objeto distribuido
            if (consulta =="c" ){
                WantConveyor = RemoteObject.ShowConveyor();
            }
            else if (consulta == "p"){
                WantPassenger = RemoteObject.ShowPassenger();
            }
            else if (consulta == "e"){
                 WantEmployee  = RemoteObject.ShowEmployee();
                
            }
            
            
            System.out.println(respuesta);
            sleep(1000); //Para que dé tiempo a leer la respuesta antes de que se cierre la ventana
        }
        catch (Exception e)
        {
            System.out.println("Excepción : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
    

