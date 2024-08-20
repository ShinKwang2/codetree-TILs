import java.util.*;

public class Main {
    static final int MAX_N = 100;
    static final int D_RANGE = 8;

    static int N;
    static int startRow;
    static int startCol;
    static int endRow;
    static int endCol;

    static int[] dr = {-2, -2, -1, 1, 2, 2, 1, -1};
    static int[] dc = {-1, 1, 2, 2, 1, -1, -2, -2};

    static int[][] steps = new int[MAX_N][MAX_N];
    static boolean[][] visited = new boolean[MAX_N][MAX_N];
    static Queue<int[]> q = new ArrayDeque<>();

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();

        startRow = kb.nextInt() - 1;
        startCol = kb.nextInt() - 1;
        endRow = kb.nextInt() - 1;
        endCol = kb.nextInt() - 1;
        
        BFS(startRow, startCol);
        System.out.println(steps[endRow][endCol]);
    }

    public static void push(int r, int c, int step) {
        visited[r][c] = true;
        steps[r][c] = step;
        q.add(new int[]{r, c});
    }

    public static void BFS(int r, int c) {
        push(r, c, 0);

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int row = cur[0];
            int col = cur[1];

            for (int d = 0; d < D_RANGE; d++) {
                int nextRow = row + dr[d];
                int nextCol = col + dc[d];

                if (nextRow < 0 || N <= nextRow || nextCol < 0 || N <= nextCol) continue;
                if (visited[nextRow][nextCol]) continue;

                push(nextRow, nextCol, steps[row][col] + 1);
            }
        }
    }
}