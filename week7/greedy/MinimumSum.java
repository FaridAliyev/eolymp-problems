package solutions.week7.greedy;

import java.util.*;

public class MinimumSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> list1 = new ArrayList<>(n);
        List<Integer> list2 = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list1.add(scanner.nextInt());
        }
        for (int i = 0; i < n; i++) {
            list2.add(scanner.nextInt());
        }
        Collections.sort(list1);
        Collections.sort(list2);
        Collections.reverse(list2);
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += ((long) list1.get(i) * list2.get(i));
        }
        System.out.println(sum);
    }
}
