/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airport;

import java.io.FileNotFoundException;
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
    private WriteFile writefile;
    private String text;

    public Airplane() {
        this.writefile = new WriteFile();
    }

    public void LeaveSuitcaseAirplane(Suitcase suitcase) throws FileNotFoundException {
        try {
            locket_airplane.lock();
            this.hold.add(suitcase);

            int i = 1;

            System.out.println("El AVIÓN tiene: ");
            text = "El AVIÓN tiene: ";
            for (Suitcase suitcases : hold){
                System.out.print(i + (".-") + suitcases.getSuitcase() + " // ");
                text += i + (".-") + suitcases.getSuitcase() + " // ";
                i++;
            }
            System.out.println(" ");
            System.out.println(" ");

            this.writefile.Writer(text);

        }
        finally{
            locket_airplane.unlock();
        }
    }
    
}
