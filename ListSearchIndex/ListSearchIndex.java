import java.util.ArrayList;
import java.util.List;

public class ListSearchIndex {
    public static Integer findLastIndex(List<Integer> list, Integer value) {
        return list.lastIndexOf(value);
    }
    public static Integer findFirstIndex(List<Integer> list, Integer value) {
        return list.indexOf(value);
    }
    public static List<Integer> findAllIndexes(List<Integer> list, Integer value) {
        List<Integer> indexes = new ArrayList<>();
        if (list == null){
            return indexes;
        }
        for (int i = 0; i < list.size(); i++){
            if (value.equals(list.get(i))){
                indexes.add(i);
            }
        }
        return indexes;
    }
}