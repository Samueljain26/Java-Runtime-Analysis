import java.io.*;

public class FileRead {
    public static void main(String[] args) {
        String filePath = "demo.txt";

        // Using FileReader (Character Stream)
        long startTime = System.nanoTime();
        try (FileReader reader = new FileReader(filePath)) {
            int ch;
            while ((ch = reader.read()) != -1) {
            }
        } catch (IOException e) {
            System.out.println("File not found");
        }
        long endTime = System.nanoTime();
        System.out.println("FileReader Execution Time: " + (endTime - startTime) + " ms");

        // Using InputStreamReader (Byte Stream)
        startTime = System.nanoTime();
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(filePath))) {
            int ch;
            while ((ch = reader.read()) != -1) {
            }
        } catch (IOException e) {
            System.out.println("File not found");
        }
        endTime = System.nanoTime();
        System.out.println("InputStreamReader Execution Time: " + (endTime - startTime) + " ms");
    }
}
/*File not found
FileReader Execution Time: 952700 ms
File not found
InputStreamReader Execution Time: 323800 ms
 */