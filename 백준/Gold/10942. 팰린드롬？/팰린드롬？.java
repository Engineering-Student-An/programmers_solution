import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] arr;
    static int[][] pal;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        pal = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            check(i, i);
            if(i < n) check(i, i+1);
        }

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(pal[a][b]).append("\n");
        }
        System.out.print(sb);
    }

    static void check(int leftIndex, int rightIndex) {
        while(leftIndex > 0 && rightIndex <= n) {
            int left = arr[leftIndex];
            int right = arr[rightIndex];

            if(left == right) {
                pal[leftIndex][rightIndex] = 1;
                leftIndex --;
                rightIndex ++;
            } else {
                break;
            }
        }
    }
}