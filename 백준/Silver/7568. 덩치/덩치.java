import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Info[] arr = new Info[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = 1;
            for (int j = 0; j < n; j++) {
                if(i == j) continue;

                if(arr[i].w < arr[j].w && arr[i].h < arr[j].h) result[i] ++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb);
    }

    static class Info {
        int w, h;

        public Info(int w, int h) {
            this.w = w;
            this.h = h;
        }
    }
}