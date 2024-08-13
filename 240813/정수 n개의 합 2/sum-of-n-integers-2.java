import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        int K = kb.nextInt();

        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = kb.nextInt();
        }

        int[] prefixSum = new int[N + 1];
        prefixSum[0] = 0;
        for (int i = 1; i <= N; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        int max = Integer.MIN_VALUE;
        for (int i = K; i <= N; i++) {
            int value = prefixSum[i] - prefixSum[i - K];
            max = Math.max(max, value);
        }

        System.out.println(max);
    }
}