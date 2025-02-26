import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final int INF = 5000000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        String[] nums = line.split(" ");

        int[][] power = {{0, 2, 2, 2, 2},
                {2, 1, 3, 4, 3},
                {2, 3, 1, 3, 4},
                {2, 4, 3, 1, 3},
                {2, 3, 4, 3, 1}};

        int[][][] arr = new int[nums.length][5][5];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    arr[i][j][k] = INF;
                }
            }
        }
        arr[0][0][0] = 0;

        for (int i = 0; i < nums.length - 1; i++) {

            int num = nums[i].charAt(0) - '0';

            // 왼발 움직이는 경우
            for (int j = 0; j < 5; j++) {
                if(j == num) continue;
                for (int k = 0; k < 5; k++) {
                    arr[i+1][num][j] = Math.min(arr[i+1][num][j], arr[i][k][j] + power[k][num]);
                }
            }

            // 오른발 움직이는 경우
            for (int j = 0; j < 5; j++) {
                if(j == num) continue;
                for (int k = 0; k < 5; k++) {
                    arr[i+1][j][num] = Math.min(arr[i+1][j][num], arr[i][j][k] + power[k][num]);
                }
            }
        }

        int result = INF;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                result = Math.min(arr[nums.length - 1][i][j], result);
            }
        }

        System.out.println(result);
    }
}