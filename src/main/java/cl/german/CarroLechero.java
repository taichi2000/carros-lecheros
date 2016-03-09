package cl.german;

public class CarroLechero {

    private int x;
    private int y;
    private Cardinal orientation;

    public CarroLechero(int x, int y, String orientation) {
        this.x = x;
        this.y = y;
        this.orientation = Cardinal.valueOf(orientation);
    }

    public void act(char action) {
        switch (action) {
            case 'M':
                move();
                break;

            case 'I':
                orientation = orientation.left();
                break;

            case 'D':
                orientation = orientation.right();
                break;
        }
    }

    private void move() {
        switch (orientation) {
            case N:
                y = y + 1;
                break;

            case S:
                y = y - 1;
                break;

            case E:
                x = x + 1;
                break;

            case O:
                x = x - 1;
                break;
        }
    }


    public int getX() {
        return x;
    }


    public int getY() {
        return y;
    }


    public Cardinal getOrientation() {
        return orientation;
    }
}
