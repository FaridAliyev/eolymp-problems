package solutions.week4.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class DrWhosBanquet {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PriorityQueue<Integer> pq = new PriorityQueue<>((Comparator.reverseOrder()));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] split = line.split(" ");
            pq.addAll(Arrays.stream(split).map(Integer::parseInt).toList());
            System.out.println(checkPossibility(pq) ? "ok" : "fail");
            System.out.println();
            while (!pq.isEmpty()) {
                pq.remove();
            }
        }
    }

    public static boolean checkPossibility(PriorityQueue<Integer> pq) {
        while (!pq.isEmpty()) {
            int partnersWanted = pq.remove();
            PriorityQueue<Integer> temp = new PriorityQueue<>();
            while (partnersWanted != 0) {
                if (pq.isEmpty()) return false;
                if (pq.peek() != 1) temp.add(pq.peek() - 1);
                pq.remove();
                partnersWanted--;
            }
            while (!temp.isEmpty()) {
                pq.add(temp.remove());
            }
        }
        return true;
    }
}
