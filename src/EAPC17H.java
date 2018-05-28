package K2;
import java.util.Scanner;

public class EAPC17H {
    public static void main(String[] args) {
        new EAPC17H().run();
    }

    void run() {
        Scanner sc = new Scanner(System.in);
        int N = 1000000;
        int[] F = new int[N];
        int k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            int a = sc.nextInt();
            F[a] = 1;
        }
        int f = sc.nextInt();
        for (int i = 0; i < f; i++) {
            int a = sc.nextInt();
            F[a] += 2;
        }
        int watched = 0;
        int turn = 3;
        for (int i = 0; i < N; i++) {
            if (F[i]>0) {
                if (F[i]==3) {
                    watched++;
                    turn = 3;
                } else if (F[i]==turn) {
                    watched++;
                    turn = (turn%2)+1;
                } else if (turn == 3) {
                    watched++;
                    turn = (F[i]%2)+1;
                }
            }
        }
        System.out.println(watched);
    }
}
