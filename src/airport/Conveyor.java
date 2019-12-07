/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airport;

import java.io.IOException;
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
    private Datafile datafile;

    public Conveyor() {
        this.conveyor = new ArrayList<>();
        this.datafile = new Datafile();
    }

    public void LeaveSuitcaseConveyor(Suitcase suitcase) {

    try {
            locket_conveyor.lock();
            try {
                if (this.isConveyorFull())
                    full.await();
            } catch(InterruptedException ie){ }
            conveyor.add(suitcase);
            this.datafile.Conveyor(this.conveyor);
            empty.signal();
        }
        finally{
            locket_conveyor.unlock();
        }
    } 
    
    public Suitcase TakeSuitcase() {

        Suitcase suitcase;

        try{
            locket_conveyor.lock();
            try {
                if (this.isConveyorEmpty())
                    empty.await();
            } catch(InterruptedException ie){ }
            suitcase = conveyor.remove(0);
            return suitcase;
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

}
