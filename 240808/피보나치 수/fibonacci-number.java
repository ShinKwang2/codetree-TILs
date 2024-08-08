import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();

        int[] dp = new int[N + 1];
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i < N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println(dp[N]);
    }
}