package ca.on.conestogac.dynamicdevelopers;

public class TopResults {

    private String playerName;
    private String score;

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public TopResults(String playerName, String score) {
        this.playerName = playerName;
        this.score = score;

    }
}
