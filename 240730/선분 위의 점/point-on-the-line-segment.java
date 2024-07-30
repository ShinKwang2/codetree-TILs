import java.util.*;
import java.io.*;

public class Main {

    static int[] targets;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());

        targets = new int[N];
        token = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int target = Integer.parseInt(token.nextToken());
            targets[i] = target;
        }

        for (int i = 0; i < M; i++) {
            token = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(token.nextToken());
            int end = Integer.parseInt(token.nextToken());

            System.out.println(isInclude(start, end));
        }


    }

    static int isInclude(int start, int end) {
        int count = 0;
        int range = end - start;

        for (int target : targets) {
            int value = target - start;

            if (0 <= value && value <= range) {
                count++;
            }
        }
        return count;
    } 
}