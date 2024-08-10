import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int M;
    static long[] arr;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        M = kb.nextInt();

        arr = new long[M];
        for (int i = 0; i < M; i++) {
            arr[i] = kb.nextLong();
        }
        Arrays.sort(arr);

        long left = 1L;
        long right = Long.MAX_VALUE - 1;

        long minTime = Long.MAX_VALUE;

        while (left <= right) {
            long mid = (left + right) / 2L;

            if (isPossible(mid)) {
                right = mid - 1;
                minTime = Math.min(minTime, mid);
            }
            else {
                left = mid + 1;
            }
        }
        System.out.println(minTime);
    }

    public static boolean isPossible(long targetTime) {
        long sum = 0;
        for (long time : arr) {
            sum += (targetTime / time);
            if (sum >= N) {
                return true;
            }
        }
        return false;
    }
}