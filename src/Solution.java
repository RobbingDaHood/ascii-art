import java.util.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        extracted(in);

    }

    public static void extracted(Scanner in) {
        int L = in.nextInt();

        int H = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        String goal = in.nextLine();

        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ?";

        Map<String, List<String>> alphabet = new HashMap<>();

        for (int i = 0; i < H; i++) {
            String line = in.nextLine();
            for (int k = 0; k < letters.length(); k++) {
                String key = letters.substring(k, k+1);
                if (!alphabet.containsKey(key)) {
                    alphabet.put(key, new ArrayList<>());
                }
                alphabet.get(key).add(line.substring(k * L, (k + 1) * L));
            }
        }

        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");
        for (int i = 0; i < H; i++) {
            for (int k = 0; k < goal.length(); k++) {
                List<String> strings = alphabet.get(goal.substring(k, k + 1).toUpperCase());
                if (strings == null) {
                    strings = alphabet.get("?");
                }
                System.out.print(strings.get(i));
            }
            if (i < H-1) {
               System.out.println();
            }
        }

    }
}