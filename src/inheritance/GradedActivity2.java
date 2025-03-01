package inheritance;

public class GradedActivity2 {

    private final char A_LETTER_GRADE = 'A';
    private final char B_LETTER_GRADE = 'B';
    private final char C_LETTER_GRADE = 'C';
    private final char D_LETTER_GRADE = 'D';
    private final char F_LETTER_GRADE = 'F';
    protected double score;
    GradedActivity2(){

    }
    public void setScore(double score){
        if(score > 100 || score < 0){
            throw new IllegalArgumentException("Score must be between 0 and 100.");
        }
        this.score = score;
    }
    public double getScore(){
        return this.score;
    }
    public char getGrade(){
        final int A_NUMERIC_SCORE = 90;
        final int B_NUMERIC_SCORE = 80;
        final int C_NUMERIC_SCORE = 70;
        final int D_NUMERIC_SCORE = 60;
        char letterGrade;

        if(score >= A_NUMERIC_SCORE){
            letterGrade = A_LETTER_GRADE;
        } else if(score >= B_NUMERIC_SCORE){
            letterGrade = B_LETTER_GRADE;
        } else if (score >= C_NUMERIC_SCORE) {
            letterGrade = C_LETTER_GRADE;
        } else if (score >= D_NUMERIC_SCORE) {
            letterGrade = D_LETTER_GRADE;
        }
        else
            letterGrade = F_LETTER_GRADE;

        return letterGrade;
    }

}
