package K2;

import java.util.Scanner;

public class B11B {
    public static void main(String[] args) {
        new B11B().run();
    }

    class Cell {
        char field;
        int f;

        public Cell(char field) {
            this.field = field;
            this.f = Integer.MAX_VALUE;
        }
    }
    Cell[][] grid;
    int h;
    int w;
    int dly;
    void run() {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for (int c = 0; c < cases ; c++) {
            h = sc.nextInt();
            w = sc.nextInt();
            dly = sc.nextInt();

            grid = new Cell[h][w];
            int x = 0; int y = 0;
            for (int i = 0; i < h; i++) {
                String s = sc.next();
                for (int j = 0; j < w; j++) {
                    grid[i][j] = new Cell(s.charAt(j));
                    if (s.charAt(j) == 'S') {
                        x = i; y = j;
                    }
                }
            }
            search(x, y, 0);
            int min = Integer.MAX_VALUE;
            System.out.println(grid[5][2].f);
        }
    }

    void search(int i, int j, int d) {
        if (i == 0 || i == h-1 || j == 0 || j == w-1 && grid[i][j].field != '#') {
            grid[i][j].f = Math.min(grid[i][j].f, d);
            return;
        }
        if (grid[i][j].field != '#' && d < grid[i][j].f) {
            grid[i][j].f = d+1;
            if (grid[i][j].field == '@') {
                grid[i][j].f += dly;
            }
            search(i+1, j, grid[i][j].f);
            search(i-1, j, grid[i][j].f);
            search(i, j+1, grid[i][j].f);
            search(i, j-1, grid[i][j].f);
        }
    }
}
