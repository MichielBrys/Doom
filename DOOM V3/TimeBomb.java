package doom;

import doom.doomcharacters.Monster;
import doom.doomcharacters.Player;

import java.util.Random;

public class TimeBomb extends Monster {
    private final double BOMB_STRENGTH = 3;
    private int startTime;
    private int endTime;
    private Random random = new Random();

    public TimeBomb(Player player,int x, int y){
        super(player,x,y);
    }
    @Override
    public void attackPlayer() {
       /*for (int startTime = random.nextInt(5)+5; startTime <= 0 ; startTime--) {
            System.out.println(startTime);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/

        if (Math.abs(this.getX() - player.getX()) <= 5)
            if (Math.abs(this.getY() - player.getY()) <= 5) {
                System.out.println("BOOOOOOOOOOOOM");
                player.attack(BOMB_STRENGTH);
            }



    }
    @Override
    public String toString(){
        return "T";
    }
}
