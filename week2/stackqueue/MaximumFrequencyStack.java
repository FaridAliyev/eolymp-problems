package solutions.week2.stackqueue;

import java.util.*;

public class MaximumFrequencyStack {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Integer> map = new HashMap<>();
        List<Stack<Integer>> list = new ArrayList<>();

        while (scanner.hasNext()) {
            String command = scanner.next();
            switch (command) {
                case "push" -> {
                    int num = scanner.nextInt();
                    int occurrenceCount = map.getOrDefault(num, 0);
                    if (occurrenceCount >= list.size()) {
                        Stack<Integer> stack = new Stack<>();
                        list.add(stack);
                    }
                    list.get(occurrenceCount).push(num);
                    map.put(num, occurrenceCount + 1);
                }
                case "pop" -> {
                    Stack<Integer> lastStack = list.get(list.size() - 1);
                    int popped = lastStack.pop();
                    System.out.println(popped);
                    if (lastStack.isEmpty()) {
                        list.remove(list.size() - 1);
                    }
                    map.put(popped, map.get(popped) - 1);
                }
            }
        }
    }
}
