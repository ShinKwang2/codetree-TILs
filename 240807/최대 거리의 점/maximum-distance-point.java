import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int M;
    static long[] arr;
    static long ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(arr);
        long MAX = arr[N - 1] - arr[0];

        long left = 1L;
        long right = MAX;

        while (left <= right) {
            long mid = (left + right) / 2L;
            long min = isPossible(mid);
            if (min != -1) {
                right = mid - 1;
                ans = Math.min(ans, min);
            }
            else {
                left = mid + 1;
            }
        }
        System.out.println(ans);
    }

    public static long isPossible(long limit) {
        int count = 0;
        long sum = 0L;
        long min = Long.MAX_VALUE;

        for (int i = 1; i < N; i++) {
            long range = arr[i] - arr[i - 1];
            if (range > limit) {
                return -1L;
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
        if (M < count + 2) {
            return -1L;
        }
        else { // M >= count + 2
            return min;
        }
    }
}