import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_N = 100000;

    static int N;
    static Pair[] segments = new Pair[MAX_N];

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        // 입력:
        N = sc.nextInt();
        for(int i = 0; i < N; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            segments[i] = new Pair(x1, x2);
        }
        
        // 구간을 시작점이 빠른 순으로 정렬합니다.
        Arrays.sort(segments, 0, N);
        
        int lo = 1;                               // 답이 될 수 있는 가장 작은 숫자 값을 설정합니다.
        int hi = (int)1e9;                        // 답이 될 수 있는  가장 큰 숫자 값을 설정합니다.
        int ans = 0;                              // 답을 저장합니다.
        
        while(lo <= hi) {                         // [lo, hi]가 유효한 구간이면 계속 수행합니다.
            int mid = (lo + hi) / 2;              // 가운데 위치를 선택합니다.

            if(isPossible(mid)) {                 // 결정문제에 대한 답이 Yes라면
                lo = mid + 1;                     // 오른쪽에 조건을 만족하는 숫자가 더 있을 가능성 때문에 lo를 바꿔줍니다.
                ans = Math.max(ans, mid);              // 답의 후보들 중 최댓값을 계속 갱신해줍니다.
            }
            else hi = mid - 1;                    // 결정문제에 대한 답이 No라면 hi를 바꿔줍니다.
        }
        
        // 정답을 출력합니다.
        System.out.print(ans);  
    }

    public static boolean isPossible(int mid) {
        int current = segments[0].start;
        for (int i = 1; i < N;i++) {
            int nextStart = segments[i].start;
            int nextEnd = segments[i].end;

            if (nextEnd < current + mid) {
                return false;
            }
            current = Math.max(current + mid, nextStart);
            // 이미 current + mid가 nextStart 보다 작으면
            // 어차피 mid 값보다 크기만 하면 되기 때문에 start가 최적의 시작 위치다.
            // 반대로 current + mid가 nextStart 보다 크다면 거기서 부터 시작해야한다.
        }
        return true;
    }

    static class Pair implements Comparable<Pair> {
        int start;
        int end;
        
        Pair (int s, int e) {
            start = s;
            end = e;
        }
        @Override
        public int compareTo(Pair b) {
            if (start != b.start) return start - b.start;
            return end - b.end;
        }
    }
}