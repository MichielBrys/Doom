package doom;

public class Doom {
    private Room room;
    private Player player;
    public Doom(){
        room = new Room();

    }
    public boolean isFinished(){
        return room.isFinished();
    }
    public void start(){
        player = room.getPlayer();
        room.createFloorPlan();
        while(!(isFinished())) {
            room.update();
            room.draw();
            try{
                Thread.sleep(50);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }{


        }
    }
}
