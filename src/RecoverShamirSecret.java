import java.util.Scanner;

public class RecoverShamirSecret {

    void run() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] x = new int[t];
        int[] f = new int[t];
        for (int i = 0; i < t; i++) {
            x[i] = sc.nextInt();
            f[i] = sc.nextInt();
        }

        /*
         * Now we will compute the secret s using
         */
        for (int i = 0; i < t; i++) {
            int temp = f[i];
            for (int j = 0; j < t; j++) {
                if (j!=i) {
                    //TODO: implement computation
                }
            }
        }
    }
}
