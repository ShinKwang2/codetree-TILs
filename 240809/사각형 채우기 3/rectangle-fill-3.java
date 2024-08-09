import java.util.*;
import java.io.*;

public class Main {

    static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();

        int[] dp = new int[N + 1];
        dp[0] = 1;
        dp[1] = 2;

        for (int i = 2; i <= N; i++) {
            dp[i] = ((dp[i - 1] * 2 % MOD) + (dp[i - 2] * 3 % MOD)) % MOD;
        }
        System.out.println(dp[N]);
    }
}