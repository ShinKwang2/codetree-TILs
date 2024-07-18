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

        // 가로
        int sum = 0;

        for (int r = 0; r < N; r++) {
            int sequenceCount = 1;
            int currentNumber = -1;
            for (int c = 0; c < N; c++) {
                if (sequenceCount >= M) {
                    sum++;
                    sequenceCount = 1;
                    break;
                }
                if (map[r][c] == currentNumber) {
                    sequenceCount++;
                }
                else {
                    sequenceCount = 1;
                    currentNumber = map[r][c];
                }
            }
            if (sequenceCount >= M) {
                sum++;
                sequenceCount = 1;
            }
        }

        for (int c = 0; c < N; c++) {
            int sequenceCount = 1;
            int currentNumber = -1;
            for (int r = 0; r < N; r++) {
                if (sequenceCount >= M) {
                    sum++;
                    sequenceCount = 1;
                    break;
                }
                if (map[r][c] == currentNumber) {
                    sequenceCount++;
                }
                else {
                    sequenceCount = 1;
                    currentNumber = map[r][c];
                }
            }
            if (sequenceCount >= M) {
                sum++;
                sequenceCount = 1;
            }
        }

        System.out.println(sum);
    }
}