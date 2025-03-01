package exams;

import java.util.Scanner;

public class mainCode {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        ExamFileReader examFileReader = new ExamFileReader(getDirectoryFromUser(input));
        System.out.println("Success. Your directory is: " + examFileReader.getDirectory());
        System.out.println("End program.");
    }
    public static void promptUserForDirectory(){
        System.out.println("Enter the directory for the exam file: ");
    }
    public static String getDirectoryFromUser(Scanner scan){
        String directoryName;
        while(true){
            promptUserForDirectory();
            directoryName = scan.nextLine().trim();
            if(validateDirectoryName(directoryName)){
                return directoryName;
            }
            System.out.println("Input cannot be blank or empty. Try again.");
        }

    }
    private static boolean validateDirectoryName(String directoryName){
        return !directoryName.isBlank() && !directoryName.isEmpty();
    }


}
