package K2;

import java.util.Scanner;

public class EAPC12F {
    public static void main(String args[]) {
        new EAPC12F().run();
    }

    void run() {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        for (int i = 0; i < c; i++) {
            String decimal = sc.next(); //We scan the string for the decimal
            int f = 2;
            StringBuffer non_repeat = new StringBuffer();
            // Reading the non-repeating part
            while (decimal.charAt(f)!='(') {
                non_repeat.append(decimal.charAt(f)); //If the character is not '(', we keep adding the digits.
                f++;
                if (f >= non_repeat.length()) break;
            }
            // Reading the repeating part (if present)
            StringBuffer repeat = new StringBuffer();
            while (f < decimal.length()) {
                if (decimal.charAt(f)!='(' && decimal.charAt(f)!=')') {
                    repeat.append(decimal.charAt(f));
                }
                f++;
            }
            int length_nrepeat = non_repeat.length();
            int length_repeat = repeat.length();
            if (length_repeat == 0) {

            } else {
                long denominator = (long)(Math.pow(10, length_nrepeat+length_repeat)-Math.pow(10, length_nrepeat));
            }

        }
    }

    int gcd(int a, int b) {
        if (b == 0) return a;
        else return (gcd(b, a%b));
    }
}
