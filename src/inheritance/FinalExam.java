package inheritance;

public class FinalExam extends GradedActivity {
    private int numQuestions;
    private double pointsEach;
    private int numberMissed;

    public FinalExam(int questions,int missed){
        double numericScore;
        this.numQuestions = questions;
        this.numberMissed = missed;
        this.pointsEach = 100.0/this.numQuestions;
        numericScore = 100.0 - (missed * pointsEach);

        setScore(numericScore);
    }
    public double getPointsEach(){
        return this.pointsEach;
    }
    public double getNumberMissed(){
        return this.pointsEach;
    }
    public int getNumMissed(){
        return this.numberMissed;
    }
}
