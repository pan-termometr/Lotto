import java.util.*;

public class Menu {
    public static void printOption() {
        System.out.println("Menu:\n1. Obstaw liczby." +
                                "\n2. Przeprowadź losowanie." +
                                "\n3. Sprawdź wyniki" +
                                "\n4. Pokaż historię losowań tej gry" +
                                "\n5. Usuń historię losowań tej gry" +
                                "\n6. Prawdziwa historia losowań Lotto" +
                                "\n7. Wyjście.");
    }

    public static int getUserChoice() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static ArrayList<Integer> getNumbersFromUser() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj 6 liczb od 1 do 49 (oddziel je spacjami)");
        String userNumbersToSplit = sc.nextLine();
        List<String> userNumbers = Arrays.asList(userNumbersToSplit.split(" "));
        ArrayList<Integer> userNumbersAsIntegers = new ArrayList<>(6);
        for (String s : userNumbers) userNumbersAsIntegers.add(Integer.valueOf(s));
        Collections.sort(userNumbersAsIntegers);
        System.out.println("Dziękujemy za podanie 6 liczb");
        LottoNumbers.stopProgram(3000);
        return userNumbersAsIntegers;
    }

    public static void printOptionToChooseNumbers() {
        System.out.println("Menu:\n1. Wybieram liczby sam." +
                                "\n2. Chybił trafił.");
    }

    public static List<Integer> getRandomNumbers() {
        System.out.println("Liczby na chybił trafił zostały wybrane.");
        LottoNumbers.stopProgram(3000);
        return LottoNumbers.chooseSix();
    }

    public static List<Integer> getNumbers() {
        List<Integer> choosenNumbers = new ArrayList<>();
        printOptionToChooseNumbers();
        switch (getUserChoice()) {
            case 1:
                choosenNumbers = getNumbersFromUser();
                break;
            case 2:
                choosenNumbers = getRandomNumbers();
                break;
            default:
                System.out.println("Wybrano niewłaściwą opcję");
        }
        return choosenNumbers;
    }

    public static void showResults(List lottoNumbers, List userNumbers) {
        try {
            int j = 0;
            for (Object tmp : userNumbers) {
                for (int i = 0; i < 6; i++) {
                    if (tmp == lottoNumbers.get(i)) {
                        j++;
                    }
                }
            }
            System.out.println("Trafiłeś " + j + " liczb");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Obstaw najpierw liczby!");
        }
    }
}
