/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carparkmanager;

import java.util.Scanner;

/**
 *
 * @author Rakhe
 */
public class CarParkManager {

    /**
     * @param args the command line arguments
     */
    
    static int ticketNumber = 5000;
    static String[][] parkSpace = new String[10][2];
    static String[] carsParked = new String[10];
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter input:");
        String userInput = scan.nextLine();
        String[] inputs = userInput.split(",");
        
        for(int i=0; i<inputs.length; i++ ){
            char c = Character.toLowerCase(inputs[i].charAt(0));
            if(c == 'p'){
                Park(inputs[i]);
            }
            else if(c == 'u'){
                Unpark(inputs[i]);
            }
            else if(c == 'c'){
                carsParked = Compact();
            }
            else{
                System.out.println("Inputed wrong command.");
                break;
            }
            
        }
        
        for(int i = 0; i<carsParked.length;i++){             
            if(carsParked[i]==null){
                 carsParked[i]=",";
            }
            System.out.print(carsParked[i] + " ");
        }
        
        
    }
    
    public static void Park(String str){
        String string = str.substring(1);
        for(int i = 0; i<parkSpace.length;i++){
            if(parkSpace[i][0]== null ){
                parkSpace[i][0] = Integer.toString(ticketNumber);
                parkSpace[i][1] = string;
                carsParked[i] = string;
                break;
            }
        }
        ticketNumber++;
        
    }
    
    public static void Unpark(String str){
        String string = str.substring(1);
        for(int i = 0; i<parkSpace.length;i++){
            if(parkSpace[i][0].equals(string) ){
                parkSpace[i][0] = null;
                parkSpace[i][1] = null;
                carsParked[i] = null;
                break;
            }
        }
        
    }
    
    public static String[] Compact(){
        String[] carParkCompacted = new String[10];
        int j = 0;
        for(int i = 0; i<carsParked.length;i++){
            if(carsParked[i]!=null ){   
                carParkCompacted[j]=carsParked[i];
                j++; 
                
            }
            
        }
               
        return carParkCompacted;
    }
    
}
