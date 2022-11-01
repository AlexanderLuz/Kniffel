import java.util.Random;

public class Dice {
    private final DiceSides[] SIDES = DiceSides.values();
    public DiceSides currentSide;
    public String diceName;
    private final Random random = new Random();
    public void rollDice() {
        currentSide = SIDES[random.nextInt(6)];
    }
    public void setData(String diceNumber) {
        this.diceName = "dice"+diceNumber;
    }
}
