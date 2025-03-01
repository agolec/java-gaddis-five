package inheritance;

import javax.swing.*;

public class ProtectedDemo {
    public static void main(String[] args){
        String input;
        int questions;
        int missed;
        input = JOptionPane.showInputDialog(null,"How many questions are there on the final exam?");
        questions = Integer.parseInt(input);

        input = JOptionPane.showInputDialog(null,"How many questions did the student miss?" );
        missed = Integer.parseInt(input);

        FinalExam2 exam = new FinalExam2(questions, missed);

        JOptionPane.showMessageDialog(null,"Each Question counts as: " + exam.getPointsEach() + " points each.\n" +
                "The exam score is: " + exam.getScore() + "\nThe exam grade is: " + exam.getGrade());

        System.exit(0);

    }
}
