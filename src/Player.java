import java.util.Scanner;

public class Player {
    public String name;
    Player(String name) {
        this.name = name;
    }
    public final PointSheet pointSheet = new PointSheet();
    public final DiceSet diceSet = new DiceSet();
    public Scanner scanner = new Scanner(System.in);
    public boolean inputOver = false;
    public boolean turnOver = false;
    public int counter;


}
