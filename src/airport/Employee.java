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
     private Datafile datafile;

     public Employee(String id_employee, Conveyor conveyor, Airplane airplane) { 
          this.id_employee = id_employee;
          this.suitcases = new ArrayList<>();
          this.conveyor = conveyor;
          this.airplane = airplane;
          this.datafile = new Datafile();
      }

     public String getId_employee() {
          return id_employee;
     }

     public void setId_employee(String id_employee) {
          this.id_employee = id_employee;
     }
     

     public synchronized void run() {
          while (true){ 
               this.suitcases.add(conveyor.TakeSuitcase());
               this.datafile.EmployeeCarrySuitcase(this, this.suitcases.get(0));
               try{
                    sleep(400 + (int)(700*Math.random()));  //wait between 0.4 y 0.7 sec
                } catch (InterruptedException e){}
               this.airplane.LeaveSuitcaseAirplane(this.suitcases.remove(0));
               this.datafile.EmployeeGettingBack(this);
               try{
                    sleep(400 + (int)(700*Math.random()));  //wait between 0.4 y 0.7 sec
                } catch (InterruptedException e){} 
               }
       }
}
