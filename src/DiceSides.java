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

    public void printDiceSide() {
        switch (VALUE) {
            case 1 -> System.out.print("⚀");
            case 2 -> System.out.print("⚁");
            case 3 -> System.out.print("⚂");
            case 4 -> System.out.print("⚃");
            case 5 -> System.out.print("⚄");
            case 6 -> System.out.print("⚅");
            default -> System.out.println("Error");
        }
    }
}
