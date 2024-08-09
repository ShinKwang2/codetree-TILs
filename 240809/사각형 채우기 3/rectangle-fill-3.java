import java.util.*;
import java.io.*;

public class Main {

    static final int MOD = 1_000_000_007;
    static int[] memo = new int[1000 + 1];

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();

        Arrays.fill(memo, -1);

        // int[] dp = new int[1000 + 1];
        // dp[0] = 1;
        // dp[1] = 2;
        // dp[2] = 7;

        // for (int i = 3; i <= N; i++) {
        //     dp[i] = ((dp[i - 1] * 2 % MOD) + (dp[i - 2] * 3 % MOD) + (dp[i - 3] * 2 % MOD) + dp[i - 4] * 2) % MOD;
        // }
        // System.out.println(Arrays.toString(dp));
        // System.out.println(dp[N]);
        int answer = getCounts(N);
        // System.out.println(Arrays.toString(memo));
        System.out.println(answer);
    }

    static int getCounts(int n) {
        if (n < 0) { // 음수면 0 
            return 0;
        }
        if (memo[n] != -1) {
            return memo[n];
        }

        if (n == 0) {
            memo[n] = 1;
        }
        else if (n == 1) {
            memo[n] = 2;
        }
        else if (n == 2) {
            memo[n] = 7;
        }
        else {
            memo[n] = (getCounts(n - 1) * 2 % MOD + getCounts(n - 2) * 3 % MOD + getCounts(n - 3) * 2 % MOD + getCounts(n - 4) * 2 % MOD) % MOD;
        }
        return memo[n];
    }
}