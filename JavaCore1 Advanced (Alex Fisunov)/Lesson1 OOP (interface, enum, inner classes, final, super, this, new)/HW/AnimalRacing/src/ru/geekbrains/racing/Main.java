package ru.geekbrains.racing;
import ru.geekbrains.racing.obstacles.Cross;
import ru.geekbrains.racing.obstacles.Obstacle;
import ru.geekbrains.racing.obstacles.Wall;
import ru.geekbrains.racing.obstacles.Water;
import ru.geekbrains.racing.participants.*;

public class Main {
    public static void main(String[] args) {
        Participant[] participants = {new Cat("Barsik"), new Dog("Bobik"), new Human("Bob"), new Human("Vasya")};
        Obstacle[] obstacles = {new Cross(100), new Wall(10), new Water(5)};

        Course c = new Course(obstacles);
        if (isTeam(participants)) {
            Team t1 = new Team("Super Nova", participants);
            c.doIt(t1);
            System.out.print(t1.getTeamName() + "  ");
            t1.showResults();
        } else {
            System.out.println("Not enough or too many participants");
        }
        Team t2 = new Team("Supero Nuvo", new Dog("Bresik"), new Dog("Boik"), new Human("Boob"), new Human("Vaesya"));
        c.doIt(t2);
        System.out.print(t2.getTeamName() + "  ");
        t2.showResults();
    }

    public static boolean isTeam(Participant[] participants){
        if(participants.length != 4) return false;
        else return true;
    }
}
