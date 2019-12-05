/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airport;

//import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class Passenger extends Thread{
    
    private final String id_passenger; 
    private Conveyor conveyor; 
    private Suitcase suitcase_A; 
    private Suitcase suitcase_B; 
    private Logger logger;

    public Passenger(String id_passenger, Suitcase suitcase_A, Suitcase suitcase_B, Conveyor conveyor) { 
        this.id_passenger = id_passenger; 
        this.suitcase_A = suitcase_A; 
        this.suitcase_B = suitcase_B; 
        this.conveyor = conveyor;
    }

    public String getId_passenger() {
        return id_passenger;
    }


    public Conveyor getConveyor() {
        return conveyor;
    }

    public Suitcase getSuitcase_A() {
        return suitcase_A;
    }

    public Suitcase getSuitcase_B() {
        return suitcase_B;
    }



    public synchronized void run(){
        try{
            sleep(500 + (int)(1000*Math.random()));  //wait between 0.5 y 1 sec
        } catch (InterruptedException e){}
        this.conveyor.LeaveSuitcaseConveyor(suitcase_A);
        try{
            sleep(500 + (int)(1000*Math.random()));  //wait between 0.5 y 1 sec
        } catch (InterruptedException e){}
        this.conveyor.LeaveSuitcaseConveyor(suitcase_B);
    }
    
}
