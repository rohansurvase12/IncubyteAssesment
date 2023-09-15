import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SpacecraftMovementTest {
    
    @Test
    public void testMoveForward() {
        GalacticSpacecraftControl spacecraft = new GalacticSpacecraftControl(0, 0, 0, 'N');
        spacecraft.moveForward();
        assertEquals("(0, 1, 0)", spacecraft.getCurrentPosition());
    }

    @Test
    public void testMoveBackward() {
        GalacticSpacecraftControl spacecraft = new GalacticSpacecraftControl(0, 0, 0, 'N');
        spacecraft.moveBackward();
        assertEquals("(0, -1, 0)", spacecraft.getCurrentPosition());
    }
}
