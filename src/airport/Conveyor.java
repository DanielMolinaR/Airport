/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airport;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Daniel
 */
public class Conveyor {

    private ArrayList<Suitcase> conveyor;
    private Lock locket_conveyor = new ReentrantLock();
    private Condition full = locket_conveyor.newCondition();
    private Condition empty = locket_conveyor.newCondition();
    private WriteFile writefile;
    private String text, textE;
    private Server airport_interface;

    public Conveyor(Server airport_interface) throws IOException {
        this.airport_interface = airport_interface;
        this.conveyor = new ArrayList<>();
        this.writefile = new WriteFile();
        this.text = new String();
        this.textE = new String();
    }
    
    
     public Conveyor() {
        this.conveyor = new ArrayList<>();
        this.writefile = new WriteFile();
        this.text = new String();
        this.textE = new String();
    }



    public void LeaveSuitcaseConveyor(Suitcase suitcase) throws FileNotFoundException {

    try {
            locket_conveyor.lock();
            try {
                if (this.isConveyorFull())
                    full.await();
            } catch(InterruptedException ie){ }
            conveyor.add(suitcase);

            text = Print();

            empty.signal();
        }
        finally{
            writefile.Writer(text);
            airport_interface.ShowConveyor(this.text);
            locket_conveyor.unlock();
        }
    } 
    
    public Suitcase TakeSuitcase(String id) {

        Suitcase suitcase;

        try{
            locket_conveyor.lock();
            try {
                if (this.isConveyorEmpty())
                    empty.await();
            } catch(InterruptedException ie){ }
            suitcase = conveyor.remove(0);
            
            textE = "El " + id + " lleva " + suitcase.getSuitcase();
            
            return suitcase;
        }
        finally{
            try {
                if (id.equalsIgnoreCase("Empleado_1")){
                    airport_interface.ShowGoingE1(this.textE);
                }else airport_interface.ShowGoingE2(this.textE);
                
                try {
                    this.writefile.Writer(textE);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Conveyor.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                text = Print();
                
                airport_interface.ShowConveyor(text);
                
                writefile.Writer(text);
                
                full.signal();
                locket_conveyor.unlock();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Conveyor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public String Print(){
        
        int i = 1;
                
        text = "La CINTA tiene: ";
        for (Suitcase suitcases : conveyor){
            text += i + (".-") + suitcases.getSuitcase() + " // ";
            i++;
        }
    
        
        return text;
    }
        
    private boolean isConveyorFull(){
        return this.conveyor.size() == 8;
    }

    private boolean isConveyorEmpty(){
        return this.conveyor.isEmpty();
    }

}
