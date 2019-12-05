package airport;

import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class Employee extends Thread{
    
     private Conveyor conveyor;  
     private String id_employee; 
     private ArrayList<Suitcase> suitcases;
     private Airplane airplane;
     private Logger logger;

     public Employee(String id_employee, Conveyor conveyor, Airplane airplane) { 
          this.id_employee = id_employee;
          this.suitcases = new ArrayList<>();
          this.conveyor = conveyor;
          this.airplane = airplane;
      }

     public String getId_employee() {
          return id_employee;
     }

     public void setId_employee(String id_employee) {
          this.id_employee = id_employee;
     }
     

     public synchronized void run(){  
          while (true){ 
               this.suitcases.add(conveyor.TakeSuitcase());
               System.out.println("El "+ this.getId_employee() + " lleva " + this.suitcases.get(0).getSuitcase());
               System.out.println("");
               try{
                    sleep(400 + (int)(700*Math.random()));  //wait between 0.4 y 0.7 sec
                } catch (InterruptedException e){}
               this.airplane.LeaveSuitcaseAirplane(this.suitcases.remove(0));
               try{
                    sleep(400 + (int)(700*Math.random()));  //wait between 0.4 y 0.7 sec
                } catch (InterruptedException e){} 
               }
       }
}
