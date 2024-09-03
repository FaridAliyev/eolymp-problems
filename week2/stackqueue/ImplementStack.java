package solutions.week2.stackqueue;

import java.util.Scanner;
import java.util.Stack;

public class ImplementStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int operation = scanner.nextInt();
            switch (operation) {
                case 1 -> {
                    int num = scanner.nextInt();
                    stack.push(num);
                }
                case 2 -> System.out.println(stack.pop());
            }

        }
    }

}
