import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Scanner;

public class RealLotto {

    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public static void realLottoMenu() {
        printOption();
        switch (Menu.getUserChoice()) {
            case 1:
                LocalDate userDate = getDateFromUser();
                boolean lotteryInUserDateExists = printResultsFromThisDate(userDate);
                if (!lotteryInUserDateExists) {

                    System.out.println("W podanym dniu nie odbyło się losowanie");
                    LottoNumbers.stopProgram(2000);
                    boolean closestDateWithLotteryFound;
                    do {
                        closestDateWithLotteryFound = findNextResult(userDate);
                    } while (!closestDateWithLotteryFound);
                }
                break;
            case 2:
                System.out.println("Chuj Cie wie jak to policzyć");
                break;
            case 3:
        }
    }

    private static void printOption() {
        System.out.println("Menu:\n1. Sprawdź wyniki z konkretnego dnia." +
                                "\n2. Sprawdź, które liczby wypadały ile razy." +
                                "\n3. Powrót");
    }

    //Dlaczego nie przechowywac daty podanej przez użytkownika poprostu jako LocalDate ? Rozwiazuje to potem duzo problemów z parsowaniem/dodawaniem dni
    private static LocalDate getDateFromUser() {
        System.out.println("Historia dotyczy gier z zakresu: 27.01.1957 - 17.09.2020.");
        return LocalDate.of(
                getNumberFromUser(1957, 2020, "rok"),
                getNumberFromUser(0, 12, "miesiąc"),
                getNumberFromUser(0, 32, "dzień")
        );
    }

    private static int getNumberFromUser(int intMin, int intMax, String text) {
        Scanner sc = new Scanner(System.in);
        boolean error = true;
        int num;
        do {
            System.out.println("Podaj " + text);
            num = sc.nextInt();
            if (num >= intMin && num <= intMax) {
                error = false;
            } else {
                System.out.println("Podaj właściwy " + text);
            }
        } while(error);
        return num;
    }

    private static String convertNumberToString(int numInt) {
        String num = Integer.toString(numInt);
        if (num.length() == 1) {
            num = "0" + num;
        }
        return num;
    }

    private static String connectStrings(String s1, String s2, String s3){
        String fullDate = s1 + "." + s2 + "." + s3;
        return fullDate;
    }

    private static boolean printResultsFromThisDate(LocalDate userDate) {
        String fileName = "Lotto.txt";
        try (
                var fileReader = new FileReader(fileName);
                var reader = new BufferedReader(fileReader)
        ) {
            String nextLine;
            do {
                while ((nextLine = reader.readLine()) != null) {
                    if (nextLine.contains(userDate.format(DTF))) {
                        System.out.println("Wyniki losowania z wybranego dnia: " + userDate + " to:" +
                                nextLine.substring(nextLine.lastIndexOf(" ")));
                        LottoNumbers.stopProgram(2000);
                        System.out.println("\nByło to " + nextLine.substring(0, nextLine.indexOf(".")) + " losowanie w historii.");
                        LottoNumbers.stopProgram(2000);
                        return true;
                    }
                }
            } while (nextLine != null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean findNextResult(LocalDate fullDate) {
        boolean resultIsFound;
        int i = 1;
        do {
            LocalDate newDate = getNextDate(fullDate, i);
            resultIsFound = printResultFromNextFoundDate(newDate);
            i++;
            } while (!resultIsFound);
        return true;
    }

    private static LocalDate getNextDate(LocalDate userDate, int i) {
        return userDate.plusDays(i);
    }

    private static boolean printResultFromNextFoundDate (LocalDate newDate) {
        //Wiesz że u mnie na kompie nie ma folderu termo :D ? Wystraczy sama nazwa pliku, wtedy zaciąga go z projektowego folderu (najczęściej)
//        String fileName = "C:\\Users\\termo\\Downloads\\Lotto.txt";
        try (
                //Mnie to var strasznie kłuje w oczy. Dynamiczne typowanie to hujowizna.
                var fileReader = new FileReader("Lotto.txt");
                var reader = new BufferedReader(fileReader)
        ) {
            String nextLine;
            // To jest podwójna pętla która sprawdza ten sam warunek
                while ((nextLine = reader.readLine()) != null) {
                    if (nextLine.contains(newDate.format(DTF))) {
                        System.out.println("Najbliższe losowanie odbyło się " + newDate + " i padły w nim następujące liczby:" +
                                nextLine.substring(nextLine.lastIndexOf(" ")));
                        LottoNumbers.stopProgram(2000);
                        System.out.println("Było to " + nextLine.substring(0, nextLine.indexOf(".")) + " losowanie w historii.");
                        LottoNumbers.stopProgram(3000);
                        return true;
                    }
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}