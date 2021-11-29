package doom.doomcharacters;


import java.util.Date;

public class Player extends DoomCharacter {
    public final double START_HEALTH = 50;
    private double health;
    Date startDate = new Date();



    public Player(int x, int y) {

        super(x,y);
        this.health = START_HEALTH;

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
            Date endDate = new Date();
            int numSeconds = (int)((endDate.getTime()-startDate.getTime())/1000);
            System.out.println("You survived " + numSeconds + " seconds!");
            dead = true;
            System.exit(0);
        } else {
            dead = false;
        }
        return dead;
    }

    public String toString() {
        return "P";
    }
}
