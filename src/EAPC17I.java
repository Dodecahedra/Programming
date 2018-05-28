package K2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class EAPC17I {
    public static void main(String[] args) {
        new EAPC17I().main();
    }

    Node[] V;
    int index = 0, C = 0;
    ArrayList<Integer> SCC = new ArrayList<>();
    ArrayDeque<Integer> stack = new ArrayDeque<>();
    class Edge {
        public Edge(int t) {
            target = t;
        }
        int target;
    }

    class Node {
        ArrayList<Edge> adj = new ArrayList<>();
        int index = -1;
        int low;
        int comp = -1;
    }

    void main() {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        V = new Node[S];
        int E = sc.nextInt();
        int En[] = new int[E];
        int C = sc.nextInt();
        for (int i = 0; i < C; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            V[a].adj.add(new Edge(b));
        }
        for (int j = 0; j < E; j++) {
            En[j] = sc.nextInt();
        }
        for (int i = 0; i < S; i++) {
            if (V[i].index == -1) tarjan(i);
        }
        for (int i = 0; i < E; i++) {
            // We set the SCC containing En[i] to 0
            SCC.set(V[En[i]].comp, 0);
        }
        int spies = S;
    }
    void tarjan(int i) {
        V[i].index = index++;
        V[i].low = V[i].index;
        stack.push(i);
        for (Edge e : V[i].adj) {
            if (V[e.target].index == -1) {
                tarjan(e.target);
                V[i].low = Math.min(V[i].low, V[e.target].low);
            } else if (V[e.target].comp == -1) {
                V[i].low = Math.min(V[i].low, V[e.target].index);
            }
        }
        if (V[i].index == V[i].low) {
            int j, f = 0;
            do {
                j = stack.pop();
                f++;
                V[j].comp = C;
            } while (j!=i);
            SCC.add(f);
            C++;
        }
    }

}
