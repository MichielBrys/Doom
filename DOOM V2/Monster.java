package doom;


public class Monster extends DoomCharacter {
    public final int STRENGTH = 1;
    private Player player;

    public Monster(int x, int y) {
        super(x, y);
    }

    public Player getPlayer() {
        return player;
    }

    public void attackPlayer(Player player) {
        if (Math.abs(this.getX() - player.getX()) <= 2)
            if (Math.abs(this.getY() - player.getY()) <= 2) {
                System.out.println("Ouch, you've been attacked!");
                player.attack(STRENGTH);
            }
    }

    public String toString() {
        return "M";
    }
}
