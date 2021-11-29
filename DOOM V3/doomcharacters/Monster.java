package doom.doomcharacters;


public class Monster extends DoomCharacter {
    public final int STRENGTH = 1;
    protected Player player;

    public Monster(Player player, int x, int y) {
        super(x, y);
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public void attackPlayer() {
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
