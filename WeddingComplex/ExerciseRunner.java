import java.util.List;
import java.util.Map;

public class ExerciseRunner {

    public static void main(String[] args) {
        System.out.println(WeddingComplex.createBestCouple(
                Map.of("Naruto", List.of("breez3", "Hinata"), "hib3rnation", List.of("breez3", "Hinata")),
                Map.of("breez3", List.of("hib3rnation", "Naruto"), "Hinata", List.of("Naruto", "hib3rnation"))));
                
                
    }
}