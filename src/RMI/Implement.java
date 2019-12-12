/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RMI;
import airport.*;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Antonio
 */
public class Implement extends UnicastRemoteObject implements CommonInterface {
    
    public Implement() throws RemoteException{}
   
    public void ShowConveyor(Airport ae) throws RemoteException{
        ae.getConveyor().showConveyor();
    }
    public void ShowAirplane(Airport ae) throws RemoteException{
        ae.getAirplane().ShowAirplane();
    }
       
}