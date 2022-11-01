public class PointSheet {
    private final SheetCategories[] sheetCategories = SheetCategories.values();
    public int[] sheetValues = new int[18];

    public void printPointSheet() {
        for(int i = 0; i<sheetCategories.length; i++) {
            System.out.println();
            System.out.printf("%25s",sheetCategories[i].getName());
            System.out.print("|");
            System.out.printf("%8s", sheetValues[i]);
            if(i == 8 || i == 15) {
                System.out.println();
                System.out.print(String.format("%33s", "-").replace(' ', '-'));
            }
        }
    }
}
