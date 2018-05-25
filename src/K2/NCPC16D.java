package K2;

import java.util.Scanner;

public class NCPC16D {
    public static void main(String args[]) {
        new NCPC16D().run();
    }

    void run() {

        Scanner sc = new Scanner(System.in);
        long capital = 1000000;
        long stocks = 0;
        int d = sc.nextInt();
        int[] p = new int[d];
        for (int i = 0; i < d; i++) {
            p[i] = sc.nextInt();
        }
        for (int i = 0; i < d - 1; i++) {
            if (p[i+1] >= p[i] && stocks < 100000) {
                //Buy all possible stocks
                stocks += Math.min((100000-stocks), capital/p[i]);
                capital -= Math.min(100000-stocks, capital/p[i])*p[i];
            } else {
                //Sell all possible stocks
                capital += stocks * p[i];
                stocks = 0;
            }
        }
        capital += stocks * p[d-1];
        System.out.println(capital);

    }
}
