package doom;

import java.util.Random;

public class Room {
    public final int HEIGHT = 15;
    public final int WIDTH = 100;
    private Random random = new Random();
    private Player player = new Player(HEIGHT / 2, WIDTH / 2);
    public Monster[] monsters = new Monster[12];

    private char[][] floorPlan;


    public Room() {
        player.setRoom(this);

        for (int i = 0; i < monsters.length; i++) {
            monsters[i] = new Monster(HEIGHT - random.nextInt(12)-2, WIDTH - random.nextInt(95)-2);
        }

        for (Monster monster: monsters)
        {
            monster.setRoom(this);

        }


    }

    public void createFloorPlan() {
        floorPlan = new char[HEIGHT][WIDTH];
        for (int i = 0; i < WIDTH; i++) {
            floorPlan[0][i] = '_';
            floorPlan[HEIGHT - 1][i] = '_';
        }
        for (int i = 1; i < HEIGHT; i++) {
            floorPlan[i][0] = '|';
            floorPlan[i][WIDTH - 1] = '|';
        }
        for (int i = 1; i < WIDTH - 1; i++) {
            for (int j = 1; j < HEIGHT - 1; j++) {
                floorPlan[j][i] = ' ';

            }
        }


    }

    public void update() {

        floorPlan[player.getX()][player.getY()] = ' ';
        player.move();
        floorPlan[player.getX()][player.getY()] = 'P';


    }
    public void updateMonster(){
        for (Monster monster: monsters) {
            floorPlan[monster.getX()][monster.getY()] = ' ';
            monster.move();
            floorPlan[monster.getX()][monster.getY()] = 'M';
        }




    }

    public void draw() {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                System.out.print(floorPlan[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        System.out.printf("\nHealth: %2.0f\n", player.getHealth());
        if (isFinished()) {
            System.out.println("AAAAAAAAAAAAAA IM DEAD");
        }

    }

    public boolean isFree(int x, int y) {
        boolean isFree = floorPlan[x][y] == ' ';
        return isFree;

    }

    public boolean isFinished() {
        boolean isFinished = player.getHealth() <= 0;
        return isFinished;
    }


    public Player getPlayer() {
        return player;
    }
    public Monster[] getMonster(){
        return monsters;
    }
}