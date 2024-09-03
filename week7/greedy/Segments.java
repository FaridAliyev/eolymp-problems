package solutions.week7.greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Segments {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Segment> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(new Segment(scanner.nextInt(), scanner.nextInt()));
        }
        list.sort(Comparator.comparingInt(a -> a.end));

        int cur = 0, res = 1;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).start >= list.get(cur).end) {
                cur = i;
                res++;
            }
        }
        System.out.println(res);
    }

    private record Segment(int start, int end) {

    }
}
