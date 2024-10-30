import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static long[] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        arr = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            long num = Long.parseLong(st.nextToken());

            sb.append( (findNum(num, 0, n-1) ? 1 : 0)).append("\n");
        }

        System.out.print(sb);
    }

    private static boolean findNum(long num, int start, int end) {

        while(start <= end) {
            int middle = (start + end) / 2;
            if(arr[middle] == num) {
                return true;
            } else if(arr[middle] > num) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        return false;
    }
}