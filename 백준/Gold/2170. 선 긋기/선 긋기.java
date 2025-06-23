import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long sum = 0;
        int l, r;

        Info[] arr = new Info[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(arr, (o1, o2) -> Integer.compare(o1.s, o2.s));

        if(n == 1) {
            System.out.println(arr[0].e - arr[0].s);
        } else {
            l = arr[0].s;
            r = arr[0].e;

            for (int i = 1; i < n; i++) {
                Info now = arr[i];
                if (now.s > r) {
                    sum += (r - l);
                    l = now.s;
                    r = now.e;
                } else {
                    l = Math.min(l, now.s);
                    r = Math.max(r, now.e);
                }

                if (i == n - 1) {
                    sum += (r - l);
                }
            }

            System.out.println(sum);
        }
    }

    static class Info {
        int s, e;

        public Info(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }
}