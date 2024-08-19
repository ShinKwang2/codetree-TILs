import java.util.*;

public class Main {

    static final int MAX_NUM = 100;
    static int M;
    static int N;

    static int[][] grid = new int[MAX_NUM][MAX_NUM];
    static int[][] paintGrid = new int[MAX_NUM][MAX_NUM];
    static boolean[][] visited = new boolean[MAX_NUM][MAX_NUM];
    static List<int[]> locations;

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};

    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);
        M = kb.nextInt();
        N = kb.nextInt();

        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                grid[r][c] = kb.nextInt();
            }
        }
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                paintGrid[r][c] = kb.nextInt();
            }
        }

        locations = new ArrayList<>();
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (paintGrid[r][c] == 1) locations.add(new int[]{r, c});
            }
        }
        
        int left = 0;
        int right = 1_000_000_000;

        while (left <= right) {
            int mid = (left + right) / 2;

            if(isPossible(mid)) {
                right = mid - 1;
                ans = Math.min(ans, mid);
            }
            else {
                left = mid + 1;
            }
        }
        System.out.println(ans);
    }

    public static boolean isPossible(int target) {
        visited = new boolean[MAX_NUM][MAX_NUM];
        int startRow = locations.get(0)[0];
        int startCol = locations.get(0)[1];

        Queue<int[]> q = new ArrayDeque<>();
        visited[startRow][startCol] = true;
        q.add(new int[]{startRow, startCol});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int row = cur[0];
            int col = cur[1];

            for (int d = 0; d < 4; d++) {
                int nextRow = row + dr[d];
                int nextCol = col + dc[d];

                if (nextRow < 0 || M <= nextRow || nextCol < 0 || N <= nextCol) continue;
                if (visited[nextRow][nextCol]) continue;
                if (Math.abs(grid[row][col] - grid[nextRow][nextCol]) > target) continue;

                visited[nextRow][nextCol] = true;
                q.add(new int[]{nextRow, nextCol});
            }
        }

        for (int[] location : locations) {
            if (!visited[location[0]][location[1]])
                return false;
        }
        return true;
    }
}