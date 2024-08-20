import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());

        int[][] map = new int[N][N];

        for (int r = 0; r < N; r++) {
            token = new StringTokenizer(br.readLine(), " ");
            for (int c = 0; c < N; c++) {
                int value = Integer.parseInt(token.nextToken());
                map[r][c] = value;
            }
        }


        int sum = 0;

        // 가로
        for (int r = 0; r < N; r++) {
            int max = 1;
            int sequenceCount = 1;
            int currentNumber = map[r][0];
            for (int c = 1; c < N; c++) {
                if (currentNumber != map[r][c]) {
                    max = Math.max(max, sequenceCount);
                    sequenceCount = 1;
                    currentNumber = map[r][c];
                }
                else {
                    sequenceCount++;
                }
            }
            max = Math.max(max, sequenceCount);
            if (max >= M) {
                sum++;
            }
        }
        // 세로
        for (int c = 0; c < N; c++) {
            int max = 1;
            int sequenceCount = 1;
            int currentNumber = map[0][c];
            for (int r = 1; r < N; r++) {
                if (currentNumber != map[r][c]) {
                    max = Math.max(max, sequenceCount);
                    sequenceCount = 1;
                    currentNumber = map[r][c];
                }
                else {
                    sequenceCount++;
                }
            }
            max = Math.max(max, sequenceCount);
            if (max >= M) {
                sum++;
            }
        }

        System.out.println(sum);
    }
}