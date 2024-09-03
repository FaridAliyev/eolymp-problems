package solutions.week2.stackqueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class SimpleDeque {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        loop: while (scanner.hasNext()) {
            String command = scanner.next();
            switch (command) {
                case "push_back" -> {
                    int num = scanner.nextInt();
                    deque.addLast(num);
                    System.out.println("ok");
                }
                case "push_front" -> {
                    int num = scanner.nextInt();
                    deque.addFirst(num);
                    System.out.println("ok");
                }
                case "pop_back" -> System.out.println(deque.removeLast());
                case "pop_front" -> System.out.println(deque.removeFirst());
                case "back" -> System.out.println(deque.getLast());
                case "front" -> System.out.println(deque.getFirst());
                case "size" -> System.out.println(deque.size());
                case "clear" -> {
                    deque.clear();
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
