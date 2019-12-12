/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;
import java.rmi.*;
import java.io.*;
import static java.lang.Thread.sleep;
import java.net.MalformedURLException;
import javax.swing.JOptionPane;


/**
 *
 * @author Antonio
 */
public class Client {
    
    private static CommonInterface look_up;
    private static boolean condicion = true;
    
    public static void main(String args[]) throws MalformedURLException, RemoteException, NotBoundException{

        String respuesta = "";
        try
        {
            while(true){
                String consulta = JOptionPane.showInputDialog("¿Que quiere consultar? C = cinta, A = avion, B = cinta y avion :");

                look_up = (CommonInterface) Naming.lookup("//127.0.0.1/Airport");
                
                if (consulta.equalsIgnoreCase("c") ){
                    String text = look_up.Print();

                    JOptionPane.showMessageDialog(null, text);
                }
                else if (consulta.equalsIgnoreCase("a")){
                    String text_a = look_up.Print();

                    JOptionPane.showMessageDialog(null, text_a);
                } else if (consulta.equalsIgnoreCase("t")){
                    String text = look_up.Print() + "\n" + look_up.PrintA();
                    JOptionPane.showMessageDialog(null, text);
                } else JOptionPane.showMessageDialog(null, "Has introducido un dato incorrecto", "", JOptionPane.ERROR_MESSAGE);

                sleep(1);
                
            }
         } //Para que dé tiempo a leer la respuesta antes de que se cierre la ventana
        
        catch (Exception e)
        {
            System.out.println("Excepción : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
    

