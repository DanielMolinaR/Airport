/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;
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
    
    public Interfaceimplementation(Conveyor conveyor, Airplane airplane) throws RemoteException{
    this.conveyor = conveyor;
    this.airplane= airplane;
            }
    @Override
    public String Print() throws RemoteException{
        
        return conveyor.Print();
    }
    @Override
    public String PrintA() throws RemoteException{
        
        return airplane.PrintA();
    }
    
}
