import java.util.Objects;

public class TennisGame1 implements TennisGame {
    
    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public int wonPoint(String playerName) {
        if (Objects.equals(playerName, "player1"))
           return m_score1 += 1;

        return m_score2 += 1;
    }
    private String finalScore(){
        return null;
    }
    private String nameScoreBothEquals(int actualScore){
        String score;
        switch (actualScore){
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            default:
                score = "Deuce";
                break;

        }
        return score;
    }
    private String nameScoreIfgreaterby4(){
        String score;
            int minusResult = m_score1-m_score2;
            if (minusResult==1) score ="Advantage player1";
            else if (minusResult ==-1) score ="Advantage player2";
            else if (minusResult>=2) score = "Win for player1";
            else score ="Win for player2";
        return score;
    }

    private String equalScore(){
        return nameScoreBothEquals(m_score1);
    }

    private String optionsNamesScore(int score) {
        String scoreName = "";
        switch (score) {
            case 0:
                scoreName += "Love";
                break;
            case 1:
                scoreName += "Fifteen";
                break;
            case 2:
                scoreName += "Thirty";
                break;
            case 3:
                scoreName += "Forty";
                break;
        }
        return scoreName;
    }
    private String nameScorebetween3(){
        StringBuilder score = new StringBuilder();
        int tempScore=0;
        for (int i=1; i<3; i++)
        {
            if (i==1) tempScore = m_score1;
            else { score.append("-"); tempScore = m_score2;}
             score.append(optionsNamesScore(tempScore));
        }
        return score.toString();
    }

    public String getScore() {
        if (m_score1==m_score2){
           return equalScore();
        }
        if (m_score1>=4 || m_score2>=4){
            return nameScoreIfgreaterby4();
        }
        else{
           return nameScorebetween3();
        }
    }
}
