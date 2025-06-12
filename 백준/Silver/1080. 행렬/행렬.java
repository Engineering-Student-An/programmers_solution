import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] arr, next;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        next = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                next[i][j] = line.charAt(j) - '0';
            }
        }

        int count = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 2; j++) {
                if(arr[i][j] != next[i][j]) {
                    count ++;
                    swap(i, j);
                }
            }
        }

        boolean check = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] != next[i][j]) check = false;
            }
        }

        System.out.println((check) ? count : -1);
    }

    static void swap(int a, int b) {
        for (int i = a; i <= a + 2; i++) {
            for (int j = b; j <= b + 2; j++) {
                arr[i][j] = (arr[i][j] + 1) % 2;
            }
        }
    }
}