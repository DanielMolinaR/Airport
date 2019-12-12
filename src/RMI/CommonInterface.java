/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;
import java.rmi.Remote;
import java.rmi.RemoteException;

import airport.Airport;

/**
 *
 * @author Antonio
 */
public interface CommonInterface extends Remote{
    
    void ShowConveyor(Airport ae) throws RemoteException;
    void ShowAirplane(Airport ae) throws RemoteException;
   
}
