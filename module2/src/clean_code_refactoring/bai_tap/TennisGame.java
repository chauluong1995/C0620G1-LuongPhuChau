package clean_code_refactoring.bai_tap;

public class TennisGame {
    static final int minScoreToWin = 4;
    public static final int ZERO = 0;
    public static final int FIFTEEN = 1;
    public static final int THIRTY = 2;
    public static final int FORTY = 3;

    public static String getScore(String player1Name, String player2Name, int scoreOfPlayer1, int scoreOfPlayer2) {
        String score = "";

        // đối chiếu nếu điểm bằng nhau :
        if (scoreOfPlayer1 == scoreOfPlayer2) {
            score = compareScore(scoreOfPlayer1);

            // so sánh với điểm tối thiểu để chiến thắng :
        } else if (scoreOfPlayer1 >= minScoreToWin || scoreOfPlayer2 >= minScoreToWin) {
            score = findWinner(scoreOfPlayer1, scoreOfPlayer2);

            // tính điểm :
        } else {
            score += scoreCalculation(scoreOfPlayer1, scoreOfPlayer2);
        }
        return score;
    }

    public static String compareScore(int scoreOfPlayer) {
        switch (scoreOfPlayer) {
            case ZERO:
                return "Love-All";
            case FIFTEEN:
                return "Fifteen-All";
            case THIRTY:
                return "Thirty-All";
            case FORTY:
                return "Forty-All";
            default:
                return "Deuce";
        }
    }

    public static String findWinner(int scoreOfPlayer1, int scoreOfPlayer2) {
        String findWinner;
        int minusResult = scoreOfPlayer1 - scoreOfPlayer2;
        if (minusResult == 1) {
            findWinner = "Advantage player1";
        } else if (minusResult == -1) {
            findWinner = "Advantage player2";
        } else if (minusResult >= 2) {
            findWinner = "Win for player1";
        } else findWinner = "Win for player2";
        return findWinner;
    }

    public static String scoreCalculation(int scoreOfPlayer1, int scoreOfPlayer2) {
        String scoreCalculation = scoreLabel(scoreOfPlayer1);
        scoreCalculation += "-";
        scoreCalculation += scoreLabel(scoreOfPlayer2);
        return scoreCalculation;
    }

    public static String scoreLabel(int scoreOfPlayer) {
        switch (scoreOfPlayer) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            default:
                return "Forty";
        }
    }
}
