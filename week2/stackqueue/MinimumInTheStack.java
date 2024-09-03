package solutions.week2.stackqueue;

import java.util.Scanner;
import java.util.Stack;

public class MinimumInTheStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int command = scanner.nextInt();
            switch (command) {
                case 1 -> {
                    int num = scanner.nextInt();
                    if (stack.isEmpty()) stack.push(num);
                    else stack.push(stack.peek() < num ? stack.peek() : num);
                }
                case 2 -> stack.pop();
                case 3 -> System.out.println(stack.peek());
            }
        }
    }
}
