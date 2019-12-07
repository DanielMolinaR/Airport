/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airport;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 *
 * @author Daniel
 */
public class Airplane {
    
    private ArrayList<Suitcase> hold = new ArrayList<>();
    private Lock locket_airplane = new ReentrantLock();  
    private Datafile datafile;
    
    public Airplane() {
        this.datafile = new Datafile();
    }
    public void LeaveSuitcaseAirplane(Suitcase suitcase){
        try {
            locket_airplane.lock();
            this.hold.add(suitcase);
            this.datafile.AirplaneHold(hold);
        }
        finally{
            locket_airplane.unlock();
        }
    }
    
}
