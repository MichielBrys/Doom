package doom.doomcharacters;


public class TimeBomb extends Monster {
    private final double BOMB_STRENGTH = 3;


    public TimeBomb(Player player,int x, int y){
        super(player,x,y);
    }
    @Override
    public void attackPlayer() {

        if (Math.abs(this.getX() - player.getX()) <= 5)
            if (Math.abs(this.getY() - player.getY()) <= 5) {
                System.out.println("BOOOOOOOOOOOOM! 3 Damage taken");
                player.attack(BOMB_STRENGTH);
            }



    }
    @Override
    public String toString(){
        return "T";
    }
}
