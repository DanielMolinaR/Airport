/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;
import airport.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Antonio
 */
public class Interfaceimplementation extends UnicastRemoteObject implements CommonInterface {
    
    private Conveyor conveyor;
    private Airplane airplane;
    
    public Interfaceimplementation() throws RemoteException{}
    @Override
    public String Print() throws RemoteException{
        String text = conveyor.Print();
        return text;
    }
    @Override
    public String PrintA() throws RemoteException{
        String text = airplane.PrintA();
        return text;
    }
    
}
