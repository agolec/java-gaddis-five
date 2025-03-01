package inheritance.chain;

import inheritance.GradedActivity;

public class PassFailActivity extends GradedActivity {
    private double minimumPassingScore;

    public PassFailActivity(double minimumPassingScore){
        this.minimumPassingScore = minimumPassingScore;
    }

    public char getGrade(){
        char letterGrade;
        if(super.getScore() >= minimumPassingScore){
            letterGrade = 'P';
        }
        else{
            letterGrade = 'F';
        }
        return letterGrade;
    }
}
