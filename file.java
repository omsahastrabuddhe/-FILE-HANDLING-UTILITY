import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class file {

    private static final String FILE_PATH = "sample.txt";

    public static void main(String[] args)

    {
        try {
            writeToFile("Hello, this is the initial content of the file.");
            System.out.println("Reading from file:");
            readFromFile();
            modifyFile("initial", "modified");
            System.out.println("\nAfter modification:");
            readFromFile();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void writeToFile(String content) throws IOException {
        FileWriter writer = new FileWriter(FILE_PATH);
        writer.write(content);
        writer.close();
        System.out.println("Write operation completed.");
    }

    public static void readFromFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }

    public static void modifyFile(String oldWord, String newWord) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(FILE_PATH)));
        content = content.replaceAll(oldWord, newWord);
        FileWriter writer = new FileWriter(FILE_PATH);
        writer.write(content);
        writer.close();
        System.out.println("Modification completed.");
    }
}
