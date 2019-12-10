/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airport;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

//import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class WriteFile {

    private Lock locket = new ReentrantLock();


    public WriteFile() {}
    public void Writer(String text) throws FileNotFoundException {
        //timeStamp ts = se coge el timestamp
        try {
            locket.lock(); //Un segundo espera

            PrintStream writeToFile = new PrintStream(new FileOutputStream("AirportProgress.log", true)); 
            
            writeToFile.println(text + "\n");
            //writeToFile.append(ts + " - " + axtext + "\n");

        }catch(Exception e){}
        finally{
            locket.unlock();
        }
        
    }

    public void DeleteFile(){
        File archivo = new File("AirportProgress.log");

        if(archivo.exists()){
            archivo.delete();
        }
        
    }

}