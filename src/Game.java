import java.util.ArrayList;
import java.util.List;

public class Game {
    public static final int WAIT_TIME = 3000;

    public static void main(String[] args) {
        List<Integer> userNumbers = new ArrayList<>();
        List<Integer> lottoNumbers = new ArrayList<>();


        boolean exit = false;
        do {
        Menu.printOption();
            switch (Menu.getUserChoice()) {
                case 1:
                    userNumbers = Menu.getNumbers();
                    break;
                case 2:
                    lottoNumbers = LottoNumbers.chooseSix();
                    FileMethods.saveToFile(lottoNumbers);
                    LottoNumbers.showMustGoOn();
                    break;
                case 3:
                    System.out.println("Twoje liczby: " + userNumbers);
                    // Tak powinienes zaimplementować to czekanie w aplikacji. To fajny motyw, ale przy testowaniu koszmarny :P Gdybyś dodał wszędzie ta zmienną
                    // zamiast 3000 z ręki, jedną zmianą mógłbyś właczać/wyłacząc czekanie :)
                    LottoNumbers.stopProgram(WAIT_TIME);
                    System.out.println("Wylosowane liczby: " + lottoNumbers);
                    LottoNumbers.stopProgram(3000);
                    Menu.showResults(userNumbers, lottoNumbers);
                    LottoNumbers.stopProgram(3000);
                    break;
                case 4:
                    FileMethods.printHistory();
                    LottoNumbers.stopProgram(3000);
                    break;
                case 5:
                    FileMethods.deleteHistory();
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