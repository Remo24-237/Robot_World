import edu.duke.*;
import java.util.*;
/**
 *<h1>This class contains the commands used to control the kiva Robot's motion.</h1>
 * @author (Omer Olloumou) 
 * @version (10/10/2021)
 */


public enum KivaCommand {
    /**Command to move kiva forward.*/
    FORWARD('F') , 
    /**Command to turn a kiva to the left.*/
    TURN_LEFT('L'), 
    /**Command to turn a kiva to the rigth.*/
    TURN_RIGHT('R'), 
    /**Command to pick up a pod.*/
    TAKE('T'), 
    /**Command to drop a pod.*/
    DROP('D'); 
    
    private char move;
    
    /**
     * @param move 
     */
    private KivaCommand (char move){
        this.move = move;
       
    } 
    
    /**
     * Helper method to return the direction key
     * @return Returns the direction key
     */
    public String getDirectionKey(){
        return String.format("%c", move);
    }
 }
