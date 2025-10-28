import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int find = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];
        int r = (n/2), c = (n/2);
        int[] dirRow = {-1, 0, 1, 0}, dirCol = {0, 1, 0, -1};
        int plus = 1, plusCount = 0, twoCount = 0;

        int dir = 0;
        int num = 1;

        int findR = 0, findC = 0;
        while(num <= n * n) {
            arr[r][c] = num;
            if(num == find) {
                findR = r + 1;
                findC = c + 1;
            }
            num ++;

            r += dirRow[dir];
            c += dirCol[dir];


            plusCount ++;
            if(plus == plusCount) {
                dir = (dir + 1) % 4;
                plusCount = 0;
                twoCount ++;
            }

            if(twoCount == 2) {
                plus ++;
                twoCount = 0;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
        System.out.println(findR + " " + findC);
    }
}