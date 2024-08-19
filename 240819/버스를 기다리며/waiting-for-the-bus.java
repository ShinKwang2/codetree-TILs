import java.util.*;

public class Main {
    static int N;
    static int M;
    static int C;
    static int[] arr;

    static int max = 0;
    
    static int ans = Integer.MAX_VALUE;
    
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        
        N = kb.nextInt();
        M = kb.nextInt();
        C = kb.nextInt();

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = kb.nextInt();
        }
        Arrays.sort(arr);


        int left = 0;
        int right = 10;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (isPossible(mid)) {
                right = mid - 1;
                ans = Math.min(ans, max);
            }
            else {
                left = mid + 1;
            }

        }

        System.out.println(ans);
    }

    static boolean isPossible(int targetTime) {
        int start = arr[0];
        int busCnt = 0;
        int seatCnt = 0;
        max = 0;

        for (int i = 0; i < N; i++) {
            if (seatCnt == C) { // 이전 값으로 버스에 사람이 꽉찼을 때
                seatCnt = 0; // 어차피 밑에서 그대로 arr[i] - arr[i]가 되어 ++을 하게 된다.
                start = arr[i];
                busCnt++; // 버스를 보내야하니 ++
            }
            if (arr[i] - start > targetTime) { // 이때는 이미 시간이 지났으므로 버스를 보내야만 한다.
                start = arr[i];
                busCnt++;
                seatCnt = 1;
            }
            else { // 버스 시간이 지나기 전이므로
                seatCnt++;
                max = Math.max(max, arr[i] - start);
            }
        }
        if (seatCnt != 0) {
            busCnt++;
        }

        // System.out.println("targetTime : " + targetTime);
        // System.out.println("busCnt : " + busCnt);
        // System.out.println("");

        return busCnt <= M;
    }
}