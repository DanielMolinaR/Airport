/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;
import airport.*;
import java.rmi.*;

/**
 *
 * @author Antonio
 */
public class Server {
    public static void main(String[] args) throws RemoteException {
        
        System.out.println("Funciona el server¿?¿?¿?¿?¿?");
        
        try {
        Interfaceimplementation RemoteObject =  new Interfaceimplementation();
        Naming.rebind("//localhost/Airport",RemoteObject);
            }
        catch (Exception e)
            {
        System.out.println("Error: " + e.getMessage());
        e.printStackTrace();
            }
    
    
    }
    
}
