import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tt = 0; tt < T; tt++) {
            int n = Integer.parseInt(br.readLine());
            Info[] arr = new Info[n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[i] = new Info(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            // a 기준 오름차순
            Arrays.sort(arr, new Comparator<Info>() {
                @Override
                public int compare(Info o1, Info o2) {
                    return o1.a - o2.a;
                }
            });

            int count = 0;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if(arr[i].b < min) {
                    min = arr[i].b;
                    count ++;
                }
            }
            sb.append(count).append("\n");

        }

        System.out.print(sb);
    }

    static class Info {
        int num;
        int a;
        int b;

        public Info(int num, int a, int b) {
            this.num = num;
            this.a = a;
            this.b = b;
        }
    }
}