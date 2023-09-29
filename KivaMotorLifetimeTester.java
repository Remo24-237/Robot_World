  

import edu.duke.*;
/**
 * <h1>Class used to test kiva motor life from the kiva class</h1>
 * @author (Omer Olloumou) 
 * @version (10/10/2021)
 */
public class KivaMotorLifetimeTester {
    
    String dLayout = ""
                     + "-----\n" 
                     + " K D \n"
                     + "  P  \n"
                     + " * * \n"
                     + "-----\n";
    FloorMap defaultMap = new FloorMap(dLayout);
    public void testmotorlife(){
        Kiva kiva = new Kiva(defaultMap);
        System.out.println(kiva.getMotorLifetime());
        kiva.move(KivaCommand.TURN_RIGHT);
        System.out.println(kiva.getMotorLifetime());
        kiva.move(KivaCommand.FORWARD);
        System.out.println(kiva.getMotorLifetime());
        kiva.move(KivaCommand.TURN_RIGHT);
        System.out.println(kiva.getMotorLifetime());
        kiva.move(KivaCommand.FORWARD);
        System.out.println(kiva.getMotorLifetime());
        kiva.move(KivaCommand.TAKE);
        System.out.println(kiva.getMotorLifetime());
    }
}
