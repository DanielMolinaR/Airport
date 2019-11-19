/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airport;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 *
 * @author Daniel
 */
public class Conveyor {
    
    ArrayList<Suitcase> conveyor = new ArrayList<Suitcase>();

    private Lock locket_passenger = new ReentrantLock();        // passengers locket
    private Condition full = locket_passenger.newCondition();   // if the conveyor is full the passengers have to wait for leaving their suitcase

    private Lock locket_employee = new ReentrantLock();         // employees locket
    private Condition empty = locket_employee.newCondition();   // if the conveyor is empty the employees have to wait

    
    public void LeaveSuitcase(Suitcase suitcases, ArrayList conveyor){
        try {
            locket_passenger.lock();
            while (this.conveyor.lenght()==8){
                try {
                    full.await();
                } catch(InterruptedException ie){ }
            }
        }
        finally{
            locket_passenger.unlock();
            empty.signal();
            //return conveyor.add(suitcase);
        }
    } 
    
    public void TakeSuitcase (ArrayList conveyor){
        try{
            locket_employee.lock();
            while (this.conveyor.lenght()==0){
                try {
                empty.await();
                } catch(InterruptedException ie){ }
            }
        }
        finally{
            locket_employee.unlock();
            full.signal();
            //return conveyor.remove[0];
        }
    }
}
