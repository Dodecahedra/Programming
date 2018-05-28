package K2;

import java.util.Scanner;

public class EAPC13B {
    public static void main(String args[]) {
        new EAPC13B().run();
    }


    void run() {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for (int i = 0; i < cases; i++) {
            int n = sc.nextInt();
            int B = sc.nextInt();
            int x = sc.nextInt(); int y = sc.nextInt();
            double[] r = new double[n];
            float R_sum = 0;
            for (int j = 0; j < n; j++) {
                int x_i = sc.nextInt(); int y_i = sc.nextInt();
                int s_i = sc.nextInt();
                r[j] = s_i/(Math.pow(Math.abs(Math.sqrt(Math.pow(x_i-x, 2)+Math.pow(y_i-y, 2))), 2));
                R_sum += r[j];
            }
            int index = 0;
            for (int j = 0; j < n; j++) {
                if (r[j] > 6 * (B + (R_sum - r[j]))) {
                    index = j+1;
                    break;
                }
            }
            if (index > 0) {
                System.out.println(index);
            } else {
                System.out.println("NOISE");
            }

        }

    }
}
