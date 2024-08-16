import java.util.*;

public class Main {
    static final int MAX_NUM = 100;

    static int N;
    static int K;
    static int[][] grid = new int[MAX_NUM][MAX_NUM];
    static boolean[][] visited = new boolean[MAX_NUM][MAX_NUM];

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        K = kb.nextInt();

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                grid[r][c] = kb.nextInt();
            }
        }

        for (int i = 0; i < K; i++) {
            int startRow = kb.nextInt() - 1;
            int startCol = kb.nextInt() - 1;

            if (!visited[startRow][startCol])
                System.out.println(BFS(startRow, startCol));
        }
    }

    public static int BFS(int r, int c) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{r, c});
        int cnt = 1;
        visited[r][c] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int d = 0; d < 4; d++) {
                int nextRow = curr[0] + dr[d];
                int nextCol = curr[1] + dc[d];

                if (nextRow < 0 || N <= nextRow || nextCol < 0 || N <= nextCol) continue;
                if (visited[nextRow][nextCol]) continue;
                if (grid[nextRow][nextCol] == 1) continue;

                q.add(new int[]{nextRow, nextCol});
                visited[nextRow][nextCol] = true;
                cnt++;
            }
        }

        return cnt;
    }
}