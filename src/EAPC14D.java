package K2;
import java.util.Scanner;

public class EAPC14D {

    public static void main(String[] args) {
        new EAPC14D().solve();
    }

    void solve() {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for (int c = 0; c < cases; c++) {
            int n = sc.nextInt();
            int[] s = new int[n];
            int[] sumS = new int[n+1];
            sumS[0] = 0;
            for (int i = 0; i < n; i++) {
                s[i] = sc.nextInt();
                sumS[i+1] = sumS[i]+s[i];
            }
            int[] A = new int[n+1];
            A[0] = 0;

            for (int i = 1; i <= n; i++) {
                int p = 0;
                A[i] = Math.min(A[i-1]+s[i-1], A[i-1]+sumS[n]-sumS[i]);
            }
            System.out.println(A[n]);
        }
    }
}
