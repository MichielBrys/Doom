package doom;

import doom.doomcharacters.Follower;
import doom.doomcharacters.Monster;
import doom.doomcharacters.Player;


import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Room {
    public final int HEIGHT = 15;
    public final int WIDTH = 100;
    private Random random = new Random();
    private Player player = new Player(HEIGHT / 2, WIDTH / 2);
    public Monster[] monsters = new Monster[20];
    public Follower[] followers = new Follower[5];
    public TimeBomb[] timeBombs = new TimeBomb[3];
    private char[][] floorPlan;
    char counter = '5';
    LocalDate localDate = LocalDate.now();
    LocalTime localTime = LocalTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");



    public Room() {
        player.setRoom(this);

    }

    public void makeMonsters() {
        for (int i = 0; i < monsters.length; i++) {
            monsters[i] = new Monster(player,HEIGHT - random.nextInt(12) - 2, WIDTH - random.nextInt(95) - 2);
            monsters[i].setRoom(this);
        }
        for (int i = 0; i < followers.length; i++) {
            followers[i] = new Follower(player,HEIGHT - random.nextInt(12) - 2, WIDTH - random.nextInt(95) - 2);
            followers[i].setRoom(this);
        }
        for (int i = 0; i < timeBombs.length; i++) {
            timeBombs[i] = new TimeBomb(player,HEIGHT - random.nextInt(12) - 2, WIDTH - random.nextInt(95) - 2);
            timeBombs[i].setRoom(this);
        }


    }

    public void createFloorPlan() {
        floorPlan = new char[HEIGHT][WIDTH];
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 1; j < HEIGHT; j++) {
                floorPlan[j][0] = '|';
                floorPlan[j][WIDTH - 1] = '|';
                floorPlan[0][i] = '_';
                floorPlan[HEIGHT - 1][i] = '_';
            }
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

    public void updateMonster() {

        for (Monster monster : monsters) {
            floorPlan[monster.getX()][monster.getY()] = ' ';
            monster.move();
            floorPlan[monster.getX()][monster.getY()] = monster.toString().charAt(0);

        }
        for (Follower follower : followers) {
            floorPlan[follower.getX()][follower.getY()] = ' ';
            follower.movefollower();
            floorPlan[follower.getX()][follower.getY()] = follower.toString().charAt(0);
        }
        if (counter < '0') {
            counter = '5';
        }
        for (TimeBomb timeBomb : timeBombs) {
            floorPlan[timeBomb.getX()][timeBomb.getY()] = ' ';
            floorPlan[timeBomb.getX()][timeBomb.getY()] = counter;

        } counter --;

    }



    public void draw() {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                System.out.print(floorPlan[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        System.out.printf("%s\t\t\t\t%s \t\t\t\tHealth: %2.0f \n ",localTime.format(formatter), localDate,player.getHealth());
        if (isFinished()) {
            System.out.println("AAAAAAAAAAAAAA IM DEAD");
        }

    }

    public boolean isFree(int x, int y) {
        return floorPlan[x][y] == ' ';

    }

    public boolean isFinished() {
        return player.getHealth() <= 0;
    }


    public Player getPlayer() {
        return player;
    }

    public Monster[] getMonster() {
        return monsters;
    }

    public Follower[] getFollowers() {
        return followers;
    }

    public TimeBomb[] getTimeBombs() {
        return timeBombs;
    }
}