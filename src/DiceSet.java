import java.util.ArrayList;

public class DiceSet {
    public final Dice[] DICES = new Dice[5];
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
    public String printDiceSet() {
        StringBuilder str = new StringBuilder();
        for(Dice dice:DICES) {
            str.append(dice.currentSide.printDiceSide());
        }
        return String.valueOf(str);
    }
}
