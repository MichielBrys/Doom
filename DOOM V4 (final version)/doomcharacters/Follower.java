package doom.doomcharacters;

import doom.Room;

public class Follower extends SimpleMonster{
    private Room room;
    public Follower(Player player,int x, int y){
        super(player,x,y);

    }
    public void setRoom(Room room){
        this.room = room;
    }

    public void movefollower(){
        while(true) {
            int xMove = 0;
            int yMove = 0;

            if (player.getX() == this.x +1 || player.getX() == this.x || player.getX() == this.x -1
                    || player.getY() == this.y + 1 || player.getY() == this.y || player.getY() == this.y -1) {
                return;
            }
            else {

                if (player.getX() >= this.x) {
                    xMove += 1;
                } else {
                    xMove -= 1;
                }
                if (player.getY() >= this.y) {
                    yMove += 1;
                } else {
                    yMove -= 1;
                }
                if (room.isFree(this.getX() + xMove, getY() + yMove)) {
                    x += xMove;
                    y += yMove;
                    return;
                }
                else return;
            }
        }
    }
    public String toString(){
        return "F";
    }
}
