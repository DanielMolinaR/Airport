/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airport;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

//import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class Passenger extends Thread {

    private final String id_passenger;
    private Conveyor conveyor;
    private Suitcase suitcase_A;
    private Suitcase suitcase_B;
    private Button button;

    public Passenger(String id_passenger, Suitcase suitcase_A, Suitcase suitcase_B, Conveyor conveyor, Button button) {
        this.id_passenger = id_passenger;
        this.suitcase_A = suitcase_A;
        this.suitcase_B = suitcase_B;
        this.conveyor = conveyor;
        this.button = button;
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

    public void run() {
        try {
            sleep(500 + (int) (1000 * Math.random())); // wait between 0.5 y 1 sec
        } catch (InterruptedException e) {
        }
       
        button.CheckStopAll();

        try {
            this.conveyor.LeaveSuitcaseConveyor(suitcase_A);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Passenger.class.getName()).log(Level.SEVERE, null, ex);
        }


        try{
            sleep(500 + (int)(1000*Math.random()));  //wait between 0.5 y 1 sec
        } catch (InterruptedException e){}

        button.CheckStopAll();

        try {
            this.conveyor.LeaveSuitcaseConveyor(suitcase_B);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
}
