public class DoOp {
    public static String operate(String[] args) {
        if (args == null || args.length < 3) {
            return "it depend on the input.";
        }

        int first = Integer.parseInt(args[0]);
        int sec = Integer.parseInt(args[2]);
        String sign = args[1];

        if (sign.equals("+")) {
            return String.valueOf(first + sec);
        }
        if (sign.equals("x")) {
            return String.valueOf(first * sec);
        }
        if (sign.equals("-")) {
            return String.valueOf(first - sec);
        }
        if (sign.equals("%")) {
            if (sec == 0) return "Error";
            return String.valueOf(first % sec);
        }
        if (sign.equals("/")) {
            if (sec == 0) return "Error";
            return String.valueOf(first / sec);
        }

        return "Invalid operation";
    }
}
