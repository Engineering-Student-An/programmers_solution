import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, k;
    static long[] arr;
    static int size;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        
        k = 0;
        while (Math.pow(2, k) <= n) {
            k++;
        }

        size = (int) Math.pow(2, k+1);
        arr = new long[size];
        for (int i = size/2; i < size/2 + n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        for (int i = size/2 - 1; i > 0; i--) {
            arr[i] = arr[i*2] + arr[i*2 + 1];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m + t; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());


            if(a == 1) {
                int b = Integer.parseInt(st.nextToken());
                long c = Long.parseLong(st.nextToken());
                change(b, c);
            } else if(a == 2) {
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                sb.append(sum(b, c)).append("\n");
            }
        }

        System.out.print(sb);
    }

    static void change(int index, long value) {

        index += (int) (Math.pow(2, k) - 1);
        long diff = value - arr[index];
        arr[index] = value;
        index /= 2;
        while(index > 0) {
            arr[index] += diff;
            index /= 2;
        }
    }

    static long sum(int startIdx, int endIdx) {

        startIdx += (int) (Math.pow(2, k) - 1);
        endIdx += (int) (Math.pow(2, k) - 1);

        long result = 0;
        while (startIdx <= endIdx) {
            if(startIdx % 2 == 1) {
                result += arr[startIdx];
            }
            if(endIdx % 2 == 0) {
                result += arr[endIdx];
            }

            startIdx = (startIdx + 1) / 2;
            endIdx = (endIdx - 1) / 2;
        }

        return result;
    }
}