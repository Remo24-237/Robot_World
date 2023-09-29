

import edu.duke.*;
import java.util.*;
/**
 * <h1>Class used to test the kiva Command Enumaration.</h1>
 * @author (Omer Olloumou) 
 * @version (10/10/2021)
 */
public class KivaCommandTester {
     //method testing the FORWARD kiva command
     public void testForward(){
         KivaCommand command = KivaCommand.FORWARD;
         System.out.println(command);
         System.out.println(command.getDirectionKey());
        }
     //method testing the TURN_LEFT kiva command
     public void testTurnLeft(){
        KivaCommand command = KivaCommand.TURN_LEFT;
         System.out.println(command);
         System.out.println(command.getDirectionKey());
        }
     //method testing the TURN_RIGHT kiva command
     public void testTurnRight(){    
         KivaCommand command = KivaCommand.TURN_RIGHT;
         System.out.println(command);
         System.out.println(command.getDirectionKey()); 
        }
     //method testing the TAKE kiva command
     public void testTake(){    
         KivaCommand command = KivaCommand.TAKE;
         System.out.println(command);
         System.out.println(command.getDirectionKey()); 
        }
     //method testing the DROP kiva command
     public void testDrop(){    
         KivaCommand command = KivaCommand.DROP;
         System.out.println(command);
         System.out.println(command.getDirectionKey()); 
        }
}
