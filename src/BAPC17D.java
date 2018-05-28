import java.util.*;

public class BAPC17D {
    public static void main(String args[]) {
        new BAPC17D().main();
    }

    Node[] V;

    void main() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        V = new Node[N];
        for (int i = 0; i < N; i++) {
            V[i] = new Node(i);
        }
        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int w = sc.nextInt();
            Edge ab = new Edge(b,w);
            Edge ba = new Edge(a,w);
            ab.other = ba;
            ba.other = ab;
            V[a].adj.add(ab);
            V[b].adj.add(ba);
        }

        /** Run Dijkstra on graph */
        dijkstra(1);
        /** For each node, remove edge on shortest path to Amsterdam */
        for (Node v : V) {
            if (v.i != 1) {
                int closest = -1;
                Edge c = null;
                int dist = Integer.MAX_VALUE;
                for (Edge e : v.adj) {
                    if (V[e.target].dist + e.weight < dist) {
                        closest = e.target;
                        c = e;
                        dist = V[e.target].dist + e.weight;
                    }
                }
                /** We remove both the edges */
                if (closest > -1) {
                    V[closest].adj.remove(c.other);
                    v.adj.remove(c);
                }
            }
        }
        for (Node v : V) {
            v.dist = Integer.MAX_VALUE;
            v.parent = null;
        }
        dijkstra(1);
        if (V[0].dist<Integer.MAX_VALUE) {
            Node s = V[0];
            Stack<Integer> f = new Stack<>();
            f.add(0);
            int g = 1;
            while (s.parent != null) {
                f.add(s.parent.i);
                g++;
                s = s.parent;
            }
            System.out.print(g);
            for (Integer h : f) {
                System.out.print(" " + h);
            }
        } else {
            System.out.println("impossible");
        }
    }

    void dijkstra(int source) {
        PriorityQueue<NodeDist> Q = new PriorityQueue<>();
        V[source].dist = 0; V[source].parent = null;
        Q.add(new NodeDist(source, 0));
        while (!Q.isEmpty()) {
            NodeDist nd = Q.poll();
            int k = nd.i;
            int d = nd.d;
            if (V[k].dist < d) continue;
            for (Edge e: V[k].adj) {
                int newDist = d + e.weight;
                if (newDist < V[e.target].dist) {
                    V[e.target].dist = newDist;
                    V[e.target].parent = V[k];
                    Q.add(new NodeDist(e.target, newDist));
                }
            }
        }
    }

    class Edge {
        int target;
        int weight;
        Edge other;
        public Edge(int t, int w) {
            target = t;
            weight = w;
        }
    }

    class Node {
        public Node(int i) {
            this.i = i;
        }
        int i;
        ArrayList<Edge> adj = new ArrayList<>();
        int dist = Integer.MAX_VALUE;
        Node parent;
    }

    class NodeDist implements Comparable<NodeDist> {
        int i, d;
        NodeDist(int index, int dist) {
            i = index; d = dist;
        }
        public int compareTo(NodeDist other) {
            return (d - other.d);
        }
    }
}
