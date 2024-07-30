import java.util.*;
import java.io.*;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());

        arr = new int[N];
        token = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(token.nextToken());
            arr[i] = value;
        }
        
        token = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(token.nextToken());
            System.out.println(binarySearch(target));
        }
    }

    static int binarySearch(int target) {
        int left = 0;
        int right = arr.length - 1;
        int minIdx = arr.length;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] >= target) {
                right = mid - 1;
                minIdx = Math.min(minIdx, mid);
            }
            else {
                left = mid + 1;
            }
        }
        return arr[minIdx] == target ? minIdx + 1 : -1;
    }
}