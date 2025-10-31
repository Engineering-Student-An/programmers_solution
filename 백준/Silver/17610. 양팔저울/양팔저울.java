import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] arr;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        int S = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            S += arr[i];
        }

        visit = new boolean[S + 1];

        find(0, 0);

        int count = 0;
        for (int i = 1; i <= S; i++) {
            if(!visit[i]) count ++;
        }

        System.out.println(count);
    }

    static void find(int index, int sum) {
        if(index == n) {
            visit[Math.abs(sum)] = true;
            return;
        }

        // 더하기
        find(index + 1, sum + arr[index]);
        // 빼기
        find(index + 1, sum - arr[index]);
        // 사용 x
        find(index + 1, sum);
    }
}