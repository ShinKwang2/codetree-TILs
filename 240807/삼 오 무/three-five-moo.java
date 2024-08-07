import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        int min = Integer.MAX_VALUE;

        int left = 1;
        int right = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = (left + right) / 2;

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

    public static int getNumberCount(int target) {
        int byThree = target / 3;
        int byFive = target / 5;
        int same = target / 15;

        int tmp = byThree + byFive - same;

        return target - tmp;
    }
}