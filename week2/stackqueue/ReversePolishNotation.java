package solutions.week2.stackqueue;

import java.util.Scanner;
import java.util.Stack;

public class ReversePolishNotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        while (scanner.hasNext()) {
            String input = scanner.next();
            switch (input) {
                case "*" -> stack.push(stack.pop() * stack.pop());
                case "+" -> stack.push(stack.pop() + stack.pop());
                case "/" -> {
                    int secondNum = stack.pop();
                    int firstNum = stack.pop();
                    stack.push(firstNum / secondNum);
                }
                case "-" -> {
                    int secondNum = stack.pop();
                    int firstNum = stack.pop();
                    stack.push(firstNum - secondNum);
                }
                default -> stack.push(Integer.parseInt(input));
            }
        }
        System.out.println(stack.peek());
    }
}
