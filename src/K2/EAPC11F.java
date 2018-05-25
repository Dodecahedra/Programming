package K2;

import java.util.Arrays;
import java.util.Scanner;

public class EAPC11F {
    public static void main(String[] args) {
        new EAPC11F().run();
    }

    void run() {
        Scanner s = new Scanner(System.in);
        int cases = s.nextInt();
        for (int c = 0; c < cases; c++) {
            /** Start of reading input */
            int P = s.nextInt(); int N = s.nextInt();
            int[] v = new int[N];
            for (int i = 0; i < N; i++) {
                v[i] = s.nextInt();
            }
            /** End of reading input */
            Arrays.sort(v);
            /** Amount of items we can take */
            int i = N;
            /** Index of the item which the pirates are going to take */
            int j = -1;
            while (j+P<i-1) {
                i --; j += P;
            }
            int sum = 0;
            for (int x = i; x < N; x++) {
                sum += v[x];
            }
            System.out.println(sum);
        }
    }
}
