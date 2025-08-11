public class Chifoumi {
    public static ChifoumiAction getActionBeatenBy(ChifoumiAction chifoumiAction) {
        return switch (chifoumiAction) {
            case ROCK -> chifoumiAction.SCISSOR;
            case PAPER -> chifoumiAction.ROCK;
            case SCISSOR -> chifoumiAction.PAPER;
        };
    }
}