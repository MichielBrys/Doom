/*package doom.doomcharacters;

public class Zombie extends Monster {
    private boolean alive;
    public Zombie(Player player, int x, int y) {
        super(player, x, y);
    }

    public void move() {

        while (alive) {

            int xRandom = rnd.nextInt(1 + 2) - 1;
            int yRandom = rnd.nextInt(1 + 2) - 1;
            if (room.isFree(this.getX() + xRandom, getY() + yRandom)) {
                x += xRandom;
                y += yRandom;
                return;
            }
        }
    }

    public void attackPlayer() {
        if (Math.abs(this.getX() - player.getX()) <= 2)
            if (Math.abs(this.getY() - player.getY()) <= 2) {
                System.out.println("Ouch, you've been attacked!");
                player.attack(STRENGTH);
            }
    }

    public String toString() {
        return "Z";
    }
}
*/