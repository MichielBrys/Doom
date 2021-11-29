package doom.doomcharacters;



public class Player extends DoomCharacter {
    public final double START_HEALTH = 50;
    private double health;



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
            dead = true;
            System.exit(2);
        } else {
            dead = false;
        }
        return dead;
    }

    public String toString() {
        return "P";
    }
}
