import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int LIMIT;
    static int[][] map;
    static int MAX_VALUE = 1_000_000;
    // static int MAX_VALUE = 5000;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        LIMIT = N * N;

        map = new int[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                map[r][c] = kb.nextInt();
            }
        }

        int left = 0;
        int right = MAX_VALUE;
        int ans = MAX_VALUE;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (isPossible(mid)) {
                right = mid - 1;
                ans = Math.min(ans, mid);
            }
            else {
                left = mid + 1;
            }
        }
        System.out.println(ans);
    }

    public static boolean isPossible(int mid) {
        int[][] visited = new int[N][N];
        int flag = 0;

        int max = 0;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (visited[r][c] == 0) {
                    flag++;
                    int value = bfs(r, c, mid, flag, visited);
                    max = Math.max(max, value);
                }
            }
        }

        // System.out.println("max :" + max);
        // for (int i = 0; i < N; i++) {
        //     for (int j = 0; j < N; j++) {
        //         System.out.print(visited[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        // System.out.println();

        return max >= (LIMIT % 2 == 0 ? LIMIT / 2 : LIMIT / 2 + 1);
    }
    public static int bfs(int r, int c, int mid, int flag, int[][] visited) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{r, c});
        visited[r][c] = flag;
        int count = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int row = cur[0];
            int col = cur[1];

            for (int d = 0; d < 4; d++) {
                int nextRow = row + dr[d];
                int nextCol = col + dc[d];

                if (nextRow < 0 || N <= nextRow || nextCol < 0 || N <= nextCol || visited[nextRow][nextCol] != 0) continue; // 경계처리 및 방문처리
                if (Math.abs(map[row][col] - map[nextRow][nextCol]) <= mid) {
                    q.add(new int[]{nextRow, nextCol});
                    visited[nextRow][nextCol] = flag;
                    count++;
                }
            }
        }
        return count;
    }
}