import java.io.*;
import java.util.List;

//Ta klasa nie posiada stanu więc powienna być statyczna
public class FileMethods {

    private FileMethods() {
        // W klasie typu "utility" czyli takiej która ma tylko statyczne metody, warto zrobić prywatny konstruktor, tak zeby nikt nie próbował zrobić jej instancji
    }

    //To jest stała, więc konwencja robienia stałych wygląda tak
    private static final String FILE_NAME = "Lotto.txt";

    public static void saveToFile(List<Integer> numbers){
        try (
                var fileWriter = new FileWriter(FILE_NAME, true);
                var writer = new BufferedWriter(fileWriter);
        ) {
            writer.write("\n");
            writer.write(String.valueOf(numbers));
        } catch (IOException e) {
            System.err.println("Nie udało się zapisać pliku " + FILE_NAME);
        }
    }

    public static void printHistory() {
        System.out.println("Historia losowań: ");
        try (
                var fileReader = new FileReader(FILE_NAME);
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

    public static void deleteHistory() {
        try (
                var fileWriter = new FileWriter(FILE_NAME);
                var writer = new BufferedWriter(fileWriter);
        ) {
            writer.write(" ");
        } catch (IOException e) {
            System.err.println("Nie udało się zapisać pliku " + FILE_NAME);
        }
        System.out.println("Usunięto historię losowań");
    }
}