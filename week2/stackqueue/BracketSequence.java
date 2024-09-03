package solutions.week2.stackqueue;

import java.util.Scanner;

public class BracketSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(solve(input) ? "YES" : "NO");
    }

    public static boolean solve(String input) {
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            switch (input.charAt(i)) {
                case '(' -> count++;
                case ')' -> {
                    if (count == 0) {
                        return false;
                    }
                    count--;
                }
            }
        }
        return count == 0;
    }
}
