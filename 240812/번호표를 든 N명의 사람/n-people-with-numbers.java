import java.util.*;
import java.util.*;

public class Main {

    static int N;
    static int MAX_TIME;
    static int[] people;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        MAX_TIME = kb.nextInt();

        people = new int[N];
        for (int i = 0; i < N; i++) {
            people[i] = kb.nextInt();
        }

        int left = 1;
        int right = MAX_TIME;
        int ans = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (isPossible(mid)) {
                right = mid - 1;
                ans = Math.min(ans, mid);
            }
            else {
                left = mid + 1;
            }
        }
        System.out.println(ans);
    }

    static boolean isPossible(int size) {
        Queue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < (size < N ? size : N); i++) {
            pq.add(people[i]);
        }
        for (int i = size; i < N; i++) {
            int min = pq.poll();
            min += people[i];
            pq.add(min);
        }
        int max = 0;
        while (!pq.isEmpty()) {
            max = Math.max(max, pq.poll());
        }
        return max <= MAX_TIME;
    }
}