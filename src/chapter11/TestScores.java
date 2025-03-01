package chapter11;

import chapter11.programmingchallenges.testscores.InvalidTestScore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestScores {
    private List<Integer> testScores;
    private int minimumScore;
    private int maximumScore;
    private int total;

    private int average;
    public TestScores(List<Integer> testScores, int minScore, int maximumScore) throws InvalidTestScore {
        if(testScores == null){
            throw new NullPointerException("Array of tests is empty.");
        }
        this.minimumScore = minScore;
        this.maximumScore = maximumScore;
        validateScore(testScores);
        this.testScores = new ArrayList<>(testScores);


    }
    private void validateScore(List<Integer> tests) throws InvalidTestScore {
        validateScore(tests, this.minimumScore,this.maximumScore);
    }
    public void validateScore(List<Integer> tests, int minimumScore,int maximumScore) throws InvalidTestScore {
        for(Integer score: tests){
            if(score < minimumScore){
                throw new InvalidTestScore("ERROR: Test score too low: " + score);
            } else if (score > maximumScore){
                throw new InvalidTestScore("ERROR: Test score too high: " + score);
            }
        }
    }

    public int getAverage(){
        calculateAverage();
        return this.average;
    }
    public int getTotal(){
        calculateTotal();
        return this.total;
    }
    public void calculateAverage(){
        this.average = this.total / this.testScores.size();
    }
    public void calculateTotal(){
        this.total = 0;
        for(Integer test: testScores){
            this.total += test;
        }
    }
    public int getNumberOfTests(){
        return this.testScores.size();
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Total: ").append(getTotal()).append("\n");
        sb.append("Average: ").append(getAverage()).append("\n");
        sb.append("Number of tests: ").append(getNumberOfTests());
        return sb.toString();
    }
}
