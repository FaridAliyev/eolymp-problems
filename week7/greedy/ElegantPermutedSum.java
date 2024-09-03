package solutions.week7.greedy;

import java.util.*;

public class ElegantPermutedSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            List<Integer> list = new ArrayList<>(n);
            for (int j = 0; j < n; j++) {
                list.add(scanner.nextInt());
            }
            Collections.sort(list);
            Deque<Integer> deque = new ArrayDeque<>();
            deque.addLast(list.get(0));
            deque.addLast(list.get(list.size() - 1));
            list.remove(0);
            list.remove(list.size() - 1);
            while (!list.isEmpty()) {
                int value, option = 1, max = 0;

                value = Math.abs(list.get(0) - deque.getFirst());
                if (value > max) {
                    option = 1;
                    max = value;
                }

                value = Math.abs(deque.getLast() - list.get(0));
                if (value > max) {
                    option = 2;
                    max = value;
                }

                value = Math.abs(list.get(list.size() - 1) - deque.getFirst());
                if (value > max) {
                    option = 3;
                    max = value;
                }

                value = Math.abs(deque.getLast() - list.get(list.size() - 1));
                if (value > max) {
                    option = 4;
                    max = value;
                }

                switch (option) {
                    case 1 -> {
                        deque.addFirst(list.get(0));
                        list.remove(0);
                    }
                    case 2 -> {
                        deque.addLast(list.get(0));
                        list.remove(0);
                    }
                    case 3 -> {
                        deque.addFirst(list.get(list.size() - 1));
                        list.remove(list.size() - 1);
                    }
                    case 4 -> {
                        deque.addLast(list.get(list.size() - 1));
                        list.remove(list.size() - 1);
                    }
                }
            }
            int sum = 0;
            while (deque.size() > 1) {
                int front = deque.removeFirst();
                sum += Math.abs(front - deque.getFirst());
            }
            System.out.printf("Case %d: %d\n", i + 1, sum);
        }
    }
}