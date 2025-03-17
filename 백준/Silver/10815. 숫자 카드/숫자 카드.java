import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            sb.append(isExist(Integer.parseInt(st.nextToken()))).append(" ");
        }

        System.out.print(sb);
    }

    static int isExist(int num) {
        int left = 0;
        int right = n-1;

        int middle;
        while(left <= right) {
            middle = (left + right) / 2;

            int now = arr[middle];
            if(now == num) return 1;

            else if(now < num) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return 0;
    }
}