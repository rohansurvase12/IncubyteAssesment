public class GalacticSpacecraftControl {
    private int x, y, z;
    private char direction;

    public GalacticSpacecraftControl(int x, int y, int z, char direction) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.direction = direction;
    }

    public void executeCommands(char[] commands) {
        for (char command : commands) {
            System.out.println(this.direction);
            switch (command) {
                case 'f':
                    moveForward();
                    break;
                case 'b':
                    moveBackward();
                    break;
                case 'r':
                    turnRight();
                    break;
                case 'l':
                    turnLeft();
                    break;
                case 'u':
                    turnUp();
                    break;
                case 'd':
                    turnDown();
                    break;
            }
        }
    }

    private void moveForward() {
        switch (direction) {
            case 'N':
                y++;
                break;
            case 'S':
                y--;
                break;
            case 'E':
                x++;
                break;
            case 'W':
                x--;
                break;
            case 'U':
                z++;
                break;
            case 'D':
                z--;
                break;
        }
    }

    private void moveBackward() {
        switch (direction) {
            case 'N':
                y--;
                break;
            case 'S':
                y++;
                break;
            case 'E':
                x--;
                break;
            case 'W':
                x++;
                break;
            case 'U':
                z--;
                break;
            case 'D':
                z++;
                break;
        }
    }

    private void turnRight() {
        switch (direction) {
            case 'N':
                direction = 'E';
                break;
            case 'S':
                direction = 'W';
                break;
            case 'E':
                direction = 'S';
                break;
            case 'W':
                direction = 'N';
                break;
            case 'U':
                direction = 'E';
                break;
            case 'D':
                direction = 'W';
                break;
        }
    }

    private void turnLeft() {
        switch (direction) {
            case 'N':
                direction = 'W';
                break;
            case 'S':
                direction = 'E';
                break;
            case 'E':
                direction = 'N';
                break;
            case 'W':
                direction = 'S';
                break;
            case 'U':
                direction = 'N';
                break;
            case 'D':
                direction = 'E';
                break;
        }
    }

    private void turnUp() {
        switch (direction) {
            case 'N':
            case 'S':
            case 'E':
            case 'W':
                direction = 'U';
                break;
        }
    }

    private void turnDown() {
        switch (direction) {
            case 'N':
            case 'S':
            case 'E':
            case 'W':
                direction = 'D';
                break;
        }
    }

    public String getCurrentPosition() {
        return "(" + x + ", " + y + ", " + z + ")";
    }

    public char getCurrentDirection() {
        return direction;
    }

    public static void main(String[] args) {
        GalacticSpacecraftControl spacecraft = new GalacticSpacecraftControl(0, 0, 0, 'N');
        char[] commands = {'f', 'r', 'u', 'b', 'l'};
        spacecraft.executeCommands(commands);
        System.out.println("Final Position: " + spacecraft.getCurrentPosition());
        System.out.println("Final Direction: " + spacecraft.getCurrentDirection());
    }
}
