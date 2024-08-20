import java.util.*;

public class Main {
    static final int MAX_NUM = 100;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    static int N;
    static int M;
    static int[][] grid = new int[MAX_NUM][MAX_NUM];
    static int[][] visited = new int[MAX_NUM][MAX_NUM];

    static Queue<int[]> q = new ArrayDeque<>();

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        M = kb.nextInt();

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                grid[r][c] = kb.nextInt();
            }
        }
        BFS();

        int ans = visited[N - 1][M - 1];
        System.out.println(ans == 0 ? -1 : ans);
    }

    public static void push(int r, int c, int step) {
        visited[r][c] = step;
        q.add(new int[]{r, c});
    }

    public static void BFS() {
        push(0, 0, 0);

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int row = cur[0];
            int col = cur[1];
            // System.out.println("cur - row : " + row + " col : " + col);

            for (int d = 0; d < 4; d++) {
                int nextRow = row + dr[d];
                int nextCol = col + dc[d];

                if (nextRow < 0 || N <= nextRow || nextCol < 0 || M <= nextCol) continue;
                if (visited[nextRow][nextCol] != 0) continue;
                if (grid[nextRow][nextCol] != 1) continue;

                push(nextRow, nextCol, visited[row][col] + 1);
            }
        }
    }
}