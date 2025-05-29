import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m, t, k;
    static long[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        k = 1;
        while(k < n) {
            k *= 2;
        }

        int size = k * 2;
        arr = new long[size];
        for (int i = 0; i < n; i++) {
            arr[i + k] = Long.parseLong(br.readLine());
        }

        for (int i = k-1; i >= 1; i--) {
            arr[i] = arr[i * 2] + arr[i * 2 + 1];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m + t; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if(a == 1) {
                swap(b, c);
            } else {
                sb.append(partSum(b, (int) c)).append("\n");
            }
        }
        System.out.print(sb);
    }

    static void swap(int s, long num) {
        s += k - 1;
        long diff = num - arr[s];
        while(s >= 1) {
            arr[s] += diff;
            s /= 2;
        }
    }

    static long partSum(int s, int e) {
        s += k - 1;
        e += k - 1;

        long sum = 0;
        while(s <= e) {
            if(s % 2 == 1) {
                sum += arr[s];
            }
            if(e % 2 == 0) {
                sum += arr[e];
            }

            s = (s + 1) / 2;
            e = (e - 1) / 2;
        }

        return sum;
    }
}