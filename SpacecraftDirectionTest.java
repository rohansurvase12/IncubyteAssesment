import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SpacecraftDirectionTest {

    @Test
    public void testTurnRight() {
        GalacticSpacecraftControl spacecraft = new GalacticSpacecraftControl(0, 0, 0, 'N');
        spacecraft.turnRight();
        assertEquals('E', spacecraft.getCurrentDirection());
    }

    @Test
    public void testTurnLeft() {
        GalacticSpacecraftControl spacecraft = new GalacticSpacecraftControl(0, 0, 0, 'N');
        spacecraft.turnLeft();
        assertEquals('W', spacecraft.getCurrentDirection());
    }

    @Test
    public void testTurnUp() {
        GalacticSpacecraftControl spacecraft = new GalacticSpacecraftControl(0, 0, 0, 'N');
        spacecraft.turnUp();
        assertEquals('U', spacecraft.getCurrentDirection());
    }

    @Test
    public void testTurnDown() {
        GalacticSpacecraftControl spacecraft = new GalacticSpacecraftControl(0, 0, 0, 'N');
        spacecraft.turnDown();
        assertEquals('D', spacecraft.getCurrentDirection());
    }
}
