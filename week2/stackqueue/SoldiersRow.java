package solutions.week2.stackqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class SoldiersRow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> heights = new ArrayList<>();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            heights.add(scanner.nextInt());
        }
        printList(solve(heights));
    }

    public static List<Integer> solve(List<Integer> heights) {
        List<Integer> visibility = new ArrayList<>();
        Stack<Pair> stack = new Stack<>();
        for (int i = 0; i < heights.size(); i++) {
            Integer current = heights.get(i);
            if (stack.isEmpty()) {
                stack.push(new Pair(current, i));
                visibility.add(-1);
            } else {
                while (!stack.isEmpty() && stack.peek().value <= current) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    stack.push(new Pair(current, i));
                    visibility.add(-1);
                } else {
                    visibility.add(stack.peek().position);
                    stack.push(new Pair(current, i));
                }
            }
        }
        return visibility;
    }

    public static void printList(List<Integer> list) {
        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }

    private record Pair(int value, int position) {

    }

}
