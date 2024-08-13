import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[][] map;

    static int[][] visited;
    static int flag = 0;

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();

        map = new int[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                map[r][c] = kb.nextInt();
            }
        }

        visited = new int[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (map[r][c] == 1 && visited[r][c] == 0) { 
                    flag++;
                    visited[r][c] = flag;
                    DFS(r, c);
                }
            }
        }

        Map<Integer, Integer> record = new HashMap<>();
        int max = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                int value = visited[r][c];
                if (value != 0) {
                    record.put(value, record.getOrDefault(value, 0) + 1);
                    max = Math.max(max, value);
                }
            }
        }
        System.out.println(max);
        Queue<Integer> pq = new PriorityQueue<>();
        for (int key : record.keySet()) {
            pq.add(record.get(key));
        }
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }

    public static void DFS(int r, int c) {

        for (int d = 0; d < 4; d++) {
            int nextRow = r + dr[d];
            int nextCol = c + dc[d];

            if (nextRow < 0 || N <= nextRow || nextCol < 0 || N <= nextCol) continue;
            if (visited[nextRow][nextCol] != 0) continue;
            if (map[nextRow][nextCol] == 0) continue;

            visited[nextRow][nextCol] = flag;
            DFS(nextRow, nextCol);
        }
    }
}