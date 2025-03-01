package inheritance;

public class CurvedActivity extends GradedActivity {
    double rawScore;
    double percentage;

    public CurvedActivity(double percent){
        percentage = percent;
        rawScore = 0.0;
    }

    public void setScore(double score){
        rawScore = score;
        super.setScore(rawScore * percentage);
    }

    public double getRawScore(){
        return rawScore;
    }

    public double getPercentage(){
        return percentage;
    }
}
