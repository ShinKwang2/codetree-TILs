import java.util.*;
import java.io.*;

public class Main {

    static int[] memo;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();

        memo = new int[N + 1];


        System.out.println(getCounts(N));
    }
    static int getCounts(int n) {
        if (memo[n] != 0) {
            return memo[n];
        }

        if (n <= 1) {
            memo[n] = 1;
        }
        else {
            memo[n] = (getCounts(n - 1) + getCounts(n - 2)) % 10007;
        }

        return memo[n];
    }
}