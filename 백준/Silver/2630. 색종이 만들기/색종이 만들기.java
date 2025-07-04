import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] arr;
    static int[] count = new int[2];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cut(0, n, 0, n);

        System.out.println(count[0] + "\n" + count[1]);
    }

    static void cut(int r1, int r2, int c1, int c2) {

        if(r1 == r2 || c1 == c2) return;

        int[] tempCount = new int[2];
        for (int i = r1; i < r2; i++) {
            for (int j = c1; j < c2; j++) {
                tempCount[arr[i][j]] ++;
            }
        }

        if(tempCount[0] == 0) {
            count[1] ++;
        } else if(tempCount[1] == 0){
            count[0] ++;
        } else {
            int mr = (r1 + r2) / 2;
            int mc = (c1 + c2) / 2;
            cut(r1, mr, c1, mc);
            cut(r1, mr, mc, c2);
            cut(mr, r2, c1, mc);
            cut(mr, r2, mc, c2);
        }
    }
}