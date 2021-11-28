package doom.doomcharacters;

public class SimpleMonster extends Monster{
    public SimpleMonster(int x, int y){
        super(x,y);
    }
    public void attackPlayer(Player player){
            if (Math.abs(this.getX() - player.getX()) <= 2)
                if (Math.abs(this.getY() - player.getY()) <= 2) {
                    System.out.println("Ouch, you've been attacked!");
                    player.attack(STRENGTH);
                }
    }
}
