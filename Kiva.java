



import edu.duke.*;
import java.util.*;
/**
 * <h1>This is the class used to evaluate each command recieved by the Robot.</h1>
 * Ensures the Kiva Robot moves on the given floor map and throws Exceptions when necessary.
 * @author (Omer Olloumou) 
 * @version (10/10/2021)
 */
public class Kiva {
    private volatile FacingDirection directionFacing;
    private FloorMap map;
    private Point currentLocation ;
    private Boolean carryingPod;
    private Boolean successfullyDropped;
    private long motorLifetime ;
    
    /**
     * First Kiva constructor taking the Floor Map as a parameter.
     * @param map The Floor Map Kiva will be moving on.
     */
     public Kiva (FloorMap map){
        this.map = map;
        this.directionFacing=FacingDirection.UP;
        this.currentLocation= map.getInitialKivaLocation(); 
        carryingPod = false;
        successfullyDropped = false;
        this.motorLifetime =  0L;
        
     }
    
    /**
     * Second Kiva constructor taking the Floor Map, and Kiva's current location as parameters.
     * @param map The Floor Map Kiva will be moving on.
     * @param currentLocation The Kiva Robot's curren location.
     */
    public Kiva (FloorMap map, Point currentLocation){
        this(map);
        this.currentLocation=currentLocation ;
        
    }
    
    /**
     * Used to verify Kiva Robot's drop status
     * @return Returns a Boolean value if the Kiva Robot dropped a Pod.
     */
    public Boolean isSuccessfullyDropped(){
        if(!successfullyDropped){
            return false;
        }else {return true;}
    }
    
    /**
     * Used to verify Kiva Robot's Carry status
     * @return Returns a Boolean value if the Kiva Robot is carrying a Pod.
     */
    public Boolean isCarryingPod(){
        if(!carryingPod){
            return false;
        }else {return true;}
    }
    
    /**
     * Returns the Kiva Robots current location as  point (x,y).
     * @return Returns the Kiva Robots current location.
     */
    public Point getCurrentLocation(){
        return currentLocation;
    }
    
    /**
     * Returns the Kiva Robot's facing direction as an Enum value
     * @return The direction in which the Robot is facing.
     */
    public FacingDirection getDirectionFacing(){
        return directionFacing;
    }
    
    /**
     * Returns the Kiva Robot's motor life.
     * @return The motor life value of the Kiva Robot.
     */
    public long getMotorLifetime(){
        return motorLifetime;
    }
    
    /**
     * Returns an increment of the kiva Robot motor life.
     * @return Retruns an increment of 1000 of the motor life.
     */
    public long incrementMotorLifetime(){
        return motorLifetime+=1000L;
    }
    
    //moving in the map given kive robot facing UP
    /**
     * method used to update the current location after moving a step forward on the map
     * move forward helper methods
     */
    public void moveForward(){
         
        int x = currentLocation.getX();
        int y = currentLocation.getY()-1;
        Point nextPoint= new Point(x,y);
        if((y>map.getMaxRowNum()) || (x>map.getMaxColNum()) || x<0 || y<0)//checking for out of bound
        {throw new IllegalMoveException(String.format("the location %s is Outside the boundary of the Kiva floor !",nextPoint)); 
        }else if (map.getObjectAtLocation(nextPoint)==FloorMapObject.OBSTACLE)//checking for obstacles
                {throw new IllegalMoveException(String.format("Obstacle found at location %s!",nextPoint));}
         else if(map.getObjectAtLocation(nextPoint)==FloorMapObject.POD && carryingPod==true)//checking for collision
                {throw new IllegalMoveException(String.format("Warning:: Colision,Pod found at location %s!",nextPoint));}
         else{this.currentLocation = new Point(x, y);}
     }
     
    /**
     * method used to update the current location after moving a step to the left on the map.
     */
    public void moveTurnLeft(){
        int x = currentLocation.getX()-1;
        int y = currentLocation.getY();
        Point nextPoint= new Point(x,y);
        if((y>map.getMaxRowNum()) || (x>map.getMaxColNum()) || x<0 || y<0)//checking for out of bound
            {throw new IllegalMoveException(String.format("the location %s is Outside the boundary of the Kiva floor ",nextPoint)); }
        if (map.getObjectAtLocation(nextPoint)==FloorMapObject.OBSTACLE)//checking for obstacles
            {throw new IllegalMoveException(String.format("Obstacle found at location %s",nextPoint));}
        if(map.getObjectAtLocation(nextPoint)==FloorMapObject.POD && carryingPod==true)//checking for collision
             {throw new IllegalMoveException(String.format("Warning:: Colision,Pod found at location %s",nextPoint));}
         else{this.currentLocation = new Point(x, y);}
    }
    
