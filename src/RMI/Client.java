/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;
import java.rmi.*;
import java.io.*;
import static java.lang.Thread.sleep;
import javax.swing.JOptionPane;

/**
 *
 * @author Antonio
 */
public class Client {
    public static void main(String args[])
    {
        String respuesta = "";
        Boolean condicion = true;
        CommonInterface RemoteObject;
       
        try
        {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("¿Que quiere consultar? C = cinta, A = avión, T = ambos :");
            String consulta = entrada.readLine();
            consulta = consulta.toUpperCase();
            
            RemoteObject = (CommonInterface) Naming.lookup("//127.0.0.1/Airport"); //Localiza el objeto distribuido
            
            
            //while (condicion){
                switch (consulta){
                    case ("C"):
                        respuesta = RemoteObject.Print();
                        condicion = false;
                        System.out.println(respuesta);
                        break;
                    case ("A") :
                        respuesta = RemoteObject.PrintA();
                        condicion = false;
                        break;
                    case ("T"):
                        respuesta = RemoteObject.Print();
                        respuesta += "\n" + RemoteObject.PrintA();
                        condicion = false;
                        break;
                    default:
                        System.out.println("Has introducido un dato incorrecto vuelve a introducirlo por favor");
                        System.out.println("¿Que quiere consultar? C = cinta, A = avión :");
                        consulta = entrada.readLine();

                //}
            }
            
            System.out.println(respuesta);
            JOptionPane.showMessageDialog(null, respuesta);
            System.out.println("SE IMPRIMEEEE¿?¿?¿?¿?");
            sleep(100); //Para que dé tiempo a leer la respuesta antes de que se cierre la ventana
        }
        catch (Exception e)
        {
            System.out.println("Excepción : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
    
