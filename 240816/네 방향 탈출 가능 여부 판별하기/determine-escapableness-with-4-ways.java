import java.util.*;

public class Main {

    static int MAX_NUM = 100;
    static int[][] grid = new int[MAX_NUM][MAX_NUM];
    static boolean[][] visited = new boolean[MAX_NUM][MAX_NUM];

    static int N;
    static int M;

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        M = kb.nextInt();

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                grid[r][c] = kb.nextInt();
            }
        }
        BFS(0, 0);
        if (visited[N -1][M - 1]) {
            System.out.println(1);
        }
        else {
            System.out.println(0);
        }
    }

    public static void BFS(int r, int c) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{r, c});
        visited[r][c] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int curRow = curr[0];
            int curCol = curr[1];

            for (int d = 0; d < 4; d++) {
                int nextRow = curRow + dr[d];
                int nextCol = curCol + dc[d];

                if (nextRow < 0 || N <= nextRow || nextCol < 0 || M <= nextCol) continue;
                if (visited[nextRow][nextCol]) continue;
                if (grid[nextRow][nextCol] == 0) continue;

                visited[nextRow][nextCol] = true;
                q.add(new int[]{nextRow, nextCol});
            }
        }
    }
}