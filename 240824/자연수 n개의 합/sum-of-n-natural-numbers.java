import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        long S = kb.nextLong();

        long left = 1L;
        long right = 20_000_000_000L;
        long maxNum = 0L;

        while (left <= right) {
            long mid = (left + right) / 2L;
            long sum = mid * (mid + 1L) / 2L;
            if (sum <= S) {
                left = mid + 1L;
                maxNum = Math.max(maxNum, mid);
            }
            else {
                right = mid - 1L;
            }
        }
        System.out.println(maxNum);
    }
}