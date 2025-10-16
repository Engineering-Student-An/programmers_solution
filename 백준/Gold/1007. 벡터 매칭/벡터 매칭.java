import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static char[] list;
    static double min;
    static Info[] arr;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(T -- > 0) {
            n = Integer.parseInt(br.readLine());
            arr = new Info[n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[i] = new Info(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
            }

            visit = new boolean[n];

            min = Double.MAX_VALUE;
            list = new char[n];
            find(0, 0);

            sb.append(min).append("\n");
        }

        System.out.print(sb);
    }

    static void find(int index, int plusCount) {
        if(index == n) {
            if(plusCount == n/2) calc();
            return;
        }

        list[index] = '+';
        find(index + 1, plusCount + 1);

        list[index] = '-';
        find(index + 1, plusCount);
    }

    static void calc() {

        double x = 0.0, y = 0.0;
        for (int i = 0; i < n; i++) {
            char c = list[i];
            x = (c == '+') ? x + arr[i].x : x - arr[i].x;
            y = (c == '+') ? y + arr[i].y : y - arr[i].y;
        }

        min = Math.min(min, (Math.sqrt(x * x + y * y)));
    }

    static class Info {
        long x, y;

        public Info(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
}