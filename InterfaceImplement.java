/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Antonio
 */
public class InterfaceImplement extends UnicastRemoteObject implements CommonInterface {
    
    public InterfaceImplement() throws RemoteException{}
    public string ShowConveyor() throws RemoteException{}
    public string ShowPassenger() throws RemoteException{}
    public string ShowEmployee() throws RemoteException{}
    
}
