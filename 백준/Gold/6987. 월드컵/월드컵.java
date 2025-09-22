import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] sequence = new int[][]{
            {0, 1}, {0, 2}, {0, 3}, {0, 4}, {0, 5},
            {1, 2}, {1, 3}, {1, 4}, {1, 5},
            {2, 3}, {2, 4}, {2, 5},
            {3, 4}, {3, 5},
            {4, 5}
    };
    static int[][] result;
    static int[][][] arr = new int[4][6][3];
    static boolean[] isPossible = new boolean[4];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 3; k++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        for (int k = 0; k < 4; k++) {
            result = new int[6][6];
            find(k, 0);
        }


        for (int i = 0; i < 4; i++) System.out.print(isPossible[i] ? "1 " : "0 ");
    }

    static boolean check(int k) {
        for (int i = 0; i < 6; i++) {
            int w = 0;
            int d = 0;
            int l = 0;

            for (int j = 0; j < 6; j++) {
                if(i == j) continue;
                if(result[i][j] == 1) w ++;
                else if(result[i][j] == 0) d ++;
                else l ++;
            }

            if(arr[k][i][0] != w || arr[k][i][1] != d || arr[k][i][2] != l) return false;
        }
        return true;
    }

    static void find(int k, int index) {
        if(index == 15) {
            if(check(k)) isPossible[k] = true;
            return;
        }

        for (int i = -1; i <= 1; i++) {
            result[sequence[index][0]][sequence[index][1]] = i;
            result[sequence[index][1]][sequence[index][0]] = i * -1;
            find(k, index + 1);

            if(isPossible[k]) return;
        }
    }
}