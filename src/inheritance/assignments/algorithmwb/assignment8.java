package inheritance.assignments.algorithmwb;

import inheritance.assignments.algorithmwb.fileUtility.FileUtility;

import java.io.FileNotFoundException;
import java.io.IOException;

public class assignment8 {
    public static void main(String[] args){
        FileUtility fileUtil = new FileUtility();
        try{
            int value = fileUtil.getValueFromFile();
            System.out.println("Value from file is: " + value);
        } catch(FileNotFoundException e){
            System.err.println("File not found: " + e.getMessage());
        } catch(IOException e){
            System.err.println("An error has occurred while reading the file: " + e.getMessage());
        } catch (NumberFormatException e){
            System.err.println("Invalid number format: " + e.getMessage());
        }
    }
}
