package inheritance.assignments.algorithmwb.fileUtility;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileUtility {

    public List<String> readFile(String filePath) throws IOException {
        return Files.readAllLines(Paths.get(filePath));
    }
    public void writeFile(String filePath, List<String> content) throws IOException {
        Files.write(Paths.get(filePath), content);
    }
    public void appendToFile(String filePath, List<String> content) throws IOException {
        Files.write(Paths.get(filePath), content, StandardOpenOption.APPEND);
    }
    public boolean fileExists(String filePath){
        return Files.exists(Paths.get(filePath));
    }
    public void deleteFile(String filePath) throws IOException{
        Files.deleteIfExists(Paths.get(filePath));
    }
    public int getValueFromFile() throws IOException, FileNotFoundException {
        File file = new File("data2.txt");

        if(!file.exists()){
//            try(FileWriter writer = new FileWriter(file)){
//                writer.write("42");
//                writer.flush();
//            } catch(IOException e){
//                throw new IOException("Failed to create the file: " + e.getMessage(), e);
//            }
            throw new FileNotFoundException("The file does not exist.");
        }
        // Read the value from the file
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine(); // Read the first line
            return Integer.parseInt(line); // Parse and return as an integer
        } catch (NumberFormatException e) {
            throw new IOException("The file does not contain a valid integer.", e);
        }
    }
}
