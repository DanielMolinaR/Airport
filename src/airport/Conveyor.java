/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airport;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.swing.JTextField;

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
    private JTextField leave_suitcase; 
    String text;

    public Conveyor() {
        this.conveyor = new ArrayList<>();
        this.writefile = new WriteFile();
        this.text = new String();
        
    }

    public void showConveyor(){
        int i=1;
        
        System.out.println("La CINTA tiene: ");
            text = "La CINTA tiene: ";
            for (Suitcase suitcases : conveyor){
                System.out.print(i + (".-") + suitcases.getSuitcase() + " // ");
                text += i + (".-") + suitcases.getSuitcase() + " // ";
                i++;
            }
            System.out.println(" ");
            System.out.println(" ");
    }

    public void LeaveSuitcaseConveyor(Suitcase suitcase) throws FileNotFoundException {

    try {
            locket_conveyor.lock();
            try {
                if (this.isConveyorFull())
                    full.await();
            } catch(InterruptedException ie){ }
            conveyor.add(suitcase);

            int i = 1;

            System.out.println("La CINTA tiene: ");
            text = "La CINTA tiene: ";
            for (Suitcase suitcases : conveyor){
                System.out.print(i + (".-") + suitcases.getSuitcase() + " // ");
                text += i + (".-") + suitcases.getSuitcase() + " // ";
                i++;
            }
            System.out.println(" ");
            System.out.println(" ");
            
            empty.signal();
        }
        finally{
            writefile.Writer(text);
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
