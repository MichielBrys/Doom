package doom.doomcharacters;


import doom.doomcharacters.Monster;
import doom.doomcharacters.Player;
import doom.Room.*;

import java.util.Random;

public class Zombie extends Monster {
    public enum ZombieAliveOrDeadStatus {
        DEAD("+"), ALIVE("Z");
        private String aliveOrDeadStatus;

        ZombieAliveOrDeadStatus(String aliveOrDeadStatus) {
            this.aliveOrDeadStatus = aliveOrDeadStatus;
        }
    }

    protected ZombieAliveOrDeadStatus status = ZombieAliveOrDeadStatus.DEAD;

    public Zombie(Player player, int x, int y) {
        super(player, x, y);
    }


    public void move() {
        Random r = new Random();
        int revivalChance = r.nextInt(101);

        if (revivalChance <= 10) {
            status = ZombieAliveOrDeadStatus.ALIVE;
        }

        if (!(status == ZombieAliveOrDeadStatus.DEAD)) {
            super.move();
            revivalChance = r.nextInt(101);
            if (revivalChance <= 70) status = ZombieAliveOrDeadStatus.DEAD;

        } else return;
    }


    @Override
    public String toString() {
        return status.aliveOrDeadStatus;
    }

    @Override
    public void attackPlayer() {

    }
}