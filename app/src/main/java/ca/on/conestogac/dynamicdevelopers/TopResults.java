package ca.on.conestogac.dynamicdevelopers;

public class TopResults {

    public String playerName;
    public float score;

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public TopResults(String playerName, float score) {
        this.playerName = playerName;
        this.score = score;

    }
}
