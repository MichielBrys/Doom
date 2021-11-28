package doom;

import doom.doomcharacters.Follower;
import doom.doomcharacters.Monster;
import doom.doomcharacters.Player;

public class Doom {
    private Room room;
    private Player player;
    private Monster[] monsters;
    private Follower[] followers;

    public Doom() {
        room = new Room();

    }

    public boolean isFinished() {
        return room.isFinished();
    }

    public void start() {
        player = room.getPlayer();
        monsters = room.getMonster();
        followers = room.getFollowers();
        room.createFloorPlan();
        while (!(isFinished())) {
            room.updateMonster();
            room.update();
            room.draw();
            for (Monster monster : monsters) {
                monster.attackPlayer(player);
            }
            for (Follower follower : followers){
                follower.attackPlayer(player);
            }

            player.isDead();

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}