import java.util.Objects;

public class TennisGame2 implements TennisGame
{
    public int Player1points = 0;
    public int Player2points = 0;
    
    public String player1Result = "";
    public String player2Result = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }
    private String scoreIfOneIsZero(String score){
        if(Player1points == 0 || Player2points == 0 ){
           return getScoreFromOneZero();
        }
        return score;
    }
    private String getScoreFromOneZero(){
        if(Player1points != 0){
            player1Result = score(Player1points);
            player2Result = score(0);
            return player1Result + "-" + player2Result;
        }
        player2Result = score(Player2points);
        player1Result = score(0);
        return player1Result + "-" + player2Result;
    }

    private String score(int points){
        if(points == 4){
            return "";
        }
        String[] scoreNAme = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
        return scoreNAme[points];
    }
    private String equalsPoints(String score){
        if(Player1points == Player2points){
           return getScoreWhenEquals();
        }
        return score;
    }
    private String getScoreWhenEquals(){
        if(Player1points >=3){
            return "Deuce";
        }
        return  score(Player1points) + "-All";
    }
    private String scoreIfDifferentByFour(String score){
        if(Player1points > Player2points || Player2points > Player1points){
            return scoreIfBothDiferent(score);
//            player1Result = score(Player1points);
//            player2Result = score(Player2points);
//            return player1Result + "-" + player2Result;
        }
        return score;
    }
    private String scoreIfBothDiferent(String score){
        if(Player2points >= 3 || Player1points >= 3){
            return getScoreIfDifferentbyThree();
        } else if(Player1points < 4){
            return getScoreIfDiferentbyFour();
        }else{
            return score;
        }
    }
    private String getScoreIfDifferentbyThree(){
        if (Player1points > Player2points)
        {
            return  "Advantage player1";
        }
        return "Advantage player2";
    }
    private String getScoreIfDiferentbyFour(){
        player1Result = score(Player1points);
        player2Result = score(Player2points);
        return player1Result + "-" + player2Result;
    }

    public String getScore(){
        String score = "";
        score = equalsPoints(score);
        score = scoreIfOneIsZero(score);
        score = scoreIfBothDiferent(score);
//        if (Player1points > Player2points && Player1points < 4)
//        {
//            player1Result = score(Player1points);
//            player2Result = score(Player2points);
//            score = player1Result + "-" + player2Result;
//        }
//        if (Player2points > Player1points && Player2points < 4)
//        {
//            player1Result = score(Player1points);
//            player2Result = score(Player2points);
//            score = player1Result + "-" + player2Result;
//        }
//
//        if (Player1points > Player2points && Player2points >= 3)
//        {
//            score = "Advantage player1";
//        }
//
//        if (Player2points > Player1points && Player1points >= 3)
//        {
//            score = "Advantage player2";
//        }
        
        if (Player1points >=4 && Player2points >=0 && (Player1points - Player2points)>=2)
        {
            score = "Win for player1";
        }
        if (Player2points >=4 && Player1points >=0 && (Player2points - Player1points)>=2)
        {
            score = "Win for player2";
        }
        return score;
    }
    
    public void SetP1Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P1Score();
        }
            
    }
    
    public void SetP2Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P2Score();
        }
            
    }
    
    public int P1Score(){
        return Player1points++;
    }
    
    public int P2Score(){
        return Player2points++;
    }

    public int wonPoint(String player) {
        if (Objects.equals(player, "player1"))
           return P1Score();
       return P2Score();
    }
}