    /**
     * method used to update the current location after moving a step to the right on the map.
     */
    public void moveTurnRight(){
        int x = currentLocation.getX()+1;
        int y = currentLocation.getY();
        Point nextPoint= new Point(x,y);
        //method used to update the current location after moving a step to the right on the map
        if((y>map.getMaxRowNum()) || (x>map.getMaxColNum()) || x<0 || y<0)//checking for out of bound
            {throw new IllegalMoveException(String.format("the location %s is Outside the boundary of the Kiva floor ",nextPoint)); } 
        if (map.getObjectAtLocation(nextPoint)==FloorMapObject.OBSTACLE)//checking for obstacles
            {throw new IllegalMoveException(String.format("Obstacle found at location %s",nextPoint));}
        if(map.getObjectAtLocation(nextPoint)==FloorMapObject.POD && carryingPod==true)//checking for collision
             {throw new IllegalMoveException(String.format("Warning:: Colision,Pod found at location %s",nextPoint));}
        else {this.currentLocation = new Point(x, y);}
    }
    
    /**
     * method used to update the current location after moving a step to the down on the map
     */
    public void moveDown(){
        int x = currentLocation.getX();
        int y = currentLocation.getY()+1;
        Point nextPoint= new Point(x,y);
        //method used to update the current location after moving a step to the down on the map
        if((y>map.getMaxRowNum()) || (x>map.getMaxColNum()) || x<0 || y<0)//checking for out of bound
            {throw new IllegalMoveException(String.format("the location %s is Out of bound ",nextPoint)); } 
        if (map.getObjectAtLocation(nextPoint)==FloorMapObject.OBSTACLE)//checking for obstacles
            {throw new IllegalMoveException(String.format("Obstacle found at location %s",nextPoint));}
        if(map.getObjectAtLocation(nextPoint)==FloorMapObject.POD && carryingPod==true)//checking for collision
             {throw new IllegalMoveException(String.format("Warning:: Colision,Pod found at location %s",nextPoint));}
         else{this.currentLocation = new Point(x, y);}
    }
    
    /**
     * TAKE helper method
     */
    public void moveTake(){
        int x = currentLocation.getX();
        int y = currentLocation.getY();
        Point nextPoint= new Point(x,y);
        if(map.getObjectAtLocation(nextPoint)!=FloorMapObject.POD || carryingPod == true)
        { throw new NoPodException(String.format("Can't TAKE: location %s is %s, not POD ",nextPoint,map.getObjectAtLocation(nextPoint)));}
        else {carryingPod = true;}
    }
    
    /**
     * Drop helper method
     */
    public void moveDrop(){
        int x = currentLocation.getX();
        int y = currentLocation.getY();
        Point nextPoint= new Point(x,y);
        if(map.getObjectAtLocation(nextPoint)!=FloorMapObject.DROP_ZONE)
        {throw new IllegalDropZoneException(String.format("Can't DROP: location %s is %s, not DROP_ZONE ",nextPoint,map.getObjectAtLocation(nextPoint)));}
        else if(map.getObjectAtLocation(nextPoint)==FloorMapObject.DROP_ZONE && carryingPod == false)
        {throw new IllegalMoveException(String.format("Can't DROP: location %s is DROP_ZONE but kiva is not carrying a POD",nextPoint));}
        else {carryingPod = false;
                successfullyDropped = true;}
    }
    
    /**
     * Move method used to compute the commands passed.
     * @param command Method accepts a command as its paramter.
     */
    public void move(KivaCommand command){
            if(command ==KivaCommand.FORWARD){incrementMotorLifetime();
                if(directionFacing==directionFacing.UP){moveForward();}
                if(directionFacing==directionFacing.LEFT){moveTurnLeft(); }
                if(directionFacing==directionFacing.RIGHT){moveTurnRight(); }
                if(directionFacing==directionFacing.DOWN){moveDown();}
           }else if(command ==KivaCommand.TURN_LEFT){incrementMotorLifetime();
                if(directionFacing==directionFacing.UP){directionFacing=FacingDirection.LEFT;}
                else if(directionFacing==directionFacing.LEFT){directionFacing=FacingDirection.DOWN;}
                else if(directionFacing==directionFacing.RIGHT){directionFacing=FacingDirection.UP;}
                else if(directionFacing==directionFacing.DOWN){directionFacing=FacingDirection.RIGHT;}
           }else if(command ==KivaCommand.TURN_RIGHT){incrementMotorLifetime();
                if(directionFacing==directionFacing.UP){directionFacing=FacingDirection.RIGHT;}
                else if(directionFacing==directionFacing.LEFT){directionFacing=FacingDirection.UP;}
                else if(directionFacing==directionFacing.RIGHT){directionFacing=FacingDirection.DOWN;}
                else if(directionFacing==directionFacing.DOWN){directionFacing=FacingDirection.LEFT;}
           }else if(command ==KivaCommand.TAKE){
               moveTake();getMotorLifetime();
            }else if(command == KivaCommand.DROP){
                moveDrop();getMotorLifetime();
            }
               
    }
 }
