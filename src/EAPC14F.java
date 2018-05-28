package K2;

import java.util.Scanner;

public class EAPC14F {
    public static void main(String args[]) {
        new EAPC14F().run();
    }

    void run() {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for (int i = 0; i < cases; i++) {
            int n = sc.nextInt();
            long m;
            if (n >= 180) {
                n -= 180;
                double result = n/10.0;
                m = Math.round(result);
                if (m == 0) {
                    m = 18;
                    System.out.println(m);
                } else if (m < 10) {
                    System.out.println("0"+m);
                } else {
                    System.out.println(m);
                }
            } else {
                double result = n/10.0;
                m = Math.round(result);
                if (m == 0) {
                    m = 18;
                    System.out.println(m);
                } else if (m < 10) {
                    System.out.println("0"+m);
                } else {
                    System.out.println(m);
                }
            }
        }

    }
}
