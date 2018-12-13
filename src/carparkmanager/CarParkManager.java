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
                Compact();
            }
            else{
                System.out.println("Inputed wrong command.");
                break;
            }
            
        
            
            

            //System.out.println(c);

        }
        /*****for(int j = 0; j<10;j++){
                System.out.print(parkSpace[j][0]);
                System.out.println(parkSpace[j][1]);
            }*****/
        
    }
    
    public static void Park(String str){
        String string = str.substring(1);
        for(int i = 0; i<parkSpace.length;i++){
            if(parkSpace[i][0]== null ){
                parkSpace[i][0] = Integer.toString(ticketNumber);
                parkSpace[i][1] = string;
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
                break;
            }
        }
        
    }
    
    public static void Compact(){
      
    }
    
}
