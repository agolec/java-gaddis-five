package exams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;

public class Exam {
    ArrayList<Character> examQuestions;
    double score;
    int correctQuestions;


    public Exam(ArrayList<Character> correctAnswersFromFile){
        this.examQuestions = new ArrayList<>();
        this.score = 0.0;
        this.correctQuestions = 0;
        setCorrectAnswersForExam(correctAnswersFromFile);
    }
    public void setCorrectAnswersForExam(ArrayList<Character> correctAnswers){
        for(char answer: correctAnswers){
            if(!validateAnswer(answer)){
                throw new InputMismatchException("Error: encountered an incorrect answer character.\n" +
                        "Answer must be characters" + Arrays.toString(ValidCharacters.values()));
            } else {
                this.examQuestions.add(answer);
            }
        }
    }
    private boolean validateAnswer(char answerChar){
        return switch (answerChar) {
            case 'A', 'B', 'C', 'D' -> true;
            default -> false;
        };
    }
    public double getScore(){
        return this.score = (double) this.correctQuestions / getExamQuestionCount();
    }
    public int getExamQuestionCount(){
        return this.examQuestions.size();
    }

    public String toString(){
        return "This exam has " + getExamQuestionCount() + " questions.\n" +
                "You got " + getExamQuestionCount() + " correct.";
    }


}
