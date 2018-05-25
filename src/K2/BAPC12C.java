package K2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BAPC12C {
    public static void main(String args[]) {
        new BAPC12C().run();
    }

    void run() {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for (int c = 0; c < cases; c++) {
            int n = sc.nextInt();
            char[][] games = new char[n][n];
            int[] score = new int[n];

            /**
             * Strategy: for each player i, fill in the table such that:
             * player i receives the most points, the rest of the players receive
             * the smallest amount of points. Do this by assigning the result
             * such that: higher scored player loses and lower scored player
             * wins. If scores are the same, assign draw. If player i's score
             * is higher than all the other scores, player i can still win the
             * game.
             */

            // We read the input
            for (int i = 0; i < n; i++) {
                String s = sc.next();
                for (int j = 0; j < n; j++) {
                    if (s.charAt(j) == '1') score[j] += 2;
                    else if (s.charAt(j) == 'd') score[j]++;
                    games[i][j] = s.charAt(j);
                }
            }
            //We do the magic
            /** Set containing all possible winners (1-based) */
            Set<Integer> w = new HashSet<>();
            for (int p = 0; p < n; p++) {
                char[][] tempGame = new char[n][n];
                int[] tempScore = new int[n];
                for (int i = 0; i < n; i++) {
                    tempScore[i] = score[i];
                    for (int j = 0; j < n; j++) {
                        tempGame[i][j] = games[i][j];
                    }
                }
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (tempGame[i][j] == '.') {
                            //We set this game as decided.
                            tempGame[i][j] = 's';
                            tempGame[j][i] = 's';

                            if (i == p) {
                                tempScore[p] += 2; //Make sure p wins every possible game
                            } else {
                                if (tempScore[i] > tempScore[j]) {
                                    tempScore[j] +=2;
                                } else if (tempScore[j] > tempScore[i]) {
                                    tempScore[i] += 2;
                                } else {
                                    tempScore[i]++; tempScore[j]++;
                                }
                            }
                        }
                    }
                }
                int max = Integer.MIN_VALUE;
                for (int s : tempScore) {
                    if (s >= max) max = s;
                }
                if (tempScore[p] >= max) {
                    w.add(p+1);
                }
            }
            for (Integer s : w) {
                System.out.print(s + " ");
            }
        }
    }

}
