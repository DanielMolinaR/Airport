/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;
import airport.*;
import java.rmi.*;

/**
 *
 * @author Antonio
 */
public class Server {
    
    public static void main(String[] args) throws RemoteException {
        try {
        InterfaceImplement RemoteObject =  new InterfaceImplement();
        Naming.rebind("//127.0.0.1/Airport",RemoteObject);
        System.out.println("El objeto Saluda ha quedado registrado");
            }
        catch (Exception e)
            {
        System.out.println("Error: " + e.getMessage());
        e.printStackTrace();
            }
    
    
    }
    
}
