

import edu.duke.FileResource;
import java.util.*;
/**
 * <h1>This is the class that controls Kiva's actions.</h1> 
 * method to deliver the pod and avoid the obstacles.
 */
public class RemoteControl {
    KeyboardResource keyboardResource;
    FacingDirection directionFacing;
    /**
     * Build a new RemoteControl.
     */
    public RemoteControl() {
        keyboardResource = new KeyboardResource();
    }

    /**
     * The controller that directs Kiva's activity. Prompts the user for the floor map
     * to load, displays the map, and asks the user for the commands for Kiva to execute.
     *
     * 
     */
    public void run() {
        System.out.println("Please select a map file.");
        FileResource fileResource = new FileResource();
        String inputMap = fileResource.asString();
        FloorMap floorMap = new FloorMap(inputMap);
        Kiva kiva = new Kiva(floorMap);
        System.out.println(floorMap);
        System.out.println(String.format("Current Kiva Robot location: %s", floorMap.getInitialKivaLocation()));
        System.out.println(String.format("Facing: %s", kiva.getDirectionFacing()));
        System.out.println("Please enter the directions for the Kiva Robot to take.");
        String directions = keyboardResource.getLine();
        KivaCommand[] commands =convertToKivaCommands(directions);
        System.out.println("Directions that you typed in: " + directions.toUpperCase());
        for(int i=0;i<directions.length();i++){
         kiva.move(commands[i]);
        }
        
        if(kiva.isCarryingPod()==false  && kiva.isSuccessfullyDropped()==true && floorMap.getObjectAtLocation(kiva.getCurrentLocation())==FloorMapObject.DROP_ZONE && commands[directions.length()-1]==KivaCommand.DROP){
            System.out.println("Successfully picked up and dropped it off, thank you");
         }else if((commands[directions.length()-1]!=KivaCommand.DROP || floorMap.getObjectAtLocation(kiva.getCurrentLocation())!=FloorMapObject.DROP_ZONE )  && (kiva.isCarryingPod()==false  || kiva.isSuccessfullyDropped()==false)){
            System.out.println("I'm sorry. The kiva Robot did not pick up the pod then drop it off in the right place");
         }
    }
    /**
     * Method used to convert User input string in to an Array of Kiva Commands
     * @param string Method takes a string as input
     * @return Method return array of type KivaCommmand 
     */
    public static KivaCommand[] convertToKivaCommands(String string){
        String UserDirections = string.toUpperCase();//from user
        char[] command = UserDirections.toCharArray();//creating a character array from the string inputted by user
        KivaCommand[] returnArray = new KivaCommand[command.length]; //creating an empty array of type KivaCommand with size equal to length of string
        for(int j=0; j<command.length;j++){
            if(
            command[j]=='F'){
            returnArray[j]=KivaCommand.FORWARD; 
              }else {
            throw new IllegalArgumentException(String.format("Character %s does not correspond to a command",command[j]));
            }
        
       }
       return returnArray;
     }
}
