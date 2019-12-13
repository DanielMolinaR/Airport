

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import airport.*;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry; 
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Antonio
 */
public class Server {

    public static void main(String[] args) {
        try {
        Interfaceimplementation obj =  new Interfaceimplementation();
        Registry registry = LocateRegistry.createRegistry(2118);
        Naming.rebind("//localhost/Conveyor", obj);
        System.out.println("El objeto Saluda ha quedado registrado");
            }
        catch (Exception e)
            {
        System.out.println("Error: " + e.getMessage());
        e.printStackTrace();
            }
    
    
    }
    
}
