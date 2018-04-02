import sun.reflect.generics.tree.Tree;

import java.lang.reflect.Array;
import java.util.*;

public class TreeIsomorphismExt {
    class Vertice {
        Vertice parent;
        Vertice[] children = new Vertice[] {};
        int depth;
        StringBuffer name;
    }

    class VerticeComparator implements Comparator<Vertice> {

        @Override
        public int compare(Vertice v1, Vertice v2) {
            for (int i = 0; i < Math.min(v1.name.length(), v2.name.length()); i++) {
                if (((int) v1.name.charAt(i)) > ((int) v1.name.charAt(i))) {
                    return 1;
                } else if (((int) v1.name.charAt(i)) == ((int) v1.name.charAt(i))) {
                    return 0;
                } else {
                    return -1;
                }
            }
            return 0;
        }
    }

    public boolean computeIsomorphism(Vertice R1, Vertice R2) {
        int depth1 = assignDepth(R1, 0); //Inital recur call with depth 0.
        ArrayList<ArrayList<Vertice>> LL1 = new ArrayList<>();
        for (int i = 0; i <= depth1; i++) {
            LL1.add(new ArrayList<>());
        }
        LL1.get(0).add(R1); //We add the root to our list
        LinkedList<Vertice> Q1 = new LinkedList<>();
        Q1.add(R1); //Add first vertex to our queue
        while (!Q1.isEmpty()) {
            Vertice c = Q1.pop();
            for (Vertice q : c.children) {
                Q1.add(q);
            }
            LL1.get(c.depth).add(c); //We add our vertice to the LL at the correct depth
        }
        int depth2 = assignDepth(R2, 0);
        ArrayList<ArrayList<Vertice>> LL2 = new ArrayList<>(depth2);
        for (int i = 0; i <= depth2; i++) {
            LL2.add(new ArrayList<>());
        }
        LL2.get(0).add(R2); //We add the root to our list
        LinkedList<Vertice> Q2 = new LinkedList<>();
        Q2.add(R2); //Add first vertex to our queue
        while(!Q2.isEmpty()) {
            Vertice c = Q2.pop();
            for (Vertice q : c.children) {
                Q2.add(q);
            }
            LL2.get(c.depth).add(c); //We add our vertice to the LL at the correct depth
        }

        /* *************************************/
        if (depth1 != depth2) return false;
        System.out.println("Depth tree 1: " + depth1 + ", depth tree 2: " + depth2);
        for (int h = depth1; h >= 0; h--) {
            ArrayList<Vertice> Sl1 = new ArrayList<>();
            for (Vertice v : LL1.get(h)) {
                v.name = new StringBuffer();
                if (v.children.length == 0) { //Leaf node
                    v.name.append("10");
                } else { //Non-leaf node
                    v.name.append("1");
                    for (Vertice c : v.children) {
                        v.name.append(c.name.toString());
                    }
                    v.name.append("0");

                    Sl1.add(v);
                }
            }
            /* Lexicographically sort the list Sl1 */
            VerticeComparator comp = new VerticeComparator();
            Sl1.sort(comp);
            for ( Vertice v : Sl1) {
                System.out.println(v.name.toString());
            }
            /* Tree 2 */
            ArrayList<Vertice> Sl2 = new ArrayList<>();
            for (Vertice v : LL2.get(h)) {
                v.name = new StringBuffer();
                if (v.children.length == 0) { //Leaf node
                    v.name.append("10");
                } else { //Non-leaf node
                    v.name.append("1");
                    for (Vertice c : v.children) {
                        v.name.append(c.name.toString());
                    }
                    v.name.append("0");

                    Sl2.add(v);
                }
            }
            /* Lexicographically sort the list Sl2 */
            Sl2.sort(comp);
            for ( Vertice v : Sl2) {
                System.out.println(v.name.toString());
            }
            if (!listsEquals(Sl1, Sl2)) {
                System.out.println("Trees are not isomorphic at height: " + h);
                return false;
            }
            // Renaming the vertices and then do for level h-1

            for (int i = 0; i < Sl1.size(); i++) {
                Sl1.get(i).name = new StringBuffer();
                Sl1.get(i).name.append(i);
                Sl2.get(i).name = new StringBuffer();
                Sl2.get(i).name.append(i);
            }
        }
        return R1.name.toString().equals(R2.name.toString()); //Return if the trees are isomorphic or not
    }

    private boolean listsEquals(List<Vertice> S1, List<Vertice> S2) {
        if (S1.size() != S2.size()) return false;
        for (int i = 0; i < S1.size(); i++) {
            System.out.print(S1.get(i).name.toString());
            System.out.print(S2.get(i).name.toString());
            System.out.println();
            if (!S1.get(i).name.toString().equals(S2.get(i).name.toString())) return false;
        }
        return true;
    }

    private int assignDepth(Vertice R, int depth) {
        R.depth = depth;
        int totalDepth = depth;
        if (R.children.length <= 0) return depth;
        for(Vertice c : R.children) {
            totalDepth = Math.max(assignDepth(c, depth + 1), totalDepth);
        }
        return totalDepth;
    }

    public void run() {
        Vertice R1 = new Vertice();
        R1.children = new Vertice[3];
        R1.children[0] = new Vertice();
        R1.children[1] = new Vertice();
        R1.children[2] = new Vertice();
        R1.children[0].children = new Vertice[1];
        R1.children[0].children[0] = new Vertice();
        Vertice R2 = new Vertice();
        R2.children = new Vertice[3];
        R2.children[0] = new Vertice();
        R2.children[1] = new Vertice();
        R2.children[2] = new Vertice();
        R2.children[1].children = new Vertice[1];
        R2.children[1].children[0] = new Vertice();
        System.out.println("Trees are isomorphic: " + computeIsomorphism(R1, R2));
    }

    public static void main(String args[]) {
        new TreeIsomorphismExt().run();
    }
}
