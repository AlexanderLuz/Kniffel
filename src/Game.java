import java.util.*;

public class Game {
    Scanner scanner = new Scanner(System.in);
    int playerCount;
    String playerName;
    public final SheetCategories[] sheetCategories = SheetCategories.values();
    ArrayList<Player> playerList = new ArrayList<Player>();
    public void PlayGame(){
        SetNumberOfPlayers();
        InstantiatePlayers();
        PrintPlayerList();
        clearScreen();
        for(int i = 0; i<13; i++) {
            System.out.println();
            System.out.println("Round "+(i+1));
            printFiller("-");
            for(Player player: playerList) {
                takeTurn(player);
            }
        }
    }

    private void PrintPlayerList() {
        for(Player player: playerList) {
            System.out.println(player.name);
        }
    }

    private void InstantiatePlayers() {
        for (int i = 0; i<playerCount; i++){
            playerName = GetPlayerName();
            Player player = new Player(playerName);
            playerList.add(player);
        }
    }

    private String GetPlayerName() {
        System.out.println("Whats your name?");
        return scanner.nextLine();
    }

    private void SetNumberOfPlayers() {
        System.out.println("How many players are going to play?");
        playerCount = scanner.nextInt();
        scanner.nextLine();
    }
    public void takeTurn(Player player) {
        player.counter = 0;
        player.diceSet.rollAllDice();
        player.diceSet.printDiceSet();
        while(player.counter<2 && !player.turnOver) {
            if(player.counter == 0) {
                System.out.println("2 re-rolls remaining:");
            }
            player.counter += 1;
            ArrayList<Boolean> indexes = getDiceToRoll(player);
            player.diceSet.rollSpecifiedDices(indexes);
            switch(player.counter) {
                case 1 -> System.out.println("1 re-rolls remaining:");
                case 2 -> System.out.println("0 re-rolls remaining:");
                default -> System.out.println("3 re-rolls remaining:");
            }
            player.diceSet.printDiceSet();
        }
        printPointSheet(player);
        HashMap<SheetCategories, Integer> choice = checkPointSheetOptions(player);
        fillPointSheet(player, choice);
        printPointSheet(player);
    }
    public ArrayList<Boolean> getDiceToRoll(Player player) {
        System.out.println();
        int placeholder;
        player.inputOver = false;
        ArrayList<Boolean> indexes = new ArrayList<>(Arrays.asList(false,false,false,false,false));
        while(indexes.size() == 5 && !player.inputOver) {
            placeholder = Integer.parseInt(scanner.next());
            if (placeholder<=indexes.size() && placeholder > 0) {
                indexes.set((placeholder-1), true);
            }
            if (placeholder == 6) {
                Collections.replaceAll(indexes, false, true);
            }
            if (placeholder == 0) {
                player.inputOver = true;
            }
        }
        return indexes;
    }
    public void printFiller(String s) {
        System.out.println();
        for(int i = 0; i<50; i++) {
            System.out.print(s);
        }
        System.out.println();
    }
    public void clearScreen() {
        for(int i= 0; i<30; i++) {
            System.out.println();
        }
    }
    public void printPointSheet(Player player) {
        for(SheetCategories category:player.pointSheet.sheetCategories) {
            System.out.println();
            System.out.printf("%25s",category.getName());
            System.out.print("|");
            System.out.printf("%8s", player.pointSheet.playerPointSheet.get(category));
            System.out.print("| Index: "+category.getIndex());
            if(category == player.pointSheet.sheetCategories[8] || category == player.pointSheet.sheetCategories[15]) {
                System.out.println();
                printFiller("-");
            }
        }
    }
    public HashMap<SheetCategories, Integer> checkPointSheetOptions(Player player) {
        int[] takenCategories = new int[18];
        for(int l = 0; l<takenCategories.length; l++) {
            for(Map.Entry<SheetCategories, Integer> entry : player.pointSheet.playerPointSheet.entrySet()) {
                int key = entry.getKey().getIndex();
                int value = entry.getValue();
                if (key == l && value != 0) {
                    takenCategories[l] = 1;
                    break;
                }
            }
        }

        HashMap<Integer, Integer> possibleIndexValues = new HashMap<Integer, Integer>();

        Integer[] values = new Integer[5];
        for(int i = 0; i<values.length; i++) {
            values[i] = player.diceSet.DICES[i].currentSide.getValue();

        }

        Arrays.sort(values, Collections.reverseOrder());

        int combinedValue = 0;
        for(int value:values) {
            combinedValue += value;
        }

        for(int j:values) {
            if(possibleIndexValues.containsKey((j-1))) {
                possibleIndexValues.put((j-1), possibleIndexValues.get((j-1))+j);
            }
            if(!possibleIndexValues.containsKey((j-1)) && takenCategories[(j-1)] == 0) {
                possibleIndexValues.put((j-1), j);
            }
        }

        if(values[0] == values[1] && values[0] == values[2] && values[0] == values[3] && values[0] == values[4] && takenCategories[(SheetCategories.KNIFFEL.getIndex())] == 0) {
            possibleIndexValues.put(SheetCategories.KNIFFEL.getIndex(), SheetCategories.KNIFFEL.getPointValue());
        }

        if(takenCategories[(SheetCategories.SMALL_STRAIGHT.getIndex())] == 0 || takenCategories[(SheetCategories.LARGE_STRAIGHT.getIndex())] == 0) {
            for (int p = 0; p < 3; p++) {
                if (values[p] == 4 || values[p] == 5 || values[p] == 6) {
                    if (values[p] == 4 && Arrays.asList(values).contains(3) && Arrays.asList(values).contains(2) && Arrays.asList(values).contains(1) && takenCategories[(SheetCategories.SMALL_STRAIGHT.getIndex())] == 0) {
                        possibleIndexValues.put(SheetCategories.SMALL_STRAIGHT.getIndex(), SheetCategories.SMALL_STRAIGHT.getPointValue());
                        break;
                    }
                    if (values[p] == 5) {
                        if (Arrays.asList(values).contains(4) && Arrays.asList(values).contains(3) && (Arrays.asList(values).contains(2) || Arrays.asList(values).contains(6))) {
                            if(takenCategories[(SheetCategories.SMALL_STRAIGHT.getIndex())] == 0) {
                                possibleIndexValues.put(SheetCategories.SMALL_STRAIGHT.getIndex(), SheetCategories.SMALL_STRAIGHT.getPointValue());
                            }
                            if (((Arrays.asList(values).contains(6) && Arrays.asList(values).contains(2)) || (Arrays.asList(values).contains(1) && Arrays.asList(values).contains(2))) && takenCategories[SheetCategories.LARGE_STRAIGHT.getIndex()] == 0) {
                                possibleIndexValues.put(SheetCategories.LARGE_STRAIGHT.getIndex(), SheetCategories.LARGE_STRAIGHT.getPointValue());
                            }
                        }
                    }
                    if (values[p] == 6) {
                        if (Arrays.asList(values).contains(5) && Arrays.asList(values).contains(4) && Arrays.asList(values).contains(3)) {
                            if(takenCategories[(SheetCategories.SMALL_STRAIGHT.getIndex())] == 0) {
                                possibleIndexValues.put(SheetCategories.SMALL_STRAIGHT.getIndex(), SheetCategories.SMALL_STRAIGHT.getPointValue());
                            }
                            if (Arrays.asList(values).contains(2) && takenCategories[(SheetCategories.LARGE_STRAIGHT.getIndex())] == 0) {
                                possibleIndexValues.put(SheetCategories.LARGE_STRAIGHT.getIndex(), SheetCategories.LARGE_STRAIGHT.getPointValue());
                                break;
                            }
                        }
                    }
                }
            }
        }

        if((takenCategories[9] == 0 || takenCategories[10] == 0 || takenCategories[11] == 0) && diffValues(values) < 4) {
            int[] placeholderMax = new int[2];
            int[] placeholderMid = new int[2];
            int[] placeholderMin = new int[2];
            placeholderMin[0] = values[4];
            placeholderMax[0] = values[0];
            placeholderMin[1] = countOccurrences(values, 5, placeholderMin[0]);
            placeholderMax[1] = countOccurrences(values, 5, placeholderMax[0]);
            for(int i:values) {
                if(i != placeholderMax[0] && i != placeholderMin[0]) {
                    placeholderMid[0] = i;
                    placeholderMid[1] += 1;
                }
            }
            if((placeholderMid[1] > 2 || placeholderMin[1] > 2 || placeholderMax[1] > 2) && takenCategories[(SheetCategories.THREE_OF_A_KIND.getIndex())] == 0) {
                possibleIndexValues.put(SheetCategories.THREE_OF_A_KIND.getIndex(), combinedValue);
            }
            if(diffValues(values) < 3) {
                if((placeholderMax[1] > 3 || placeholderMin[1] > 3) && takenCategories[(SheetCategories.FOUR_OF_A_KIND.getIndex())] == 0) {
                    possibleIndexValues.put(SheetCategories.FOUR_OF_A_KIND.getIndex(), combinedValue);
                }
                if((placeholderMin[1] == 3 || placeholderMax[1] == 3) && takenCategories[(SheetCategories.FULL_HOUSE.getIndex())] == 0) {
                    possibleIndexValues.put(SheetCategories.FULL_HOUSE.getIndex(), SheetCategories.FULL_HOUSE.getPointValue());
                }
                if(takenCategories[(SheetCategories.THREE_OF_A_KIND.getIndex())] == 0) {
                    possibleIndexValues.put(SheetCategories.THREE_OF_A_KIND.getIndex(), combinedValue);
                }
            }
        }

        if(takenCategories[(SheetCategories.CHANCE.getIndex())] == 0) {
            possibleIndexValues.put(SheetCategories.CHANCE.getIndex(), combinedValue);
        }

        System.out.println();
        for (Integer index : possibleIndexValues.keySet()) {
            int variableKey = index;
            int variableValue = possibleIndexValues.get(index);

            System.out.println("Index: " + variableKey+ " / " + SheetCategories.getCategory(index).getName());
            System.out.println("Value: " + variableValue);
            printFiller("-");
        }
        HashMap<SheetCategories, Integer> chosenCategory = new HashMap<SheetCategories, Integer>();
        if(possibleIndexValues.isEmpty()) {
            System.out.println("You cannot fill any category!!!");
            return chosenCategory;
        }
        System.out.println("Which Category do you want to fill: ");
        int choice = scanner.nextInt();

        chosenCategory.put(SheetCategories.getCategory(choice), possibleIndexValues.get(choice));
        return chosenCategory;
    }
    public void fillPointSheet(Player player, HashMap<SheetCategories, Integer> choice) {
        if(!choice.isEmpty()) {
            player.pointSheet.playerPointSheet.put(choice.keySet().iterator().next(), choice.get(choice.keySet().iterator().next()));
        }
        int totalUpperPart = 0;
        int bonus = 0;
        int totalUpperPartWithBonus = 0;
        int totalLowerPart = 0;
        int total = 0;
        for(int i = 0; i<6; i++) {
            totalUpperPart += player.pointSheet.playerPointSheet.get(sheetCategories[i]);
        }
        totalUpperPartWithBonus = totalUpperPart;
        if(totalUpperPart > 62) {
            totalUpperPartWithBonus += sheetCategories[7].getPointValue();
            bonus = 1;
        }
        for(int j = 9; j<16; j++) {
            totalLowerPart += player.pointSheet.playerPointSheet.get(sheetCategories[j]);
        }
        total = totalLowerPart + totalUpperPartWithBonus;

        player.pointSheet.playerPointSheet.put(SheetCategories.TOTAL_UPPER_PART, totalUpperPart);
        player.pointSheet.playerPointSheet.put(SheetCategories.BONUS, bonus);
        player.pointSheet.playerPointSheet.put(SheetCategories.TOTAL_UPPER_PART_WITH_BONUS, totalUpperPartWithBonus);
        player.pointSheet.playerPointSheet.put(SheetCategories.TOTAL_LOWER_PART, totalLowerPart);
        player.pointSheet.playerPointSheet.put(SheetCategories.TOTAL, total);
    }
    public static int diffValues(Integer[] numArray){
        int numOfDifferentVals = 0;

        ArrayList<Integer> diffNum = new ArrayList<>();

        for(int i=0; i<numArray.length; i++){
            if(!diffNum.contains(numArray[i])){
                diffNum.add(numArray[i]);
            }
        }

        if(diffNum.size()==1){
            numOfDifferentVals = 0;
        }
        else{
            numOfDifferentVals = diffNum.size();
        }

        return numOfDifferentVals;
    }
    static int countOccurrences(Integer[] arr, int n, int x)
    {
        int res = 0;
        for (int i=0; i<n; i++)
            if (x == arr[i])
                res++;
        return res;
    }
}