package Codeforce;

import java.util.Scanner;

/**
 * Solved on: https://codeforces.com
 * Link: http://codeforces.com/problemset/problem/698/A
 */
public class Vacations {
    public static void main(String[] args) {
        new Vacations().run();
    }

    void run() {
        /** Reading input */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        /** Table in which we store Longest Alternating Subsequence */
        int[][] L = new int[n+1][3];
        L[0][0] = 0; L[0][1] = 0; L[0][2] = 0;

        /** We fill in our table */
        for (int i = 1; i <= n; i++) {
            if (a[i-1] == 0) {
                L[i][0] = Math.max(Math.max(L[i-1][1], L[i-1][2]), L[i-1][0]);
                L[i][1] = 0;
                L[i][2] = 0;
            } else if (a[i-1] == 1) {
                L[i][0] = Math.max(Math.max(L[i-1][1], L[i-1][2]), L[i-1][0]);
                L[i][1] = Math.max(L[i-1][0]+1, L[i-1][2]+1);
                L[i][2] = 0;
            } else if (a[i-1] == 2) {
                L[i][0] = Math.max(Math.max(L[i-1][1], L[i-1][2]), L[i-1][0]);
                L[i][1] = 0;
                L[i][2] = Math.max(L[i-1][0]+1, L[i-1][1]+1);
            } else if (a[i-1] == 3) {
                L[i][0] = Math.max(Math.max(L[i-1][1], L[i-1][2]), L[i-1][0]);
                L[i][1] = Math.max(L[i-1][0]+1, L[i-1][2]+1);
                L[i][2] = Math.max(L[i-1][0]+1, L[i-1][1]+1);
            }
        }
        /** Print our output */
        System.out.println(n - Math.max(Math.max(L[n][1], L[n][2]), L[n][0]));
    }
}
