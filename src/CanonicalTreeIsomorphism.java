import java.util.BitSet;
import java.util.Comparator;
import java.util.LinkedList;

public class CanonicalTreeIsomorphism {

    public static void main(String[] args) {
        vertice root = new vertice();
        root.children = new vertice[3];
        root.children[0] = new vertice();
        root.children[1] = new vertice();
        root.children[2] = new vertice();
        root.children[0].children = new vertice[1];
        root.children[0].children[0] = new vertice();
        vertice root1 = new vertice();
        root1.children = new vertice[3];
        root1.children[0] = new vertice();
        root1.children[1] = new vertice();
        root1.children[2] = new vertice();
        root1.children[1].children = new vertice[1];
        root1.children[1].children[0] = new vertice();
        CanonicalTreeIsomorphism tree = new CanonicalTreeIsomorphism();
        System.out.println(tree.assignNames(root));
        System.out.println(tree.assignNames(root1));
    }

    static class vertice{
        vertice parent;
        vertice[] children;
        BitSet name;
    }

    class sortBitset implements Comparator<String> {
        @Override
        public int compare(String x, String y) {
            for(int i = Math.min(x.length(), y.length())-1; i >= 0; i++) {
                if (x.charAt(i)=='1' && y.charAt(i)=='0') return 1;
                else if (x.charAt(i)=='0' && y.charAt(i)=='0') return 0;
                else if (x.charAt(i)=='0' && y.charAt(i)=='1') return -1;
            }
            return (x.length() > y.length()) ? 1 : -1;
        }
    }

    public String assignNames(vertice v) {
        if (v.children == null) {
            return "10";
        } else {
            LinkedList<String> names = new LinkedList<>();
            for (vertice w : v.children) {
                String n = assignNames(w);
                names.add(n);
            }
            names.sort(new sortBitset());
            String newName = "1";
            for (String b : names) {
                newName += b;
            }
            newName += "0";
            return newName;
        }
    }




}
