import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class SortList {

    public static List<Integer> sort(List<Integer> list) {
        List<Integer> sortedList = new ArrayList<>(list); 
        Collections.sort(sortedList);
        return sortedList;
    }

    public static List<Integer> sortReverse(List<Integer> list) {
        List<Integer> sortedList = new ArrayList<>(list); 
        Collections.sort(sortedList, Collections.reverseOrder());
        return sortedList;
    }
}
