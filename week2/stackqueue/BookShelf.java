package solutions.week2.stackqueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BookShelf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int command = scanner.nextInt();
            switch (command) {
                case 1 -> deque.addFirst(scanner.nextInt());
                case 2 -> deque.addLast(scanner.nextInt());
                case 3 -> System.out.println(deque.removeFirst());
                case 4 -> System.out.println(deque.removeLast());
            }
        }
    }
}
