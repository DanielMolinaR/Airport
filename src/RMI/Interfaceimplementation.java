/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RMI;

import airport.*;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


/**
 *
 * @author Antonio
 */
public class Interfaceimplementation extends UnicastRemoteObject implements CommonInterface {
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public Interfaceimplementation() throws RemoteException {
        
        try {

            Naming.rebind("//localhost/MyServer", new Interfaceimplementation());            
            System.err.println("Server ready");

        } catch (Exception e) {

            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();

        }  
        
    }

    public String Print(String text) throws RemoteException {
        return text;    
    }
    
    public String PrintA(String text_a) throws RemoteException {
        return text_a;    
    }
    
}