import java.util.*;

public class Main {
    static final int MAX_INDEX = 50;
    static final int MAX_NUM = 100;

    static int N;
    static int M;
    static int[][] grid = new int[MAX_INDEX][MAX_INDEX];
    static boolean[][] visited;

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0 , 1};
    
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        N = kb.nextInt();
        M = kb.nextInt();

        int MAX_K = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                grid[r][c] = kb.nextInt();
                MAX_K = Math.max(MAX_K, grid[r][c]);
            }
        }

        int max = 0;
        int maxValue = 0;

        for (int k = 1; k <= MAX_K; k++) {
            visited = new boolean[N][M];
            int cnt = 0;

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (!visited[r][c] && grid[r][c] > k) {
                        cnt++;
                        dfs(r, c, k);
                    }
                }
            }

            if (cnt > maxValue) {
                max = k;
                maxValue = cnt;
            }
        }
        System.out.println(max + " " + maxValue);
    }

    public static void dfs(int r, int c, int k) {

        for (int d = 0; d < 4; d++) {
            int nextRow = r + dr[d];
            int nextCol = c + dc[d];

            if (nextRow < 0 || N <= nextRow || nextCol < 0 || M <= nextCol) continue;
            if (visited[nextRow][nextCol]) continue;
            if (grid[nextRow][nextCol] <= k) continue;

            visited[nextRow][nextCol] = true;
            dfs(nextRow, nextCol, k);
        }
    }
}