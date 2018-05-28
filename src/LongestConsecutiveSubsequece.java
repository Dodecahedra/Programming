
import java.util.Scanner;
import java.util.Stack;

/**
 * Link: http://codeforces.com/problemset/problem/977/F
 */
public class LongestConsecutiveSubsequece {

    public static void main(String[] args) {
        new LongestConsecutiveSubsequece().run();
    }

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] s = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = sc.nextInt();
        }
        int[] LCS = new int[n];
        int maxLCS = 0; int iLCS = -1;
        LCS[0] = 1;
        for (int i = 1; i < n; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (s[i] == s[j] + 1 && LCS[j]+1 >= max) {
                    max = LCS[j]+1;
                }
            }
            LCS[i] = max;
            if (max > maxLCS) {
                maxLCS = max; iLCS = i;
            }
        }
        Stack<Integer> A = new Stack<>();
        A.add(iLCS);
        for (int i = iLCS-1; i >= 0; i--) {
            if (LCS[i]+1==LCS[A.peek()] && s[i]+1 == s[A.peek()]) {
                A.add(i);
            }
        }
        System.out.println(maxLCS);
        while (!A.isEmpty()) {
            System.out.print(A.pop()+1 +" ");
        }
    }
}
