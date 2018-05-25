package K2;

import java.util.Scanner;

public class BAPC17A {
    public static void main(String[] args) {
        new BAPC17A().run();
    }

    void run() {
        /** Begin reading input */
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt(); int N = sc.nextInt();
        float R = sc.nextFloat();
        int ax = sc.nextInt(); int bx = sc.nextInt();
        int ay = sc.nextInt(); int by = sc.nextInt();
        /** End of reading input */

        /** First we calculate straight distance */
        float sdist = (Math.abs(by-bx)/(float)N)*R;
        /** Calculate ring distance */
        float d = Math.abs(ay-ax)/(float)M;
        float r = (Math.min(bx, by)*R)/((float)(N));
        float rdist = d*r*(float)Math.PI;

        float fdist = (bx/(float)N) * R + (by/(float)N) * R;

        System.out.println(Math.min(sdist+rdist, fdist));
    }
}
