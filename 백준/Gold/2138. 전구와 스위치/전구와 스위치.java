import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static boolean[][] arr;
    static boolean[] result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new boolean[2][n];
        String line = br.readLine();
        for (int i = 0; i < n; i++) {
            arr[0][i] = line.charAt(i) - '0' != 0;
            arr[1][i] = arr[0][i];
        }

        line = br.readLine();
        result = new boolean[n];
        for (int i = 0; i < n; i++) {
            result[i] = line.charAt(i) - '0' != 0;
        }

        // 첫번째 안누름
        int count= find(0);
        
        // 첫번째 누름
        arr[1][0] = !arr[1][0];
        arr[1][1] = !arr[1][1];
        count = Math.min(count, find(1));


        System.out.println(count != Integer.MAX_VALUE ? count : -1);
    }

    static int find(int i) {
        int count = (i == 0) ? 0 : 1;

        for (int j = 1; j < n; j++) {
            if(arr[i][j - 1] != result[j - 1]) {
                count ++;
                arr[i][j - 1] = !arr[i][j - 1];
                arr[i][j] = !arr[i][j];
                if(j < n - 1) arr[i][j + 1] = !arr[i][j + 1];
            }
        }

        if(arr[i][n-1] != result[n-1]) return Integer.MAX_VALUE;
        return count;
    }
}