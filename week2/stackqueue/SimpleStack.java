package solutions.week2.stackqueue;

import java.util.Scanner;
import java.util.Stack;

public class SimpleStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        loop: while (scanner.hasNext()) {
            String command = scanner.next();
            switch (command) {
                case "push" -> {
                    int num = scanner.nextInt();
                    stack.push(num);
                    System.out.println("ok");
                }
                case "pop" -> System.out.println(stack.pop());
                case "back" -> System.out.println(stack.peek());
                case "size" -> System.out.println(stack.size());
                case "clear" -> {
                    stack.clear();
                    System.out.println("ok");
                }
                default -> {
                    System.out.println("bye");
                    break loop;
                }
            }
        }
    }
}
