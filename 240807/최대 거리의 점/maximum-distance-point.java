import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int M;
    static int[] arr;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int MAX = arr[N - 1] - arr[0];

        int left = 1;
        int right = MAX;

        while (left <= right) {
            int mid = (left + right) / 2;
            int min = isPossible(mid);
            if (min > 0) {
                ans = Math.min(ans, min);
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        System.out.println(ans);
    }

    public static int isPossible(int limit) {
        int count = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 1; i < N; i++) {
            int range = arr[i] - arr[i - 1];
            if (range > limit) {
                return -1;
            }

            if (sum + range > limit) {
                min = Math.min(min, sum);
                sum = range;
                count++;
            }
            else {
                sum += range;
            }
        }
        min = Math.min(min, sum);
        // System.out.println("count : " + count);
        // System.out.println("min : " + min);
        if (M - 2 < count) {
            return -1;
        }
        else {
            return min;
        }
    }
}