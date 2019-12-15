/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airport;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.swing.JTextField;

/**
 *
 * @author Daniel
 */
public class Airplane {

    private ArrayList<Suitcase> hold = new ArrayList<>();
    private Lock locket_airplane = new ReentrantLock();
    private WriteFile writefile;
    private String text, textE;
    private Server airplane_interface;

    public Airplane(Server airplane_interface) throws IOException {
        this.airplane_interface = airplane_interface;
        this.writefile = new WriteFile();
    }
    
    public Airplane() {
        this.writefile = new WriteFile();
    }
   
    public void LeaveSuitcaseAirplane(Suitcase suitcase, String id) throws FileNotFoundException {
        try {
            locket_airplane.lock();
            this.hold.add(suitcase);

            text = PrintA();
            
            textE = "El "+ id + " está volviendo";

        }
        finally{
            if (id.equalsIgnoreCase("Empleado_1")){
            airplane_interface.ShowGettingbackE1(this.textE);
            }else airplane_interface.ShowGettingbackE2(this.textE);
            
            text = PrintA();
            
            airplane_interface.ShowAirplane(text);
            
            this.writefile.Writer(text);
            this.writefile.Writer(textE);
            locket_airplane.unlock();
        }
    }
    
    public String PrintA(){
        int i = 1;

        text = "El AVIÓN tiene: ";
        for (Suitcase suitcases : hold){
            if (i%4==0){
                text += "\n";
            }
            text += i + (".-") + suitcases.getSuitcase() + " // ";
            i++;
        }
        
        return text;

    }
    
}
