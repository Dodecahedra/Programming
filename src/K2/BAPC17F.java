package K2;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BAPC17F {
    public static void main(String args[]) {
        new BAPC17F().run();
    }

    void run() {
        PriorityQueue<Integer> Q;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Q = new PriorityQueue<>(n, Collections.reverseOrder());
        int sum_total = 0;
        for (int i = 0; i < n; i++) {
            int f = sc.nextInt();
            sum_total += f;
            Q.add(f);
        }
        int sum_alice = 0;
        while (!Q.isEmpty()) {
            sum_alice += Q.poll();
            Q.poll();
        }

        System.out.println(sum_alice + " " + (sum_total - sum_alice));

    }
}
