package solutions.week7.greedy;

import java.util.*;

public class Mutation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] genes = new Segment[n + 1];
        for (int i = 0; i <= n; i++) {
            genes[i] = new Segment(-1, -1);
        }
        for (int i = 0; i < n; i++) {
            int gene = scanner.nextInt();
            if (genes[gene].start == -1) {
                genes[gene].start = i;
            }
            genes[gene].end = i;
        }
        List<Segment> segments = new ArrayList<>();
        for (Segment s :
                genes) {
            if (s.start != -1) segments.add(s);
        }
        segments.sort(Comparator.comparingInt(a -> a.end));
        int cur = 0, res = 1;
        for (int i = 1; i < segments.size(); i++) {
            if (segments.get(i).start >= segments.get(cur).end) {
                cur = i;
                res++;
            }
        }
        System.out.println(segments.size() - res);
    }

    private static class Segment {
        int start;
        int end;

        public Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
