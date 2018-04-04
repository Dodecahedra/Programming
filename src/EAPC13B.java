import java.util.Scanner;

public class EAPC13B {
    public static void main(String args[]) {
        new EAPC13B().run();
    }
    class Vector {
        int x;
        int y;

        public Vector(int x, int y) {
            this.x = x;
            this.y = y;
        }
        /*
         * Adds vector v to this vector.
         */
        public void add(Vector v) {
            this.x += v.x;
            this.y += v.y;
        }
        /*
         * subtracts the vector v from this vector.
         */
        public void subtract(Vector v) {
            this.x -= v.x;
            this.y -= v.y;
        }
        public void dot(Vector v) {};
        public void cross(Vector v) {};
        /*
         * Returns the length of this vector.
         */
        public float length() {
            return (float) Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
        }

        /*
         * Prints this vector.
         */
        public void print() {
            System.out.println("("+this.x + ", " + this.y + ")");
        }
    }

    void run() {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for (int i = 0; i < cases; i++) {
            int n = sc.nextInt();
            int B = sc.nextInt();
            Vector P_listener = new Vector(sc.nextInt(), sc.nextInt());
            double[] r = new double[n];
            float R_sum = 0;
            for (int j = 0; j < n; j++) {
                int x_i = sc.nextInt(); int y_i = sc.nextInt();
                int s_i = sc.nextInt();
                r[j] = s_i/(Math.pow(Math.abs(Math.sqrt(Math.pow(x_i-x, 2)+Math.pow(y_i-y, 2))), 2));
                R_sum += r[j];
            }
            int index = 0;
            for (int j = 0; j < n; j++) {
                if (r[j] > 6 * (B + (R_sum - r[j]))) {
                    index = j+1;
                    break;
                }
            }
            if (index > 0) {
                System.out.println(index);
            } else {
                System.out.println("NOISE");
            }

        }

    }
}
