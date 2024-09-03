package solutions.week2.stackqueue;

import java.util.*;

public class ParenthesesBalance {
    private static final Map<Character, Character> pairs = Map.of(
            '(', ')',
            '[', ']'
    );
    private static final Set<Character> close = new HashSet<>(pairs.values());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            System.out.println(isValid(line) ? "Yes" : "No");
        }
    }

    public static boolean bracketCorresponds(char close, char open) {
        return pairs.containsKey(open)
                && pairs.get(open) == close;
    }

    public static boolean isValid(String line) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (pairs.containsKey(c))
                stack.push(c);
            else if (close.contains(c)) {
                if (stack.isEmpty()) return false;
                char saved = stack.pop();
                if (!bracketCorresponds(c, saved)) return false;
            }
        }
        return stack.isEmpty();
    }

}
