import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int M;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        arr = new int[N];
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            minValue = Math.min(minValue, arr[i]);
        }

        int left = 1;
        int right = minValue;
        int ans = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (isPossible(mid)) {
                left = mid + 1;
                ans = Math.max(ans, mid);
            }
            else {
                right = mid - 1;
            }
        }
        System.out.println(ans);
    }

    public static boolean isPossible(int num) {
        int sum = 0;

        for (int i = 0; i < N; i++) {
            sum += (arr[i] / num);
        }

        return sum >= M;
    }
}