
import java.util.Scanner;

public class LectureSleep {
    public static void main(String[] args) {
        new LectureSleep().run();
    }

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        int[] t = new int[n];
        long amount = 0;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            t[i] = sc.nextInt();
            amount += t[i] * a[i];
        }
        /** End of reading input */
        long[] A = new long[n+1];
        A[0] = 0;
        for (int i = 0; i < k; i++) {
            A[0] += (1 - t[i]) * a[i];
        }
        long max = 0;
        for (int i = 1; i <= n; i++) {
            int f = 0;
            if (i+k-1 < n) {
                f = (1-(t[i+k-1]))*a[i+k-1];
            }
            A[i] = A[i-1] - ((1 - t[i-1]) * a[i-1]) + f;
            max = Math.max(max, A[i]);
        }
        System.out.println(amount + max);
    }

}
