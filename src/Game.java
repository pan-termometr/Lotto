import java.util.ArrayList;
import java.util.List;

public class Game {
    public static void main(String[] args) {
        List<Integer> userNumbers = new ArrayList<>();
        List<Integer> lottoNumbers = new ArrayList<>();
        FileMethods fileMethods = new FileMethods();

        boolean exit = false;
        do {
        Menu.printOption();
            switch (Menu.getUserChoice()) {
                case 1:
                    userNumbers = Menu.getNumbers();
                    break;
                case 2:
                    lottoNumbers = LottoNumbers.chooseSix();
                    fileMethods.saveToFile(lottoNumbers);
                    LottoNumbers.showMustGoOn();
                    break;
                case 3:
                    System.out.println("Twoje liczby: " + userNumbers);
                    LottoNumbers.stopProgram(3000);
                    System.out.println("Wylosowane liczby: " + lottoNumbers);
                    LottoNumbers.stopProgram(3000);
                    Menu.showResults(userNumbers, lottoNumbers);
                    LottoNumbers.stopProgram(3000);
                    break;
                case 4:
                    fileMethods.printHistory();
                    LottoNumbers.stopProgram(3000);
                    break;
                case 5:
                    fileMethods.deleteHistory();
                    LottoNumbers.stopProgram(3000);
                    break;
                case 6:
                    RealLotto.realLottoMenu();
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    System.out.println("Wybrano niewłaściwą opcję");
                    LottoNumbers.stopProgram(3000);
            }
        } while (!exit);
    }
}