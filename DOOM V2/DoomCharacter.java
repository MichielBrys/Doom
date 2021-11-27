package doom;

import java.util.Random;

public class DoomCharacter {
    protected int x;
    protected int y;
    protected Random rnd = new Random ();
    private Room room;

    public DoomCharacter(int x, int y) {
        this.x = x;
        this.y = y;



    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
    public void setRoom(Room room){
        this.room = room;
    }

    protected void move() {
        while(true) {

            int xRandom = rnd.nextInt(1 + 2) - 1;
            int yRandom = rnd.nextInt(1 + 2) - 1;
            if (room.isFree(this.getX() + xRandom,getY() + yRandom)) {
                x += xRandom;
                y += yRandom;
                return;
            }
        }

    }


}
