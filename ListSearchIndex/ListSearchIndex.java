import java.util.ArrayList;
import java.util.List;

public class ListSearchIndex {
    public static Integer findLastIndex(List<Integer> list, Integer value) {
        if (list == null){
            return null;
        }
        int edx = list.lastIndexOf(value);
        if (edx >= 0){
        return edx;
        }else {
            return null;
        }
    }
    public static Integer findFirstIndex(List<Integer> list, Integer value) {
        if (list == null){
            return null;
        }
        int edx = list.indexOf(value);
        if (edx >= 0){
        return edx;
        }else {
            return null;
        }
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