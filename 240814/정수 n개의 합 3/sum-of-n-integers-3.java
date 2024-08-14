import java.util.*;

public class Main {

    static final int MAX_N = 500;

    static int n;
    static int k;
    static int[][] arr = new int[MAX_N + 1][MAX_N + 1];
    static int[][] prefixSum = new int[MAX_N + 1][MAX_N + 1];

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        k = kb.nextInt();

        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= n; c++) {
                arr[r][c] = kb.nextInt();
            }
        }

        // 누적합 배열 만들기
        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= n; c++) {
                prefixSum[r][c] = prefixSum[r - 1][c] + prefixSum[r][c - 1] - prefixSum[r - 1][c - 1] + arr[r][c];
            }
        }

        int max = 0;
        int range = k - 1;
        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= n; c++) {
                int otherRow = r + range;
                int otherCol = c + range;

                if (n < otherRow || n < otherCol) continue;

                // 누적합 계산하기
                int value = prefixSum[otherRow][otherCol] - prefixSum[r - 1][otherCol] - prefixSum[otherRow][c - 1] + prefixSum[r - 1][c - 1];
                max = Math.max(max, value);
            }
        }
        System.out.println(max);

    }
}