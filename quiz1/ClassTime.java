package solutions.quiz1;

import java.util.Scanner;

public class ClassTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Student[] arr = new Student[n + 1];
        for (int i = 1; i <= n; i++) {
            String firstName = scanner.next();
            String lastName = scanner.next();
            arr[i] = new Student(firstName, lastName);
        }
        heapSort(arr, n);
        for (int i = 1; i <= n; i++) {
            System.out.println(arr[i]);
        }
    }

    public static int left(int i) {
        return 2 * i;
    }

    public static int right(int i) {
        return 2 * i + 1;
    }

    public static void heapify(Student[] a, int i, int n) {
        int largest = 0;
        int l = left(i);
        int r = right(i);

        if (l <= n && compare(a[l], a[i])) largest = l;
        else largest = i;
        if (r <= n && compare(a[r], a[largest])) largest = r;

        if (largest != i) {
            Student temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;
            heapify(a, largest, n);
        }
    }

    public static boolean compare(Student a, Student b) {
        if (a.lastName.equals(b.lastName)) {
            return compareAlpha(a.firstName, b.firstName);
        }
        return compareAlpha(a.lastName, b.lastName);
    }

    public static boolean compareAlpha(String a, String b) {
        int i;
        for (i = 0; i < a.length() && i < b.length(); i++) {
            char c1 = a.charAt(i);
            char c2 = b.charAt(i);
            if (c1 == c2) {
                continue;
            }
            if (Character.toLowerCase(c1) == Character.toLowerCase(c2)) {
                return c1 > c2;
            }
            return Character.toLowerCase(c1) > Character.toLowerCase(c2);
        }
        return i != a.length();
    }

    public static void buildHeap(Student[] a, int n) {
        for (int i = n / 2; i > 0; i--)
            heapify(a, i, n);
    }

    public static void heapSort(Student[] a, int n) {
        buildHeap(a, n);
        for (int i = n; i >= 2; i--) {
            Student temp = a[i];
            a[i] = a[1];
            a[1] = temp;
            heapify(a, 1, i - 1);
        }
    }

    private record Student(String firstName, String lastName) {
        @Override
        public String toString() {
            return String.format("%s %s", firstName, lastName);
        }
    }
}
