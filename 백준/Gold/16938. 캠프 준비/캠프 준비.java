import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int n, l, r, x, count;
    static long[] arr;
    static Set<String> set = new HashSet<>();
    static boolean[] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        arr = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        visit = new boolean[n];
        find(-1, -1, -1, 0);

        System.out.println(count);
    }

    static void find(int index, long min, long max, long sum) {

        if(sum >= l && sum <= r && min != -1 && max != -1 && max - min >= x) {
            String string = "";
            for (int i = 0; i < n; i++) {
                string += visit[i] + " ";
            }

            if(!set.contains(string)) {
                count ++;
                set.add(string);
            }
        }

        if(index >= n - 1 || sum > r) return;

        // 선택
        visit[index + 1] = true;
        if (min == -1) {
            find(index + 1, arr[index + 1], arr[index + 1], sum + arr[index + 1]);
        } else {
            find(index + 1, min, arr[index + 1], sum + arr[index + 1]);
        }

        // 선택 x
        visit[index + 1] = false;
        find(index + 1, min, max, sum);
    }
}

/*
1,4
1,4

 */