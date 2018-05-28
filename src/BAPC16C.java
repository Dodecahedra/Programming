import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class BAPC16C {
    public static void main(String[] args) {
        new BAPC16C().main();
    }

    class Node {
        ArrayList<Edge> adj = new ArrayList<>();
        int init = 0;
        int trade = 0;
        boolean left = false;
    }

    class Edge {
        public Edge(int t) {
            target = t;
        }
        int target;
    }

    void main() {
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        int P = sc.nextInt();
        int X = sc.nextInt();
        int L = sc.nextInt();
        Node[] V = new Node[C];
        for (int i = 0; i < C; i++) {
            V[i] = new Node();
        }
        for (int i = 0; i < P; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            a--; b--;
            V[a].adj.add(new Edge(b));
            V[a].init += 1; V[a].trade += 1;
            V[b].adj.add(new Edge(a));
            V[b].init += 1; V[b].trade += 1;
        }
        LinkedList<Node> Q = new LinkedList<>();
        Q.add(V[L-1]);
        while (!Q.isEmpty()) {
            Node B = Q.poll();
            B.left = true;
            for (Edge e : B.adj) {
                Node v = V[e.target];
                v.trade -= 1;
                if (!v.left && 2 * v.trade <= v.init) {
                    Q.add(v);
                }
            }
        }
        if (V[X-1].left) {
            System.out.println("leave");
        } else {
            System.out.println("stay");
        }
    }
}
