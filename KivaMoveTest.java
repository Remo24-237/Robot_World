


import edu.duke.Point;
/**
 * <h1>Class to test the move() method.</h1>
 * @author (Omer Olloumou) 
 * @version (10/10/2021)
 */
public class KivaMoveTest {
    // Define the FloorMap we'll use for all the tests
    String defaultLayout = ""
                           + "-------------\n"
                           + "        P   *\n"
                           + "   **       *\n"
                           + "   **       *\n"
                           + "  K       D *\n"
                           + " * * * * * **\n"
                           + "-------------\n";

    FloorMap defaultMap = new FloorMap(defaultLayout);
    FacingDirection directionFacing;

    public void testForwardFromUp() {
        // GIVEN
        // A Kiva built with the default map we defined earlier
        Kiva kiva = new Kiva(defaultMap);
        // WHEN
        // We move one space forward
        kiva.move(KivaCommand.FORWARD);
        // THEN
        // The Kiva has moved one space up
        verifyKivaState("testForwardFromUp", 
            kiva, new Point(2, 3), FacingDirection.UP, false, false);
    }
    
    // For you: create all the other tests and call verifyKivaState() for each
    //tester methods for the command TURN_LEFT with all possible directions(UP,DOWN,LEFT,RIGHT) 
    public void testTurnLeftFromUp(){
        Kiva kiva = new Kiva(defaultMap); // kiva built from defined map
        kiva.move(KivaCommand.TURN_LEFT);// moving kiva robor and updating curren location
        //verifying the new state of the kiva robot
        verifyKivaState("testTurnLeftFromUp",kiva, new Point(2,4),FacingDirection.LEFT, false, false);
    }
    public void testTurnLeftFromLeft(){
        Kiva kiva = new Kiva(defaultMap); // kiva built from defined map
        kiva.move(KivaCommand.TURN_LEFT);// moving kiva robor and updating curren location
        kiva.move(KivaCommand.TURN_LEFT);
        //verifying the new state of the kiva robot
        verifyKivaState("testTurnLeftFromLeft",kiva, new Point(2,4),FacingDirection.DOWN, false, false);
    }
    public void testTurnLeftFromRight(){
        Kiva kiva = new Kiva(defaultMap); // kiva built from defined map
        kiva.move(KivaCommand.TURN_LEFT);// moving kiva robor and updating curren location
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.TURN_LEFT);
        //verifying the new state of the kiva robot
        verifyKivaState("testTurnLeftFromRight",kiva, new Point(2,4),FacingDirection.UP, false, false);
    }
    public void testTurnLeftFromDown(){
        Kiva kiva = new Kiva(defaultMap); // kiva built from defined map
        kiva.move(KivaCommand.TURN_LEFT);// moving kiva robor and updating curren location
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.TURN_LEFT);
        //verifying the new state of the kiva robot
        verifyKivaState("testTurnLeftFromDown",kiva, new Point(2,4),FacingDirection.RIGHT, false, false);
    }
    
    //tester methods for moving FORWARD command with all possible directions(UP,DOWN,LEFT,RIGHT)
    public void testForwardWhileFacingLeft(){
        Kiva kiva = new Kiva(defaultMap);
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.FORWARD);
        verifyKivaState("testForwardWhileFacingLeft", 
            kiva, new Point(1, 4), FacingDirection.LEFT, false, false);
    }
    public void testForwardWhileFacingDown(){
        Kiva kiva = new Kiva(defaultMap);
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.FORWARD);
        verifyKivaState("testForwardWhileFacingDown", 
            kiva, new Point(2, 5), FacingDirection.DOWN, false, false);
    }
    public void testForwardWhileFacingRight(){
        Kiva kiva = new Kiva(defaultMap);
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.FORWARD);
        verifyKivaState("testForwardWhileFacingRight", 
            kiva, new Point(3, 4), FacingDirection.RIGHT, false, false);
    }
    
    //tester methods for the command TURN_RIGHT with all possible directions(UP,DOWN,LEFT,RIGHT)
    public void testTurnRightFromUp(){
        Kiva kiva = new Kiva(defaultMap);
        kiva.move(KivaCommand.TURN_RIGHT);
        verifyKivaState("testTurnRightFromUp", 
            kiva, new Point(2, 4), FacingDirection.RIGHT, false, false);
    }
    public void testTurnRightFromLeft(){
        Kiva kiva = new Kiva(defaultMap);
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.TURN_RIGHT);
        verifyKivaState("testTurnRightFromLeft", 
            kiva, new Point(2, 4), FacingDirection.UP, false, false);
    }
    public void testTurnRightFromDown(){
        Kiva kiva = new Kiva(defaultMap);
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.TURN_RIGHT);
        verifyKivaState("testTurnRightFromDown", 
            kiva, new Point(2, 4), FacingDirection.LEFT, false, false);
    }
    public void testTurnRightFromRight(){
        Kiva kiva = new Kiva(defaultMap);
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.TURN_RIGHT);
        verifyKivaState("testTurnRightFromRight", 
            kiva, new Point(2, 4), FacingDirection.DOWN, false, false);
    }
    public void testTakeOnPod(){
        Kiva kiva = new Kiva(defaultMap);
        kiva.move(KivaCommand.FORWARD);//MOVING UP THREE TIMES
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.TURN_RIGHT);//turning right
        kiva.move(KivaCommand.FORWARD);//moving right six times
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.TAKE);
        verifyKivaState("testTakeOnPod", 
            kiva, new Point(8,1), FacingDirection.RIGHT, true, false);
    }
    public void testDropOnDropZone(){
        Kiva kiva = new Kiva(defaultMap);
        kiva.move(KivaCommand.FORWARD);//MOVING UP THREE TIMES
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.TURN_RIGHT);//turning right
        kiva.move(KivaCommand.FORWARD);//moving right six times
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);//arrived at pod
        kiva.move(KivaCommand.TAKE);//picking up pod
        //moving to drop zone
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.TURN_RIGHT);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);//arrived at drop zone
        kiva.move(KivaCommand.DROP);//dropping pod
        verifyKivaState("testDropOnDropZone", 
            kiva, new Point(10,4), FacingDirection.DOWN, false, true);
    }
    
    //tester method for handling invalid moves
    public void testMoveOutOfBounds(){
        Kiva kiva = new Kiva(defaultMap);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        System.out.println("testMoveOutOfBounds: (expected an IllegalMoveException)");
        kiva.move(KivaCommand.FORWARD);
        //this only runs if no exception was thrown
        System.out.println("testMoveOutOfBounds FAIL!");
        System.out.println("Moved outside the FloorMap");
        
    }
    
    //tester method for encountering an obstacle on the floor
    public void testObstacleOnFloor(){
        Kiva kiva = new Kiva(defaultMap);//initializing a kiva robot using the default map provided
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.TURN_RIGHT);
        System.out.println("testObstacleOnFloor: (expected an IllegalMoveException)");
        kiva.move(KivaCommand.FORWARD);//robot encounters an obstcle
        //this only runs if no exception was thrown
        System.out.println("testObstacleOnFloor FAIL!");
        //System.out.println("Did not encouter an obstacle on the FloorMap");
    }
    
    //tester method for collision between a pod carrying kiva robot and a pod
    public void testCollisionOnFloor(){
        Kiva kiva = new Kiva(defaultMap);//initializing a kiva robot using the default map provided
        kiva.move(KivaCommand.TAKE);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.TURN_RIGHT);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        System.out.println("testCollisionOnFloor: (expected an IllegalMoveException)");
        kiva.move(KivaCommand.FORWARD);//robot encounters a pod
        System.out.println("testCollisionOnFloor FAIL!");
    }
    //tester method for picking up a pod
    public void testMoveTake(){
        Kiva kiva = new Kiva(defaultMap);
        kiva.move(KivaCommand.FORWARD);
        System.out.println("testMoveTake: (expected an NoPodException)");
        kiva.move(KivaCommand.TAKE);
        System.out.println("testMoveTake FAIL!");
    }
    //tester method for dropping a pod
    public void testMoveDrop(){ //dropping a pod in a location not DROP_ZONE
        Kiva kiva = new Kiva(defaultMap);
        kiva.move(KivaCommand.FORWARD);//MOVING UP THREE TIMES
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.TURN_RIGHT);//turning right
        kiva.move(KivaCommand.FORWARD);//moving right six times
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);//arrived at pod
        kiva.move(KivaCommand.TAKE);//picking up pod
        //robot moving to empty space to drop pod
        kiva.move(KivaCommand.FORWARD);
        System.out.println("testMoveDrop: (expected an IllegalDropZoneException)");
        kiva.move(KivaCommand.DROP);
        System.out.println("testMoveDrop FAIL!");
    }
    //futility checking in the pod drop helper method
    //having robot drop when it was not carrying a pod
    public void testDropWhileNotCarrying(){
        Kiva kiva = new Kiva(defaultMap);
        kiva.move(KivaCommand.TURN_RIGHT);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        System.out.println("testMoveDrop: (expected an IllegalMoveException)");
        kiva.move(KivaCommand.DROP);
        System.out.println("testDropWhileNotCarrying FAIL!");
    }
    
    //public void testDrop
    
    private boolean sameLocation(Point a, Point b) {
        return a.getX() == b.getX() && a.getY() == b.getY();
    }

    private void verifyKivaState(
            String testName,
            Kiva actual,
            Point expectLocation,
            FacingDirection expectDirection,
            boolean expectCarry,
            boolean expectDropped) {
        Point actualLocation = actual.getCurrentLocation();
        if (sameLocation(actualLocation, expectLocation)) {
            System.out.println(
                    String.format("%s: current location SUCCESS", testName));
        }
        else {
            System.out.println(
                    String.format("%s: current location FAIL!", testName));
            System.out.println(
                    String.format("Expected %s, got %s",
                            expectLocation, actualLocation));
        }
        FacingDirection actualDirection = actual.getDirectionFacing();
        if (actualDirection == expectDirection) {
            System.out.println(
                    String.format("%s: facing direction SUCCESS", testName));
        }
        else {
            System.out.println(
                    String.format("%s: facing direction FAIL!", testName));
            System.out.println(
                    String.format("Expected %s, got %s",
                            expectDirection, actualDirection));
        }
        boolean actualCarry = actual.isCarryingPod();
        if (actualCarry == expectCarry) {
            System.out.println(
                    String.format("%s: carrying pod SUCCESS", testName));
        }
        else {
            System.out.println(
                    String.format("%s: carrying pod FAIL!", testName));
            System.out.println(
                    String.format("Expected %s, got %s",
                            expectCarry, actualCarry));
        }
        boolean actualDropped = actual.isSuccessfullyDropped();
        if (actualDropped == expectDropped) {
            System.out.println(
                    String.format("%s: successfully dropped SUCCESS", testName));
        }
        else {
            System.out.println(
                    String.format("%s: successfully dropped FAIL!", testName));
            System.out.println(
                    String.format("Expected %s, got %s",
                            expectDropped, actualDropped));
        }
    }
}
