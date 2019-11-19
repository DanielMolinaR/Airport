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

    private Lock locket_conveyor = new ReentrantLock();        
    private Condition full = locket_conveyor.newCondition(); 
    private Condition empty = locket_conveyor.newCondition();   
    
    public void LeaveSuitcase(Suitcase suitcases, ArrayList conveyor){
        try {
            locket_passenger.lock();
            while (this.conveyor.lenght()==8){
                try {
                    full.await();
                } catch(InterruptedException ie){ }
            }
            this.conveyor.add(suitcase);
            empty.signal();
        }
        finally{
            locket_conveyor.unlock();
        }
    } 
    
    public void TakeSuitcase (ArrayList conveyor){
        try{
            locket_conveyor.lock();
            while (this.conveyor.lenght()==0){
                try {
                empty.await();
                } catch(InterruptedException ie){ }
            }
            this.conveyor.remove[0];
            full.signal();
        }
        finally{
            locket_conveyor.unlock();
        }
    }
}
