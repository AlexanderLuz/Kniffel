public enum SheetCategories {
    ONES("Einser", new int[] {1}, 0),
    TWOS("Zweier", new int[] {2}, 1),
    THREES("Dreier", new int[] {3}, 2),
    FOURS("Vierer", new int[] {4}, 3),
    FIVES("Fünfer", new int[] {5}, 4),
    SIXES("Sechser", new int[] {6}, 5),
    TOTAL_UPPER_PART("Gesamt", new int[] {}, 6),
    BONUS("Bonus bei 63 oder mehr", new int[] {0, 35}, 7),
    TOTAL_UPPER_PART_WITH_BONUS("Gesamt mit Bonus", new int[] {}, 8),
    THREE_OF_A_KIND("Dreierpasch", new int[] {1, 2, 3, 4, 5, 6}, 9),
    FOUR_OF_A_KIND("Viererpasch", new int[] {1, 2, 3, 4, 5, 6}, 10),
    FULL_HOUSE("Full-House", new int[] {1, 2, 3, 4, 5, 6}, 11),
    SMALL_STRAIGHT("Kleine Strasse", new int[] {1, 2, 3, 4, 5, 6}, 12),
    LARGE_STRAIGHT("Grosse Strasse", new int[] {1, 2, 3, 4, 5, 6}, 13),
    KNIFFEL("Kniffel", new int[] {1, 2, 3, 4, 5, 6}, 14),
    CHANCE("Chance", new int[] {1, 2, 3, 4, 5, 6}, 15),
    TOTAL_LOWER_PART("Gesamt unterer Teil", new int[] {}, 16),
    TOTAL("Endsumme", new int[] {}, 17);

    private final String CATEGORY_NAME;
    private final int[] DICE_IT_CAN_STORE;
    private final int INDEX;

    SheetCategories(String CATEGORY_NAME, int[] DICE_IT_CAN_STORE, int INDEX) {
        this.CATEGORY_NAME = CATEGORY_NAME;
        this.DICE_IT_CAN_STORE = DICE_IT_CAN_STORE;
        this.INDEX = INDEX;
    }

    public String getName() {
        return CATEGORY_NAME;
    }
    public int[] getDiceItCanStore() {
        return DICE_IT_CAN_STORE;
    }
    public int getIndex() {
        return INDEX;
    }
}
