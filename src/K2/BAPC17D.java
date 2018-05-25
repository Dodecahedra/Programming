package K2;

import java.util.*;

public class BAPC17D {
    public static void main(String args[]) {
        new BAPC17D().run();
    }

    Node[] V;


    void dijkstra(int source) {
        PriorityQueue<NodeDist> Q = new PriorityQueue<>();
        V[source].dist = 0; V[source].parent = null;
        Q.add(new NodeDist(source, 0));
        while (!Q.isEmpty()) {
            NodeDist nd = Q.poll();
            int k = nd.i;
            int d = nd.d;
            if (V[k].dist < d) continue;
            for (Edge e : V[k].adj) {
                int newDist = d + e.weight;
                if (newDist < V[e.target].dist) {
                    V[e.target].dist = newDist;
                    V[e.target].parent = V[k];
                    Q.add(new NodeDist(e.target, newDist));
                }
            }
        }
    }

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); int m = sc.nextInt();
        V = new Node[n];
        for (int i = 0; i < n; i++) {
            V[i] = new Node(i);
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt(); int b = sc.nextInt();
            int d = sc.nextInt();
            Edge aa = new Edge(a, d); Edge bb = new Edge(b, d);
            aa.setBackEdge(bb); bb.setBackEdge(aa);
            V[a].adj.add(bb);
            V[b].adj.add(aa);
        }
        dijkstra(0);


    }
    class Node {
        AbstractList<Edge> adj;
        int dist;
        Node parent;
        int index;
        public Node(int i) {
            dist = Integer.MAX_VALUE;
            adj = new LinkedList<>();
            index = i;
        }
    }

    class NodeDist implements Comparable<NodeDist> {
        int i,d;
        NodeDist(int index, int dist) {
            i = index;
            d = dist;
        }
        @Override
        public int compareTo(NodeDist other) {
            return (d - other.d);
        }
    }

    class Edge {
        int target;
        int weight;
        Edge backEdge;

        public Edge(int t, int w) {
            target = t;
            weight = w;
        }

        public void setBackEdge(Edge e) {
            backEdge = e;
        }
    }
}
