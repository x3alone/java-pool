import java.util.*;

public class WeddingComplex {

    public static Map<String, String> createBestCouple(Map<String, List<String>> first, Map<String, List<String>> second) {
        Set<String> freeMembers = new HashSet<>(first.keySet());
        Map<String, String> matches = new HashMap<>();
        
        Map<String, Map<String, Integer>> secondRanking = new HashMap<>();
        for (Map.Entry<String, List<String>> entry : second.entrySet()) {
            Map<String, Integer> rank = new HashMap<>();
            List<String> prefs = entry.getValue();
            for (int i = 0; i < prefs.size(); i++) {
                rank.put(prefs.get(i), i);
            }
            secondRanking.put(entry.getKey(), rank);
        }

        Map<String, Integer> proposalIndex = new HashMap<>();
        for (String m : first.keySet()) proposalIndex.put(m, 0);

        while (!freeMembers.isEmpty()) {
            Iterator<String> iterator = freeMembers.iterator();
            String proposer = iterator.next();

            List<String> prefs = first.get(proposer);
            int i = proposalIndex.get(proposer);
            String preferred = prefs.get(i);
            proposalIndex.put(proposer, i + 1);

            if (!matches.containsValue(preferred)) {
                matches.put(proposer, preferred);
                freeMembers.remove(proposer);
            } else {
                String current = null;
                for (Map.Entry<String, String> e : matches.entrySet()) {
                    if (e.getValue().equals(preferred)) {
                        current = e.getKey();
                        break;
                    }
                }

                int currentRank = secondRanking.get(preferred).get(current);
                int proposerRank = secondRanking.get(preferred).get(proposer);

                if (proposerRank < currentRank) {
                    matches.remove(current);
                    matches.put(proposer, preferred);
                    freeMembers.remove(proposer);
                    freeMembers.add(current);
                }
            }
        }

        return matches;
    }
}
