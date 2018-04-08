package ru.geekbrains.racing;
import ru.geekbrains.racing.obstacles.Obstacle;
import ru.geekbrains.racing.participants.Participant;

public class Course {
    Obstacle[] obstacles;

    public Course(Obstacle[] obstacles) {
        this.obstacles = obstacles;
    }

    public void doIt(Team team) throws NullPointerException{
            for (Participant p : team.getTeam()) {
                for (Obstacle o : obstacles) {
                    o.doIt(p);
                    if (!p.isOnDistance()) {
                        break;
                    }
                }
            }
    }
}
