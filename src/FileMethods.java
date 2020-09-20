import java.io.*;
import java.util.List;

public class FileMethods {
    String fileName = "lottoHistory";

    public void saveToFile(List<Integer> numbers){
        try (
                var fileWriter = new FileWriter(fileName, true);
                var writer = new BufferedWriter(fileWriter);
        ) {
            writer.write("\n");
            writer.write(String.valueOf(numbers));
        } catch (IOException e) {
            System.err.println("Nie udało się zapisać pliku " + fileName);
        }
    }

    public void printHistory() {
        System.out.println("Historia losowań: ");
        try (
                var fileReader = new FileReader(fileName);
                var reader = new BufferedReader(fileReader);
        ) {
            String nextLine;
            while ((nextLine = reader.readLine()) != null) {
                System.out.println(nextLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteHistory() {
        try (
                var fileWriter = new FileWriter(fileName);
                var writer = new BufferedWriter(fileWriter);
        ) {
            writer.write(" ");
        } catch (IOException e) {
            System.err.println("Nie udało się zapisać pliku " + fileName);
        }
        System.out.println("Usunięto historię losowań");
    }
}