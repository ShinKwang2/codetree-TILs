import java.util.*;

public class Main {
    static final int MAX_N = 100_000;
    // static final long SCALE = 100_000L;
    static final double LIMIT = 1_000_000_000;

    static int N;
    static double[] locations = new double[MAX_N];
    static double[] speeds = new double[MAX_N];

    // static long[] starts = new long[MAX_N];
    // static long[] ends = new long[MAX_N];

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();

        for (int i = 0; i < N; i++) {
            locations[i] = kb.nextDouble();
        }
        for (int i = 0; i < N; i++) {
            speeds[i] = kb.nextDouble();
        }
        // System.out.println(Arrays.toString(locations));
        // System.out.println(Arrays.toString(speeds));

        double left = 0;
        double right = LIMIT;
        double ans = Double.MAX_VALUE;

        for (int i = 1; i <= 1_00; i++) {
            double mid = (left + right) / 2;

            if (isPossible(mid)) {
                right = mid;
                ans = Math.min(ans, mid);
            }
            else {
                left = mid;
            }
        }
        System.out.printf("%.4f", ans);
    }

    static boolean isPossible(double time) {
        double maxStart = locations[0] - speeds[0] * time;
        double minEnd = locations[0] + speeds[0] * time;

        for (int i = 1; i < N; i++) {
            maxStart = Math.max(maxStart, locations[i] - (speeds[i] * time));
            minEnd = Math.min(minEnd, locations[i] + (speeds[i] * time));
        }
        // System.out.println("time : " + time);
        // System.out.println("maxStart : " + maxStart + " | minEnd : " + minEnd);

        return maxStart <= minEnd;
    }
}