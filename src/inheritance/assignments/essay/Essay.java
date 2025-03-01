package inheritance.assignments.essay;

import inheritance.GradedActivity;

public class Essay extends GradedActivity {
    private double grammarScore = 0;
    private double spellingScore = 0;
    private double lengthScore = 0;
    private double contentScore = 0;

    Essay(double grammarScore, double spellingScore, double lengthScore,double contentScore){
        super();
        setGrammarScore(grammarScore);
        setSpellingScore(spellingScore);
        setLengthScore(lengthScore);
        setContentScore(contentScore);
        setScore();
    }

    public double getGrammarScore() {
        return grammarScore;
    }

    public double getSpellingScore() {
        return spellingScore;
    }

    public double getLengthScore() {
        return lengthScore;
    }

    public double getContentScore() {
        return contentScore;
    }

    public void setGrammarScore(double grammarScore) {
        this.grammarScore = grammarScore;
    }

    public void setSpellingScore(double spellingScore) {
        this.spellingScore = spellingScore;
    }
    public void setLengthScore(double lengthScore) {
        this.lengthScore = lengthScore;
    }
    public void setContentScore(double contentScore) {
        this.contentScore = contentScore;
    }
    public void setScore(){
        double totalScore = getGrammarScore() + getSpellingScore() + getLengthScore() + getContentScore();
        super.setScore(totalScore);
    }
}
