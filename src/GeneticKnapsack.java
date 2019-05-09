import sun.security.util.BitArray;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class GeneticKnapsack {
    int n, W;
    int[] p, w;
    LinkedList<BitArray> population;



    void run() {
        Scanner sc = new Scanner(System.in);
        /*              Reading Input                 */
        n = sc.nextInt(); // Amount of items
        p = new int[n];
        w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }
        W = sc.nextInt();
        /*             Generate Population            */
        population = new LinkedList<>();
        Random rn = new Random();
        for (int i = 0; i < 50; i++) {
            BitArray b = new BitArray(n);
            for (int j = 0; j < n; j++) { // Generate random candidate
                b.set(j, rn.nextBoolean());
            }
            population.add(b); // Add generated candidate to population.
        }

        /* Do genetic stuff */
        int iterations = 15;

        for (int i = 0; i < iterations; i++) {

            for (BitArray c : population) {
                fit(c);
            }


        }

    }


    int fit(BitArray solution) {

        return 0;
    }




    public static void main(String... args) {
        new GeneticKnapsack().run();
    }
}
