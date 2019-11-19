/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airport;

/**
 *
 * @author Daniel
 */
public class Passenger extends Thread{
    
    private String id_passenger; 
    private Conveyor conveyor; 
    private Suitcase suitcase_A; 
    private Suitcase suitcase_B; 
 
    public Passenger(String id_passenger, Suitcase suitcase_A, Suitcase suitcase_B) { 
        this.id_passenger = id_passenger; 
        this.suitcase_A = suitcase_A; 
        this.suitcase_B = suitcase_B; 
    }
    
    public void GoingToTheConveyor(){
        
    }
    
    
}
