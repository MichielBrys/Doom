package doom;

public class Doom {
    private Room room;
    private Player player;
    private Monster[] monsters;
    private Monster monster;

    public Doom() {
        room = new Room();

    }

    public boolean isFinished() {
        return room.isFinished();
    }

    public void start() {
        player = room.getPlayer();
        monsters = room.getMonster();
        room.createFloorPlan();
        while (!(isFinished())) {
            room.updateMonster();
            room.update();
            room.draw();
            for (Monster monster : monsters) {
                monster.attackPlayer(player);
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