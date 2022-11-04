import java.util.Collections;
import java.util.HashMap;

public class PointSheet {
    public final SheetCategories[] sheetCategories = SheetCategories.values();

    public HashMap<SheetCategories, Integer> playerPointSheet = new HashMap<SheetCategories, Integer>();

    {
        for(SheetCategories category:sheetCategories) {
            playerPointSheet.put(category, 0);
        }
    }
}
