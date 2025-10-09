import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, result = Integer.MAX_VALUE;
    static Info[] arr;
    static boolean[] select;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new Info[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        select = new boolean[n];
        find(0, 0);

        System.out.println(result);
    }

    static void find(int index, int count) {
        if(index == n) {
            if(count == 0) return;

            int sumS = 1;
            int sumB = 0;
            for (int i = 0; i < n; i++) {
                if(select[i]) {
                    sumS *= arr[i].s;
                    sumB += arr[i].b;
                }
            }

            result = Math.min(result, Math.abs(sumS - sumB));
            return;
        }

        select[index] = true;
        find(index + 1, count + 1);

        select[index] = false;
        find(index + 1, count);
    }

    static class Info {
        int s, b;

        public Info(int s, int b) {
            this.s = s;
            this.b = b;
        }
    }
}