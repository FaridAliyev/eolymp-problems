package solutions.week7.greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShoemakerProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            List<Job> jobs = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                jobs.add(new Job(scanner.nextInt(), scanner.nextInt(), i));
            }
            jobs.sort((o1, o2) -> {
                if (o1.time * o2.fine == o2.time * o1.fine) return o1.id - o2.id;
                return o1.time * o2.fine - o2.time * o1.fine;
            });
            System.out.println(jobs.stream()
                    .map(j -> j.id + 1)
                    .map(Object::toString)
                    .collect(Collectors.joining(" "))
            );
        }
    }

    private record Job(int time, int fine, int id) {

    }
}
