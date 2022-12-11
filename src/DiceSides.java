public enum DiceSides {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6);

    private final int VALUE;

    DiceSides(int VALUE) {
        this.VALUE = VALUE;
    }

    public int getValue() {
        return VALUE;
    }

    public String printDiceSide() {
        String s = "";
        switch (VALUE) {
            case 1 -> s = "⚀";
            case 2 -> s = "⚁";
            case 3 -> s = "⚂";
            case 4 -> s = "⚃";
            case 5 -> s = "⚄";
            case 6 -> s = "⚅";
            default -> s = "Error";
        }
        return s;
    }
}
