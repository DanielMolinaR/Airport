package airport;


import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.swing.JTextField;

/**
 *
 * @author Daniel
 */
public class Employee extends Thread {

     private Conveyor conveyor;
     private String id_employee;
     private ArrayList<Suitcase> suitcases;
     private Airplane airplane;
     private WriteFile writefile;
     private String text;
     private JTextField employee_working;
     private JTextField employee_coming;

     public Employee(String id_employee, Conveyor conveyor, Airplane airplane) {
          this.id_employee = id_employee;
          this.suitcases = new ArrayList<>();
          this.conveyor = conveyor;
          this.airplane = airplane;
          this.writefile = new WriteFile();
          this.employee_working = employee_working ;
          this.employee_coming = employee_coming;
     }

     public String getId_employee() {
          return id_employee;
     }

     public void setId_employee(String id_employee) {
          this.id_employee = id_employee;
     }

     public void run() {
          while (true) {
               this.suitcases.add(conveyor.TakeSuitcase());

               System.out.println("El " + this.getId_employee() + " lleva " + suitcases.get(0).getSuitcase());
               System.out.println("");
               text = "El " + this.getId_employee() + " lleva " + suitcases.get(0).getSuitcase();
              
               try {
                    writefile.Writer(text);
               } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
               }

               try{
                    sleep(400 + (int)(700*Math.random()));  //wait between 0.4 y 0.7 sec
               } catch (InterruptedException e){}
                
               try {
                    this.airplane.LeaveSuitcaseAirplane(this.suitcases.remove(0));
               } catch (FileNotFoundException e2) {
                    e2.printStackTrace();
               }

               System.out.println("El "+ this.getId_employee() + " está volviendo");
               System.out.println("");
               text = "El "+ this.getId_employee() + " está volviendo";
               
               try {
                    writefile.Writer(text);
               } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
               }

               try{
                    sleep(400 + (int)(700*Math.random()));  //wait between 0.4 y 0.7 sec
                } catch (InterruptedException e){} 
               }
       }
}
