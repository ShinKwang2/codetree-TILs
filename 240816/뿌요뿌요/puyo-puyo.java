import java.util.*;

public class Main {
    static final int MAX_NUM = 100;

    static int N;
    static int[][] grid = new int[MAX_NUM][MAX_NUM];
    static boolean[][] visited = new boolean[MAX_NUM][MAX_NUM];

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};

    static int block;
    static int bombCnt = 0;
    static int maxBlock = 0;
    
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        N = kb.nextInt();
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                grid[r][c] = kb.nextInt();
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (!visited[r][c]) {
                    cnt = 1;
                    block = 1;
                    visited[r][c] = true;
                    DFS(r, c, grid[r][c]);

                    if (block >= 4) {
                        bombCnt++;
                    }
                    maxBlock = Math.max(maxBlock, block);
                }
            }
        }

        System.out.println(bombCnt + " " + maxBlock);
    }

    public static void DFS(int r, int c, int flag) {
        for (int d = 0; d < 4; d++) {
            int nextRow = r + dr[d];
            int nextCol = c + dc[d];

            if (nextRow < 0 || N <= nextRow || nextCol < 0 || N <= nextCol) continue;
            if (visited[nextRow][nextCol]) continue;
            if (grid[nextRow][nextCol] != flag) continue;

            block++;
            visited[nextRow][nextCol] = true;
            DFS(nextRow, nextCol, flag);
        }
    }
}