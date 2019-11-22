package airport;

/**
 *
 * @author Daniel
 */
public class Employee extends Thread{
    
     private Conveyor conveyor;  
     private String id_employee; 
     private Suitcase suitcase;
     private Airplane airplane;
     
     public Employee(String id_employee, Suitcase suitcase) { 
          this.id_employee = id_employee;
          this.suitcase = suitcase;
      }

     public String getId_employee() {
          return id_employee;
     }

     public void setId_employee(String id_employee) {
          this.id_employee = id_employee;
     }
  
     public void EmployeeGoConveyor(){
          while (conveyor.getConveyor().size()>0){ 
               this.setSuitcase(conveyor.TakeSuitcase());
               try{
                   sleep(400 + (int)(7000*Math.random()));  //wait between 0.4 y 0.7 sec
               } catch (InterruptedException e){}
               airplane.LeaveSuitcaseAirplane(this.suitcase);
               this.setSuitcase(null);
           }
       }

     public Suitcase getSuitcase() {
          return suitcase;
     }

     public void setSuitcase(Suitcase suitcase) {
          this.suitcase = suitcase;
     }
}
