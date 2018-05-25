package Codeforce;

import java.util.Scanner;

/**
 * Link: http://codeforces.com/problemset/problem/977/F
 */
public class LongestConsecutiveSubsequece {

    public static void main(String[] args) {
        new LongestConsecutiveSubsequece().run();
    }

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] s = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = sc.nextInt();
        }
        int[] LIS = new int[n]; //Longest increasing Subsequence ending at index i
        LIS[0] = 1; //Base case
        int[] IND = new int[n]; //Indictor wich indicates which LIS[i] was used to make LIS[j].
        int LCS = 0; //our current longest consecutive subsequence
        int LCSi = -1;
        for (int i = 1; i < n; i++) {
            int max = 1;
            int index = -1;
            for (int j = 0; j < i; j++) {
                if (s[i]==s[j]+1 && LIS[j]+1 > max) {
                    max = LIS[j]+1;
                    index = j;
                }
            }
            LIS[i] = max;
            IND[i] = index;
        }

    }
}
