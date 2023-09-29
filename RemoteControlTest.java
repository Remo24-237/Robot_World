

import edu.duke.*;
import java.util.*;
/**
 * <h1>Class to test the convertToKivaCommand() method in the remote control</h1>
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RemoteControlTest {
    KeyboardResource keyboardResource;
    
    public void remoteTest(){
        Scanner scanner = new Scanner(System.in);
        String directions = scanner.nextLine();
        //String directions = keyboardResource.getLine();
        System.out.println("Directions that you typed in: " + directions.toUpperCase());
        KivaCommand[] Printed= new KivaCommand[directions.length()];
        System.out.println(Arrays.toString(RemoteControl.convertToKivaCommands(directions)));
    }
}
