import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();

        if (N <= 3) {
            System.out.println(1);
            return;
        }

        int[] dp = new int[N + 1];
        dp[0] = 1;
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;

        for (int i = 4; i <= N; i++) {
            dp[i] = (dp[i - 2] % 10007 + dp[i - 3] % 10007) % 10007;
        }
        System.out.println(dp[N]);
    }
}