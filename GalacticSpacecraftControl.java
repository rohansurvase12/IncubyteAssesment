import java.util.Scanner;

public class GalacticSpacecraftControl {
    private int x, y, z;
    private char direction;

    public GalacticSpacecraftControl(int x, int y, int z, char direction) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.direction = direction;
    }
     
    
    public boolean executeCommands(char[] commands) {
    
        for (char command : commands) {
            try {
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
                    default:
                        throw new IllegalArgumentException("Invalid command: " + command);
                        
                }
            } catch (IllegalArgumentException e) {
                System.err.println("Error: " + e.getMessage());
                return false;
            }
        }
        return true;
    }

    public void moveForward() {
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

    public void moveBackward() {
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

    public void turnRight() {
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

    public void turnLeft() {
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

    public void turnUp() {
        switch (direction) {
            case 'N':
            case 'S':
            case 'E':
            case 'W':
                direction = 'U';
                break;
        }
    }

    public void turnDown() {
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
        Scanner scanner = new Scanner(System.in);
        int initialX,initialY,initialZ;
        char initialDirection;
       try{
         // Get initial position
        System.out.print("Enter initial X coordinate: ");
         initialX = scanner.nextInt();
        System.out.print("Enter initial Y coordinate: ");
         initialY = scanner.nextInt();
        System.out.print("Enter initial Z coordinate: ");
         initialZ = scanner.nextInt();
        System.out.print("Enter initial direction (N, S, E, W, U, D): ");
         initialDirection = scanner.next().charAt(0);
    }catch (java.util.InputMismatchException e) {
        System.err.println("Error: Invalid input for coordinates");
        scanner.close();
        return;
    }
       
        

        // Get initial direction
        
        if (initialDirection != 'N' && initialDirection != 'S' && initialDirection != 'E' &&
        initialDirection != 'W' && initialDirection != 'U' && initialDirection != 'D') {
        System.err.println("Error: Invalid initial direction.");
        scanner.close();
        return;
    }
        GalacticSpacecraftControl spacecraft = new GalacticSpacecraftControl(initialX, initialY, initialZ, initialDirection);

        scanner.nextLine(); // Consume the newline character

        // Get commands
        System.out.print("Enter commands (e.g., 'f' for forward, 'r' for right, 'u' for up): ");
        String inputCommands = scanner.nextLine().toLowerCase(); // Convert to lowercase

        char[] commands = inputCommands.replaceAll(" ", "").toCharArray();
        boolean check = spacecraft.executeCommands(commands);
        if(check){
        System.out.println("Final Position: " + spacecraft.getCurrentPosition());
        System.out.println("Final Direction: " + spacecraft.getCurrentDirection());
        }
        scanner.close();
    }
   
}
