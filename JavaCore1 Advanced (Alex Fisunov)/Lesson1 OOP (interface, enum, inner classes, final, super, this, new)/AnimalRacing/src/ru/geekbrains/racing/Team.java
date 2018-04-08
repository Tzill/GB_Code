package ru.geekbrains.racing;
import ru.geekbrains.racing.participants.Participant;

public class Team {
    private String teamName;
    private Participant[] team;

    public Team(String teamName, Participant[] team){
        this.team = team;
        this.teamName = teamName;
    }

    public Team(String teamName, Participant p1, Participant p2, Participant p3, Participant p4){
        this.teamName = teamName;
        team = new Participant[]{p1, p2, p3, p4};
    }

    public String getTeamName() {
        return teamName;
    }

    protected Participant[] getTeam() {
        return team;
    }

    public void teamInfo(){
        for(Participant  p : team) {
            p.info();
        }
    }

    public void showResults(){
        System.out.println("Finished:");
        for(Participant  p : team) {
            if (p.isOnDistance()) p.info();
        }
    }
}
