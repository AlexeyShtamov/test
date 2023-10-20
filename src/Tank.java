public class Tank {

    private int positionX;
    private int positionY;
    private int direction = 0;
    private int fuel;
    private final String NAME = "T34";
    private static int count = 1;
    public Tank(){
        this.fuel = 100;
    }

    public Tank(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.fuel = 100;
    }

    public Tank(int positionX, int positionY, int fuel) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.fuel = fuel;
    }

    public void goForward(int i) {
        doMove(i);
    }

    public void goBackward(int i) {
        doMove(-i);
    }

    public void printPosition() {
        System.out.printf("The Tank %s is at %d, %d now.\n", NAME + "-" + count++, positionX, positionY);
    }

    private void doMove(int move){
        if (!(fuel <= 0)){
            int remainder = 0;
            if((remainder = fuel - Math.abs(move)) <= 0){
                remainder = Math.abs(remainder);
                move = move < 0 ? move + remainder : move - remainder;
                fuel = 0;
            }else {
                this.fuel -= Math.abs(move);
            }
            switch (this.direction){
                case 0: this.positionX += move;
                    break;
                case 1: this.positionY -= move;
                    break;
                case 2: this.positionX -= move;
                    break;
                case 3: this.positionY += move;
            }
        }
    }

    public void turnRight() {
        this.direction++;
        if (this.direction > 3) this.direction = 0;
    }
    public void turnLeft() {
        this.direction++;
        if (this.direction < 0) this.direction = 3;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public String getNAME() {
        return NAME;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Tank.count = count;
    }
}
