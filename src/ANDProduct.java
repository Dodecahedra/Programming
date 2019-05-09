import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ANDProduct {

    // Complete the andProduct function below.
    static long andProduct(long a, long b) {
        long andProduct = a;
        for (long l = a+1; l <= b; l++) {
            andProduct &= l;
        }
        return andProduct;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong(); long b = sc.nextLong();
        System.out.println(andProduct(a,b));
    }
}
