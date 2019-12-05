/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airport;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Daniel
 */
public class Conveyor {
    
    private ArrayList<Suitcase> conveyor;
    private Lock locket_conveyor = new ReentrantLock();        
    private Condition full = locket_conveyor.newCondition(); 
    private Condition empty = locket_conveyor.newCondition();  
    private Logger logger;

    public Conveyor() {
        this.conveyor = new ArrayList<>();
        this.logger = new Logger();
    }
    
   public void LeaveSuitcaseConveyor(Suitcase suitcase){
        
    /*locket_conveyor.lock();

    while(this.isConveyorFull()){
        try{
            wait(); 
            empty.signal();
        } catch(InterruptedException e){}
    }
    conveyor.add(suitcase);
    PrintConveyor();*/

    try {
            locket_conveyor.lock();
            try {
                if (this.isConveyorFull())
                    full.await();
            } catch(InterruptedException ie){ }
            conveyor.add(suitcase);
            this.logger.PrintConveyor(this.conveyor);
            empty.signal();
        }
        finally{
            locket_conveyor.unlock();
        }
    } 
    
    public Suitcase TakeSuitcase() {

        /*Suitcase suitcase;
        locket_conveyor.lock();

        while(this.isConveyorEmpty()){
            try{
                wait(); 
                full.signal();
            } catch(InterruptedException e){}
        }
        suitcase = conveyor.remove(0);
        PrintConveyor();
        return suitcase;*/

        try{
            locket_conveyor.lock();
            try {
                if (this.isConveyorEmpty())
                    empty.await();
            } catch(InterruptedException ie){ }
            return conveyor.remove(0);
        }
        finally{
            full.signal();
            locket_conveyor.unlock();
        }
    }

    private boolean isConveyorFull(){
        return this.conveyor.size() == 8;
    }

    private boolean isConveyorEmpty(){
        return this.conveyor.isEmpty();
    }

    /*public void PrintConveyor(){
        System.out.print("La CINTA tiene: ");
        for (Suitcase suitcases : conveyor){
            System.out.print(suitcases.getSuitcase() + " // ");
        }
        System.out.println("");
        System.out.println("");
    }*/
}
