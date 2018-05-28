package K2;

import java.util.Scanner;

public class EAPC12E {

    public static void main(String[] args) {
        new EAPC12E().run();
    }

    void run() {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for (int c = 0; c < cases; c++) {
            int n = sc.nextInt(); int m = sc.nextInt();
            int[] s = new int[m], p = new int[m], o = new int[m];
            for (int i = 0; i < m; i++) {
                s[i] = sc.nextInt();
                p[i] = sc.nextInt();
                o[i] = sc.nextInt();
            }
            for (int i = 0; i < m; i++) {
                int max = Integer.MIN_VALUE;
                int index = -1;
                for (int j = i; j < m; j++) {
                    if (p[j]>max) {
                        index = j;
                        max = p[j];
                    }
                }
                int temp1 = s[i];
                int temp2 = p[i];
                int temp3 = o[i];
                s[i] = s[index];
                p[i] = p[index];
                o[i] = o[index];
                s[index] = temp1;
                p[index] = temp2;
                o[index] = temp3;
            }

            long[][] W = new long[m+1][n+1];
            for (int i = 0; i <= m; i++) {
                W[i][0] = 0;
            }
            for (int i = 1; i <= n; i++) {
                W[0][i] = 999999999;
            }

            /** */
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <=n; j++) {
                    W[i][j] = Math.min(W[i-1][j], W[i-1][j-Math.min(j, s[i-1])]+Math.min(j, s[i-1])*p[i-1]+o[i-1]);
                }

            }
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <=n; j++) {
                    System.out.print(W[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
