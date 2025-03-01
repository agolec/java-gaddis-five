package exams;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ExamFileReader {
    ArrayList<Character> examQuestions;
    String directory;
    File file;
    Scanner inputFile;
    ExamFileReader(String directory){
        setDirectory(directory);

        this.examQuestions = new ArrayList<Character>();
        //readExamQuestions(directory);

    }

    public void readExamQuestions(){

    }
    public void setDirectory(String directory){
        this.directory = directory;
    }
    public void setFile() {
        try {
            this.file = new File(getDirectory());
            this.inputFile = new Scanner(this.file);
        } catch (FileNotFoundException e){
            System.out.println("Error: File not found. Please set directory again: ");

        }
    }
    public ArrayList<Character> getExamQuestions(){
        return new ArrayList<Character>(this.examQuestions);
    }

    public String getDirectory(){
        return this.directory;
    }
}
