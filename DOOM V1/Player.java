package doom;

import java.util.Random;

public class Player {
    public final double START_HEALTH = 9;
    private double health;
    private int x;
    private int y;
    Random rnd = new Random();
    private Room room;


    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        this.health = START_HEALTH;

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public void setRoom(Room room){
        this.room = room;
    }
    public Room getRoom(){
        return room;
    }

    public void attack(double damage) {
        health -= damage;

    }

    public double getHealth() {
        return health;
    }

    public boolean isDead() {
        boolean dead;
        if (health <= 0) {
            System.out.println("You died");
            dead = true;
        } else {
            dead = false;
        }
        return dead;
    }

    public void move() {
        while(true) {

            int xRandom = rnd.nextInt(1 + 2) - 1;
            int yRandom = rnd.nextInt(1 + 2) - 1;
            if (room.isFree(getX() + xRandom,getY() + yRandom)) {
                x += xRandom;
                y += yRandom;
                return;
            }
        }

    }


    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "P";
    }
}
