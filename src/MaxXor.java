import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MaxXor {

    // Complete the maximizingXor function below.
    static int maximizingXor(int l, int r) {
        int max = 0;
        for (int a = l; a <= r; a++) {
            for (int b = l; b <= r; b++) {
                max = Math.max(max, a ^ b);
            }
        }
        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt(); int r = sc.nextInt();
        System.out.println(maximizingXor(l,r));
    }
}