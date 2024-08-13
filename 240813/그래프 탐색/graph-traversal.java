import java.util.*;
import java.io.*;

public class Main {
    
    static int N;
    static int M;
    static int[][] adjMatrix;
    static List<Integer>[] adjList;
    static int count;

    static boolean[] visited;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        M = kb.nextInt();

        // 인접 행렬
        adjMatrix = new int[N + 1][N + 1];
        // 인접 리스트
        adjList = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            int start = kb.nextInt();
            int end = kb.nextInt();

            adjMatrix[start][end] = adjMatrix[end][start] = 1;
            adjList[start].add(end);
            adjList[end].add(start);
        }

        visited = new boolean[N + 1];
        visited[1] = true;
        count = 0;
        dfs_adjMatrix(1);
        System.out.println(count);

        // visited = new boolean[N + 1];
        // visited[1] = true;
        // count = 0;
        // dfs_adjList(1);
        // System.out.println(count);
    }

    public static void dfs_adjMatrix(int node) {
        for (int next = 1; next <= N; next++) {
            if (adjMatrix[node][next] == 1 && !visited[next]) {
                count++;
                visited[next] = true;
                dfs_adjMatrix(next);
            }
        }
    }

    public static void dfs_adjList(int node) {
        for (int next = 0; next < adjList[node].size(); next++) {
            int nextNode = adjList[node].get(next);
            if (!visited[nextNode]) {
                count++;
                visited[nextNode] = true;
                dfs_adjList(nextNode);
            }
        }
    }
}