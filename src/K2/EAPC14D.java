package K2;

import java.util.Scanner;

public class EAPC14D {
    int n;
    int[] S;
    int[] sumS;

    public static void main(String[] args) {
        new EAPC14D().solve();
    }

    void solve() {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for (int c = 0; c < cases; c++) {
            n = sc.nextInt(); //Number of floors
            S = new int[n]; //Students wanting to get out at floor i
            sumS = new int[n]; //Students who don't want to get out at floor i
            for (int i = 0; i < n; i++) {
                S[i] = sc.nextInt();
            }
            sumS[n-1] = 0;
            for (int i = n-1; i > 0; i--) {
                sumS[i-1] = sumS[i] + S[i];
            }
        }

        //Recursive call
        int minAnger = liftAnger(0, 0);
        System.out.println(minAnger);
    }
    /**
     * Recursive function to compute total lift anger.
     * @param i current floor
     * @param s angry students in lift
     * @return {@code \min(s+s[i]+liftAnger(n+1, 2s+s[i]), sums[i] + liftAnger(n+1, 0))}
     */
    int liftAnger(int i, int s) {
        if (i == n-1) return s; //If we are at the last floor, return the amount of angry people who are still in the lift
        return Math.min(s+S[i]+liftAnger(i+1, 2*s+S[i]), sumS[i] + s + liftAnger(i+1, 0));
    }
}
