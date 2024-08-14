import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();

        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = kb.nextInt();
        }        

        // 누적합 배열 만들기
        int[] prefixSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        int left = 0;
        int right = 1;
        int cnt = 0;

        while (right <= n) {
            int value = prefixSum[right] - prefixSum[left];
            if (value <= k) {
                if (value == k) cnt++;
                right++;
            }
            else {
                
                left++;
            }
        }
        System.out.println(cnt);
    }
}