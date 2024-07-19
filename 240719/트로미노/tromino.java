import java.util.*;

public class Main {

    static int[][] dr = { {-1, 0}, {-1, 0}, {1, 0}, {1, 0}, {0, 0}, {-1, 1} };
    static int[][] dc = { {0, -1}, {0, 1}, {0, -1}, {0, 1}, {-1, 1}, {0, 0} };

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner kb = new Scanner(System.in);
        int ROW = kb.nextInt();
        int COL = kb.nextInt();

        int[][] map = new int[ROW][COL];
        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                map[r][c] = kb.nextInt();
            }
        }

        int LANGE = 6;
        int max = 0;

        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                for (int k = 0; k < LANGE; k++) {
                    int first_row = r + dr[k][0];
                    int second_row = r + dr[k][1];

                    int first_col = c + dc[k][0];
                    int second_col = c + dc[k][1];

                    if (first_row < 0 || ROW <= first_row) continue;
                    if (second_row < 0 || ROW <= second_row) continue;
                    if (first_col < 0 || COL <= first_col) continue;
                    if (second_col < 0 || COL <= second_col) continue;

                    int sum = map[r][c] + map[first_row][first_col] + map[second_row][second_col];
                    max = Math.max(max, sum);
                }
            }
        }
        System.out.println(max);
    }
}