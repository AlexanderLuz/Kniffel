import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Arrays;

public class Player {
    public String name;
    Player(String name) {
        this.name = name;
    }
    public final PointSheet pointSheet = new PointSheet();
    private final DiceSet diceSet = new DiceSet();
    public Scanner scanner = new Scanner(System.in);
    public boolean inputOver = false;
    public boolean turnOver = false;
    public int counter;
    public void takeTurn() {
        counter = 0;
        diceSet.rollAllDice();
        diceSet.printDiceSet();
        while(counter<3 && !turnOver) {
            if(counter == 0) {
                System.out.println("3 re-rolls remaining:");
            }
            counter += 1;
            ArrayList<Boolean> indexes = getDiceToRoll();
            diceSet.rollSpecifiedDices(indexes);
            switch(counter) {
                case 1 -> System.out.println("2 re-rolls remaining:");
                case 2 -> System.out.println("1 re-rolls remaining:");
                case 3 -> System.out.println("0 re-rolls remaining:");
                default -> System.out.println("3 re-rolls remaining:");
            }
            diceSet.printDiceSet();
        }
    }
    public ArrayList<Boolean> getDiceToRoll() {
        System.out.println();
        int placeholder;
        inputOver = false;
        ArrayList<Boolean> indexes = new ArrayList<>(Arrays.asList(false,false,false,false,false));
        while(indexes.size() == 5 && !inputOver) {
            placeholder = Integer.parseInt(scanner.next());
            if (placeholder<=indexes.size() && placeholder > 0) {
                indexes.set((placeholder-1), true);
            }
            if (placeholder == 6) {
                Collections.replaceAll(indexes, false, true);
            }
            if (placeholder == 0) {
                inputOver = true;
            }
        }
        return indexes;
    }
}
