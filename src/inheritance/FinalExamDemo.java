package inheritance;

import javax.swing.*;

public class FinalExamDemo {
    public static void main(String[] args){
        String input;
        int questions;
        int numMissed;

        input = JOptionPane.showInputDialog(null,"Enter the number of questions there are on the final exam: ");
        questions = Integer.parseInt(input);

        input = JOptionPane.showInputDialog(null,"How many questions were missed by the student? \nEnter the number:");
        numMissed = Integer.parseInt(input);

        FinalExam exam = new FinalExam(questions,numMissed);

        JOptionPane.showMessageDialog(null,"Each question counts " + exam.getPointsEach() + " points.\nThe exam score is: " + exam.getScore()
            + "\nThe exam grade is: " + exam.getGrade());

        System.exit(0);


    }
}
