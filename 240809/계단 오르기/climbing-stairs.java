import java.util.*;
import java.io.*;

public class Main {

    static int[] memo;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();

        memo = new int[N + 1];
        Arrays.fill(memo, -1);

        System.out.println(countStairs(N));
    }

    static int countStairs(int n) {
        if (memo[n] != -1) {
            return memo[n];
        }
        if (n == 1) memo[n] = 0;
        else if (n == 2 || n == 3) memo[n] = 1;
        else {
            memo[n] = (countStairs(n - 2) % 10007 + countStairs(n - 3) % 10007) % 10007;
        }
        return memo[n];
    }
}