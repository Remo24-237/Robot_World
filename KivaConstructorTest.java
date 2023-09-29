

import edu.duke.Point;
/**
 * <h1>Class to test the kiva Constructors.<h1>
 * @author (Omer Olloumou) 
 * @version (10/10/2021)
 */
public class KivaConstructorTest {
        String defaultLayout = "" 
                            + "-------------\n" 
                            + "        P   *\n"
                            + "   **       *\n"
                            + "   **       *\n"
                            + "  K       D *\n"
                            + " * * * * * **\n"
                            + "-------------\n";

    FloorMap defaultMap = new FloorMap(defaultLayout);

    public void testSingleArgumentConstructor() { 
        // GIVEN 
        // The default map we defined earlier 

        // WHEN 
        // We create a Kiva with the single-argument constructor         
        Kiva kiva = new Kiva(defaultMap); 

        // THEN 
        // The initial Kiva location is (2, 4) 
        Point initialLocation = kiva.getCurrentLocation();
        Point expectedLocation = new Point(2, 4);
        if (sameLocation(initialLocation, expectedLocation)) { 
            System.out.println("testSingleArgumentConstructor SUCCESS"); 
        } else { 
            System.out.println(String.format( "testSingleArgumentConstructor FAIL: %s != (2,4)!", initialLocation)); 
        } 
    } 
    
    private boolean sameLocation(Point a, Point b) { 
       return b.getX() == a.getX() && b.getY() == a.getY(); 
    } 
    
    // For you: create a test for the constructor taking two arguments. 
    public void testTwoArgumentConstructors(){
        Point currentLocation = new Point(5,6);
        Kiva kiva = new Kiva(defaultMap,currentLocation); 

        // THEN 
        // The initial Kiva location is (5,6) 
        Point initialLocation = kiva.getCurrentLocation();
        //System.out.println(initialLocation);
        Point expectedLocation = new Point(5, 6);
        if (sameLocation(initialLocation, expectedLocation)) { 
            System.out.println("testSingleArgumentConstructor SUCCESS"); 
        } else { 
            System.out.println(String.format( "testSingleArgumentConstructor FAIL: %s != (2,4)!", initialLocation)); 
        } 
        
    }
}
