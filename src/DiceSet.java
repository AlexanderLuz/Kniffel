import java.util.ArrayList;

public class DiceSet {
    private final Dice[] DICES = new Dice[5];
    {
        for(int i = 0; i<DICES.length; i++) {
            DICES[i] = new Dice();
            DICES[i].setData(Integer.toString(i));
        }
    }
    public void rollAllDice() {
        for(Dice dice:DICES) {
            dice.rollDice();
        }
    }
    public void rollSpecifiedDices(ArrayList<Boolean> diceToBeRolled) {
        for(int i = 0; i<diceToBeRolled.size(); i++) {
            if(diceToBeRolled.get(i)) {
                DICES[i].rollDice();
            }
        }
    }
    public void printDiceSet() {
        System.out.println();
        for(Dice dice:DICES) {
            dice.currentSide.printDiceSide();
        }
        System.out.println();
        for(Dice dice:DICES) {
            System.out.print(dice.currentSide.getValue());
        }
        System.out.println();
    }
}
