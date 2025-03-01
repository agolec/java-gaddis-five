package inheritance.assignments.essay;

import javax.swing.*;


public class EssayDemo {
    public static void main(String[] args){
        String input;
        double grammarScore;
        double spellingScore;
        double lengthScore;
        double contentScore;
        Essay anEssay;

        input = JOptionPane.showInputDialog("Enter your grammar score: ");
        grammarScore = Double.parseDouble(input);
        //anEssay.setGrammarScore(score);

        input = JOptionPane.showInputDialog("Enter your spelling score: ");
        spellingScore = Double.parseDouble(input);
        //anEssay.setSpellingScore(score);

        input = JOptionPane.showInputDialog("enter your length score: ");
        lengthScore = Double.parseDouble(input);
        //anEssay.setLengthScore(score);

        input = JOptionPane.showInputDialog("Enter content score: ");
        contentScore = Double.parseDouble(input);
        //anEssay.setContentScore(score);

        anEssay = new Essay(grammarScore,spellingScore,lengthScore,contentScore);

        JOptionPane.showMessageDialog(null, "Your Grammar score is: " + anEssay.getGrammarScore() + "\n"
        + "Your spelling score is: " + anEssay.getSpellingScore() + "\n" + "Your length score is: " + anEssay.getLengthScore() + "\n" +
                "Your content score: " + anEssay.getContentScore() + "\n" + "Your score total is: " + anEssay.getScore() + "\n" +"Your grade is: " + anEssay.getGrade());
    }
}
