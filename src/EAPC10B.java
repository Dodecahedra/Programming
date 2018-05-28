package K2;

import java.util.Scanner;

public class EAPC10B {

    public static void main(String[] args) {
        new EAPC10B().run();
    }

    void run() {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for (int c = 0; c < cases; c++) {
            int D = sc.nextInt(); int M = sc.nextInt();
            int Y2 = sc.nextInt(); int Y1 = Y2/100; Y2 -= Y1*100;
            String d = D+""+M+""+Y1+""+Y2;
            int[] numbers = new int[10];
            for (int i = 0; i < d.length(); i++) {
                numbers[Integer.parseInt(d.substring(i, i+1))]++;
            }
            boolean correct = true;
            for (int i = 0; i < 9; i++) {
                if (numbers[i]!=numbers[i+1] && numbers[i]!=0 && numbers[i+1]!=0) {
                    correct = false;
                    System.out.println("no");
                    break;
                }
            }
            if (correct) {

                if (true) {}
            }
        }
    }
}
