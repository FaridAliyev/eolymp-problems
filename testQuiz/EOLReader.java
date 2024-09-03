package solutions.testQuiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class EOLReader {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<int[]> list = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] split = line.split(" ");
            int[] arr = new int[split.length];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(split[i]);
            }
            list.add(arr);
        }
        for (int[] a :
                list) {
            System.out.println(Arrays.toString(a));
        }
    }
}
