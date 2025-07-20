import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            turn(s, num);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(arr[i]).append(" ");
            if(i % 20 == 0) sb.append("\n");
        }

        System.out.print(sb);
    }

    static void turn(int s, int num) {

        if(s == 1) {
            for (int i = num; i <= n; i+=num) {
                arr[i] = (arr[i] + 1) % 2;
            }
        } else {
            arr[num] = (arr[num] + 1) % 2;
            for (int i = 1; num - i > 0 && num + i <= n; i++) {
                if(arr[num - i] == arr[num + i]) {
                    arr[num - i] = (arr[num - i] + 1) % 2;
                    arr[num + i] = (arr[num + i] + 1) % 2;
                } else break;
            }
        }
    }
}