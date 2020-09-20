import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {

    static List<Integer> lottoNumbers = new ArrayList<>();

    public static List<Integer> chooseSix() {
        // Ciekawy sposób. Takim podstawowym sposobem na losowanie liczby z zakresu 1-49 jest:
        // ThreadLocalRandom.current().nextInt(0, 50)
        List<Integer> lottoNumbers =
                IntStream.range(1, 49)
                        .boxed()
                        .collect(Collectors.toList());
        Collections.shuffle(lottoNumbers);
        List<Integer> sixLottoNumbers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            sixLottoNumbers.add(lottoNumbers.get(i));
        }
        LottoNumbers.lottoNumbers = lottoNumbers;
        Collections.sort(sixLottoNumbers);
        return sixLottoNumbers;
    }

    public static void showMustGoOn() {
        System.out.println("Dzień dobry. Witam Ciebie Piotrulo i zapraszam na losowanie Dużego Lotka.");
        stopProgram(3000);
        System.out.println("Nad poprawnym przebiegiem losowania będzie czuwać komisja kontroli gier i zakładów:");
        stopProgram(4000);
        System.out.println("\n(͡° ͜ ͡°)    ¯|_(ツ)_/¯    ┏(‘▀_▀’)ノ\n");
        stopProgram(3000);
        System.out.println("Komora maszyny losującej jest pusta:");
        stopProgram(1500);
        System.out.println("\n[          ]    (1)  (2)  (3)  (4)  (5)  (6)  (7)" +
                           "\n|          |    (8)  (9) (10) (11) (12) (13) (14)" +
                           "\n|          |   (15) (16) (17) (18) (19) (20) (21)" +
                           "\n|          |   (22) (23) (24) (25) (26) (27) (28)" +
                           "\n|          |   (29) (30) (31) (32) (33) (34) (35)" +
                           "\n|          |   (36) (37) (38) (39) (40) (41) (42)" +
                           "\n|__________|   (43) (44) (45) (46) (47) (48) (49)");
        stopProgram(2000);
        System.out.println("\nNastępuje zwolnienie blokady:\n");
        stopProgram(1500);
        System.out.println("[          ]    " +
                         "\n|          |    " +
                         "\n|          |    " +
                         "\n|          |    " +
                         "\n|  ()()()  |    " +
                         "\n|()()()()()|    " +
                         "\n|()()()()()|    ");
        stopProgram(3000);
        System.out.println("\nRozpoczynamy losowanie 6 liczb:\n");
        stopProgram(3000);
        System.out.print("[");
        for (int i = 0; i < 6; i++) {
            if (i < 5) {
                System.out.print("(" + lottoNumbers.get(i) + ")");
                stopProgram(2500);
            } else {
                System.out.print("(" + lottoNumbers.get(i) + ")]");
            }
        }
        stopProgram(3000);
        System.out.println("\n\nDziękujemy za udział w losowaniu. Życzymy dobrej nocy.");
        stopProgram(3000);
    }

    public static void stopProgram(int milis){
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}