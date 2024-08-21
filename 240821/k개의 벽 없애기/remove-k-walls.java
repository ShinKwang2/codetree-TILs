import java.util.*;

public class Main {
    static final int MAX_N = 100;
    static final int MAX_K = 8;

    static int N;
    static int K;
    static int[][] grid = new int[MAX_N][MAX_N];
    static boolean[][][] visited = new boolean[MAX_K][MAX_N][MAX_N];
    static Queue<Node> q = new ArrayDeque<>();

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};

    static int startRow;
    static int startCol;
    static int endRow;
    static int endCol;

    static int ans = -1;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        K = kb.nextInt();

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                grid[r][c] = kb.nextInt();
            }
        }

        startRow = kb.nextInt() - 1;
        startCol = kb.nextInt() - 1;
        endRow = kb.nextInt() - 1;
        endCol = kb.nextInt() - 1;

        BFS(startRow, startCol, K);
        System.out.println(ans);
    }
    public static void BFS(int r, int c, int blockCnt) {
        visited[blockCnt][r][c] = true;
        q.add(new Node(r, c, blockCnt, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.row == endRow && cur.col == endCol) {
                ans = cur.time;
                break;
            }

            for (int d = 0; d < 4; d++) {
                int nextRow = cur.row + dr[d];
                int nextCol = cur.col + dc[d];

                if (nextRow < 0 || N <= nextRow || nextCol < 0 || N <= nextCol) continue;
                if (grid[nextRow][nextCol] == 0 && !visited[cur.blockCnt][nextRow][nextCol]) { // 장애물이 없는 곳이면서, 방문하지 않았다면
                    visited[cur.blockCnt][nextRow][nextCol] = true;
                    q.add(new Node(nextRow, nextCol, cur.blockCnt, cur.time + 1));
                }
                if (grid[nextRow][nextCol] == 1 && cur.blockCnt > 0 && !visited[cur.blockCnt - 1][nextRow][nextCol]) { // 장애물인데, 부실 수 있는 개수가 남았다면
                    visited[cur.blockCnt - 1][nextRow][nextCol] = true;
                    q.add(new Node(nextRow, nextCol, cur.blockCnt - 1, cur.time + 1));
                }
            }
            
        }

    }

    static class Node {
        int row;
        int col;
        int blockCnt;
        int time;

        Node(int r, int c, int b, int t) {
            row = r;
            col = c;
            blockCnt = b;
            time = t;
        }
    }
}