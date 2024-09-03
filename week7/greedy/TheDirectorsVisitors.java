package solutions.week7.greedy;

import java.util.*;

public class TheDirectorsVisitors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Segment> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            String start = scanner.next();
            int startHour = Integer.parseInt(start.split(":")[0]);
            int startMinute = Integer.parseInt(start.split(":")[1]);
            String end = scanner.next();
            int endHour = Integer.parseInt(end.split(":")[0]);
            int endMinute = Integer.parseInt(end.split(":")[1]);
            list.add(new Segment(startHour * 60 + startMinute, endHour * 60 + endMinute));
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
