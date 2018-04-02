import java.util.Iterator;
import java.util.Scanner;

public class BAPC10I {
    public static void main(String args[]) {
        new BAPC10I().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for (int i = 0; i < cases; i++) {
            String s = sc.next();
            int cursor = 0;
            StringBuffer b = new StringBuffer();
            for (int j = 0; j < s.length(); j++) {
                char t = s.charAt(j);
                if (t == '<') {
                    if (cursor > 0) {
                        cursor--;
                    }
                } else if (t == '>') {
                    if (cursor < b.length()) {
                        cursor++;
                    }
                } else if (t == '-') {
                    if (cursor > 0) {
                        b.delete(cursor - 1, cursor);
                        cursor--;
                    }
                } else {
                    b.insert(cursor, t);
                    cursor++;
                }
                System.out.println(b.toString());
            }
            System.out.println(b.toString());
        }

    }

}
