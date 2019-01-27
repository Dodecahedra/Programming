import java.util.Random;
import java.util.Scanner;

public class GenerateShamirSecret {

    public static void main(String[] args) {
        new GenerateShamirSecret().run();
    }



    public void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int s = sc.nextInt();
        int p = sc.nextInt();

        /*
         * We generate a random polynomial of degree t-1.
         */
        int[] a = new int[t];
        Random r = new Random();
        a[0] = s; //We set a[0] to our secret
        for (int i = 1; i < t; i++) {
            a[i] = r.nextInt(p);
        }

        /*
         * Now we will generate {@var n} 'shares'
         */
        int[] f = new int[n];
        for (int i = 1; i <= n; i++) {
            int temp = 0;
            for (int j = 0; j < a.length; j++) {
                temp += a[j]*(int)(Math.pow(i,j));
            }
            f[i-1] = Math.floorMod(temp, p);
        }

        for (int i = 0; i < n; i++) {
            System.out.println("("+(i+1)+", "+f[i]+")");
        }

    }
}
