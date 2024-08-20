import java.util.*;

public class Main {
    static final int MAX_N = 50_000;

    static int N;
    static int K;
    static int[] arr = new int[MAX_N];

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        K = kb.nextInt();

        for (int i = 0; i < N; i++) {
            arr[i] = kb.nextInt();
        }
        Arrays.sort(arr, 0, N);

        int left = 0;
        int right = 1_000_000_000;
        int ans = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (isPossible(mid)) {
                right = mid - 1;
                ans = Math.min(ans, mid);
            }
            else {
                left = mid + 1;
            }
        }
        System.out.println(ans);
    }

    static boolean isPossible(int range) {
        int bombCnt = 0;
        int start = Integer.MIN_VALUE;
        int end = start + (range * 2);

        for (int i = 0; i < N; i++) {
            int cur = arr[i];
            if (cur > end) {
                bombCnt++;
                start = cur;
                end = start + (range * 2);
            }
        }
        // System.out.println("bomb : " + bombCnt);
        return bombCnt <= K;
    }
}