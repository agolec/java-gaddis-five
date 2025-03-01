package inheritance.chain;

import java.util.Scanner;

public class PassFailDemo {
    public static void main(String[] args){
        int questions;
        int missed;
        double minPassing;

        Scanner keyboard = new Scanner(System.in);
        System.out.println("How many questions are on the exam?");
        questions = keyboard.nextInt();

        System.out.println("How many questions did the student miss?");
        missed = keyboard.nextInt();

        System.out.println("What is the mininum passing score?");
        minPassing = keyboard.nextDouble();

        PassFailExam exam = new PassFailExam(questions,missed,minPassing);
        System.out.println("Each question counts as " + exam.getPointsEach() + " points.");

        System.out.println("The exam score is: " + exam.getScore());

        System.out.println("The letter grade is: " + exam.getGrade());
    }
}
