package inheritance;

public class FinalExam2 extends GradedActivity2 {
    private int numQuestions;
    private double pointsEach;
    private int numMissed;

    public FinalExam2(int questions, int missed) {
        double numericScore;
        numQuestions = questions;
        numMissed = missed;

        pointsEach = 100.0 / questions;
        numericScore = 100.0 - (missed * pointsEach);

        setScore(numericScore);

        adjustScore();
    }

    public double getPointsEach() {
        return pointsEach;
    }

    public int getNumMissed() {
        return numMissed;
    }

    private void adjustScore() {
        double fraction;
        final double ROUND_UP_THRESHOLD = 0.5;
        final double ONE = 1.0;
        //get the fractional part of the score by subtracting the integer cast of the score from the full score.
        fraction = score - (int) score;
        if (fraction >= ROUND_UP_THRESHOLD) {
            score = score + (ONE - fraction);
        }

    }
}
