 /**
 * Solved on: https://codeforces.com
 * Link: http://codeforces.com/problemset/problem/894/A
 */

import java.util.Scanner;

public class QAQ {
    public static void main(String[] args) {
        new QAQ().run();
    }

    void run() {
        Scanner sc = new Scanner(System.in);
        StringBuffer s = new StringBuffer(sc.nextLine());
        int n = s.length();
        int[][] M = new int[n+1][3];
        if (n >= 3) {
            M[0][0] = 0; M[0][1] = 0; M[0][2] = 0; M[1][1] = 0; M[1][2] = 0; M[2][2] = 0;
            for (int i = 1; i <= n; i++) {
                if (s.charAt(i-1)=='Q') {
                    M[i][0] = M[i-1][0] + 1; //Amount of Q's + 1
                    M[i][1] = M[i-1][1]; //Amount of QA's stays the same
                    M[i][2] = M[i-1][1] + M[i-1][2]; //Amount of QAQ's
                } else if (s.charAt(i-1)=='A') {
                    M[i][0] = M[i-1][0]; //Amount of Q's stays the same
                    M[i][1] = M[i-1][0] + M[i-1][1]; //Amount of Q's + amount of QA's
                    M[i][2] = M[i-1][2];
                } else {
                    M[i][0] = M[i-1][0]; // Subsequenses stay the same
                    M[i][1] = M[i-1][1];
                    M[i][2] = M[i-1][2];
                }
            }
        }
        System.out.println(M[n][2]);
    }
}
