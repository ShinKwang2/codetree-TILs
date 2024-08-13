import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {1, 0};
    static int[] dc = {0, 1};

    static boolean flag = false;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        M = kb.nextInt();

        map = new int[N][M];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                map[r][c] = kb.nextInt();
            }
        }

        visited = new boolean[N][M];
        visited[0][0] = true;
        dfs(0, 0);
        System.out.println(flag ? 1 : 0);
    }

    public static void dfs(int r, int c) {
        // System.out.println("r: " + r + "c: " + c);

        for (int d = 0; d < 2; d++) {
            int nextRow = r + dr[d];
            int nextCol = c + dc[d];

            if (nextRow < 0 || N <= nextRow || nextCol < 0 || M <= nextCol) continue; // 경계처리
            if (visited[nextRow][nextCol]) continue; // 이미 방문
            if (map[nextRow][nextCol] == 0) continue; // 뱀자리

            // System.out.println("nextRow: " + nextRow + " nextCol: " + nextCol);
            // System.out.println("N: " + N + " M: " + M);

            if (nextRow == N - 1 && nextCol == M - 1) {
                flag = true;
            }
            visited[nextRow][nextCol] = true;
            dfs(nextRow, nextCol);
        }
    }
}