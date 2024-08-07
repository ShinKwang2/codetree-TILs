import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        long N = kb.nextLong();
        long min = Long.MAX_VALUE;

        long left = 1L;
        long right = Long.MAX_VALUE - 1L;

        while (left <= right) {
            long mid = (left + right) / 2;

            if (getNumberCount(mid) >= N) {
                min = Math.min(min, mid);
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        System.out.println(min);
    }

    public static long getNumberCount(long target) {
        long tmp = (target / 3) + (target / 5) - (target / 15);
        return target - tmp;
    }
}