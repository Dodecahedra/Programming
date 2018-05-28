package K2;

import java.util.Scanner;

public class EAPC17D {
    public static void main(String[] args) {
        new EAPC17D().run();
    }

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] A = new long[n];
        long bact = 1;
        long pow = 0; //amount of 2^30's
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextLong();
        }
        for (int i = 0; i < n; i++) {
            if (bact > Math.pow(2, 30)) {

            }
        }
    }
}
