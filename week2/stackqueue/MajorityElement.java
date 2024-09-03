package solutions.week2.stackqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class MajorityElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }
        System.out.println(solve(list));
    }

    public static int solve(List<Integer> list) {
        Stack<Integer> stack = new Stack<>();
        for (Integer i :
                list) {
            if (stack.isEmpty()) stack.push(i);
            else {
                if (stack.peek().equals(i)) {
                    stack.push(i);
                } else {
                    stack.pop();
                }
            }
        }
        if(stack.isEmpty()) return -1;
        Integer majorityElement = stack.peek();
        int count = 0;
        for (Integer i :
                list) {
            if (i.equals(majorityElement)) count++;
        }
        return count > list.size() / 2 ? majorityElement : -1;
    }
}
