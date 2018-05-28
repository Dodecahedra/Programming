package K2;

import java.util.Scanner;

public class EAPC10C {
    public static void main(String[] args) {
        new EAPC10C().run();
    }

    void run() {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for (int c = 0; c < cases; c++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[] S = new int[N];
            for (int i = 0; i < N; i++) {
                S[i] = sc.nextInt();
            }
            /** Finished reading input */
            int[][] G = new int[N + 1][M];
            for (int i = 0; i < M; i++) {
                G[0][i] = 0; //Set base cases
            }

            for (int i = 1; i <= N; i++) {
                for (int m = 0; m < M; m++) {
                    if (S[i - 1] % M == (m + 1)%M) {
                        G[i][m] = G[i - 1][M - 1] + 1;
                    } else {
                        int d = 0;
                        if (G[i - 1][((M + ((m + 1) - (S[i-1] % M))) % M)-1]>0) {
                            d = G[i - 1][((M + ((m + 1) - (S[i-1] % M))) % M)-1]+1;
                        }
                        G[i][m] = Math.max(G[i - 1][m], d);
                    }
                }
            }
            System.out.println(G[N][M-1]);
        }
    }

}
