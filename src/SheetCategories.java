public enum SheetCategories {
    ONES("Einser", 0, 0),
    TWOS("Zweier", 0, 1),
    THREES("Dreier", 0, 2),
    FOURS("Vierer", 0, 3),
    FIVES("Fünfer", 0, 4),
    SIXES("Sechser", 0, 5),
    TOTAL_UPPER_PART("Gesamt", 0, 6),
    BONUS("Bonus bei 63 oder mehr", 35, 7),
    TOTAL_UPPER_PART_WITH_BONUS("Gesamt mit Bonus", 0, 8),
    THREE_OF_A_KIND("Dreierpasch", 0, 9),
    FOUR_OF_A_KIND("Viererpasch", 0, 10),
    FULL_HOUSE("Full-House", 25, 11),
    SMALL_STRAIGHT("Kleine Strasse", 30, 12),
    LARGE_STRAIGHT("Grosse Strasse", 40, 13),
    KNIFFEL("Kniffel", 50, 14),
    CHANCE("Chance", 0, 15),
    TOTAL_LOWER_PART("Gesamt unterer Teil", 0, 16),
    TOTAL("Endsumme", 0, 17);

    private final String CATEGORY_NAME;
    private final int POINT_VALUE;
    private final int INDEX;

    SheetCategories(String CATEGORY_NAME, int POINT_VALUE, int INDEX) {
        this.CATEGORY_NAME = CATEGORY_NAME;
        this.POINT_VALUE = POINT_VALUE;
        this.INDEX = INDEX;
    }

    public String getName() {
        return CATEGORY_NAME;
    }
    public int getPointValue() {
        return POINT_VALUE;
    }
    public int getIndex() {
        return INDEX;
    }
    public static SheetCategories getCategory(int i) {
        switch (i) {
            case 0 -> {
                return ONES;
            }
            case 1 -> {
                return TWOS;
            }
            case 2 -> {
                return THREES;
            }
            case 3 -> {
                return FOURS;
            }
            case 4 -> {
                return FIVES;
            }
            case 5 -> {
                return SIXES;
            }
            case 9 -> {
                return THREE_OF_A_KIND;
            }
            case 10 -> {
                return FOUR_OF_A_KIND;
            }
            case 11 -> {
                return FULL_HOUSE;
            }
            case 12 -> {
                return SMALL_STRAIGHT;
            }
            case 13 -> {
                return LARGE_STRAIGHT;
            }
            case 14 -> {
                return KNIFFEL;
            }
            case 15 -> {
                return CHANCE;
            }
            default -> {
                return TOTAL;
            }
        }
    }
}
