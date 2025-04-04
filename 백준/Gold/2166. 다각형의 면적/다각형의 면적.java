import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Point[] arr = new Point[n + 1];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());

            arr[i] = new Point(x, y);
        }

        arr[n] = new Point(arr[0].x, arr[0].y);
        double result = 0.0;
        for (int i = 0; i < n; i++) {
            result += ((arr[i].x * arr[i+1].y) - (arr[i+1].x * arr[i].y));
        }

        result = Math.abs(result / 2.0);
        System.out.printf("%.1f", result);
    }

    static class Point {
        long x;
        long y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
}