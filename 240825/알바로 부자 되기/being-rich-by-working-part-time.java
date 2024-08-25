import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new 	InputStreamReader(System.in));
	int n = Integer.parseInt(br.readLine());
        Node[] board = new Node[n];
        int[] dp = new int[n]; // dp[i] -> i번째 알바 진행 시 최대로 돈을 버는 값
        for(int i = 0; i < n; i++) {
            String[] _s = br.readLine().split(" ");
            int s = Integer.parseInt(_s[0]);
            int e = Integer.parseInt(_s[1]);
            int p = Integer.parseInt(_s[2]);

            board[i] = new Node(s, e, p);
            dp[i] = p; // i번 알바만 할경우 벌 수 있는 돈
        }

        dp[0] = board[0].p;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(board[i].s > board[j].e) {
                    dp[i] = Math.max(dp[i], dp[j] + board[i].p);
                }
            }
        }
        // System.out.println(Arrays.toString(dp));
        int res = 0;
        for(int i = 0; i < n; i++) {
            res = Math.max(res, dp[i]);
        }
        System.out.println(res);
    }

    static class Node {
        int s, e, p;

        Node(int s, int e, int p) {
            this.s = s;
            this.e = e;
            this.p = p;
        }
    }
}