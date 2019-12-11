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
public class InterfaceImplement extends UnicastRemoteObject implements CommonInterface {
    
    public InterfaceImplement() throws RemoteException{}
   
    public void ShowConveyor() throws RemoteException{

        public void LeaveSuitcaseConveyor(Suitcase suitcase) throws FileNotFoundException {
            private ArrayList<Suitcase> conveyor;
            private Lock locket_conveyor = new ReentrantLock();
            private Condition full = locket_conveyor.newCondition();
            private Condition empty = locket_conveyor.newCondition();

            try {
                    locket_conveyor.lock();
                    try {
                        if (this.isConveyorFull())
                            full.await();
                    } catch(InterruptedException ie){ }
                    conveyor.add(suitcase);
        
                    int i = 1;
        
                    System.out.println("La CINTA tiene: ");
                    
                    for (Suitcase suitcases : conveyor){
                        System.out.print(i + (".-") + suitcases.getSuitcase() + " // ");
                        
                        i++;
                    }
                    System.out.println(" ");
                    System.out.println(" ");
        
                    empty.signal();
                }
                finally{
                    
                    locket_conveyor.unlock();
                }
            } 
    }
    public void ShowAirplane() throws RemoteException{
        public void LeaveSuitcaseAirplane(Suitcase suitcase) throws FileNotFoundException {
            try {
                locket_airplane.lock();
                this.hold.add(suitcase);
    
                int i = 1;
    
                System.out.println("El AVIÓN tiene: ");
               
                for (Suitcase suitcases : hold){
                    System.out.print(i + (".-") + suitcases.getSuitcase() + " // ");
                    
                    i++;
                }
                System.out.println(" ");
                System.out.println(" ");
    
                
    
            }
            finally{
                locket_airplane.unlock();
            }
        }
        
    }
    }
    
}
