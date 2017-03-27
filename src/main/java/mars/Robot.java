package mars;

/**
 * Created by roberto on 26/03/17.
 */
public class Robot {

    private int posX;
    private int posY;
    private Direction direction;

    public Robot() {
        this.posX = 0;
        this.posY = 0;
        this.direction = Direction.N;
    }

    /**
     * This method generate the actual position of the Robot
     * @return <class>java.lang.String</class> actual position of the Robot
     */
    public String getPosition() {
        return String.format("(%d, %d, %s)",posX,posY,direction);
    }

    /**
     * This method is responsible for movements of the Robot. Robot's movement is always forward and depends on its orientation
     */
    public void move() {
        switch (direction) {
            case N:
                this.posY++;
                break;
            case E:
                this.posX++;
                break;
            case S:
                this.posY--;
                break;
            case W:
                this.posX--;
                break;
        }

        // Throws an exception when the robot is in an invalid position
        if (posX < 0 || posX > 4 || posY < 0 || posY > 4) {
            throw new IllegalArgumentException("Invalid Move");
        }
    }

    /**
     * This method is responsible for the change of Robot's orientation to the right
     */
    public void turnRigh() {
        int index = getNewIndex(1);
        direction = Direction.values()[index];
    }

    /**
     * This method is responsible for the change of Robot's orientation to the left
     */
    public void turnLeft() {
        int index = getNewIndex(-1);
        direction = Direction.values()[index];
    }

    private int getNewIndex(int increment) {
        int index = direction.ordinal() + increment;

        if (index < 0) {
            index = index + 4;
        } else if (index >= 4) {
            index = index - 4;
        }

        return index;
    }

}
