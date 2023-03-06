package example9.main;

public class TeamScore {
    private int teamId;
    private Double score;

    public TeamScore(int teamId, Double score) {
        this.teamId = teamId;
        this.score = score;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
