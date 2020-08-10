package clean_code_refactoring.bai_tap;

public class TennisGame {
    static final int maxScore = 3;
    static final int minScoreToWin = 4;

    public static String getScore(String player1Name, String player2Name, int scoreOfPlayer1, int scoreOfPlayer2) {
        String score = "";

        if (scoreOfPlayer1 == scoreOfPlayer2) {
            score = compareScore(scoreOfPlayer1);
        } else if (scoreOfPlayer1 >= minScoreToWin || scoreOfPlayer2 >= minScoreToWin) {
            score = findWinner(scoreOfPlayer1, scoreOfPlayer2);
        } else {
            score += scoreCalculation(scoreOfPlayer1, scoreOfPlayer2);
        }
        return score;
    }

    public static String compareScore(int scoreOfPlayer) {
        String compareScore;
        switch (scoreOfPlayer) {
            case 0:
                compareScore = "Love-All";
                break;
            case 1:
                compareScore = "Fifteen-All";
                break;
            case 2:
                compareScore = "Thirty-All";
                break;
            case 3:
                compareScore = "Forty-All";
                break;
            default:
                compareScore = "Deuce";
                break;
        }
        return compareScore;
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
        int tempScore;
        String scoreCalculation = "";

        for (int i = 1; i < maxScore; i++) {
            if (i == 1) {
                tempScore = scoreOfPlayer1;
            } else {
                scoreCalculation += "-";
                tempScore = scoreOfPlayer2;
            }
            switch (tempScore) {
                case 0:
                    scoreCalculation += "Love";
                    break;
                case 1:
                    scoreCalculation += "Fifteen";
                    break;
                case 2:
                    scoreCalculation += "Thirty";
                    break;
                case 3:
                    scoreCalculation += "Forty";
                    break;
            }
        }
        return scoreCalculation;
    }
}
