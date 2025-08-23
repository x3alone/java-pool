import java.util.*;

public class KeepTheChange {
    public static List<Integer> computeChange(int amount, Set<Integer> coins) {
        List<Integer> sortedCoins = new ArrayList<>(coins);
        sortedCoins.sort(Collections.reverseOrder());

        List<Integer> result = new ArrayList<>();

        for (int coin : sortedCoins) {
            while (amount >= coin) {
                amount -= coin;
                result.add(coin);
            }
        }
        return result;
    }
}
