import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Info[] arr = new Info[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(arr, new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                if(o1.g == o2.g) {
                    if(o1.s == o2.s) {
                        if(o1.b == o2.b) {
                            return Integer.compare(o1.num, o2.num);
                        }
                        return Integer.compare(o2.b, o1.b);
                    }
                    return Integer.compare(o2.s, o1.s);
                }
                return Integer.compare(o2.g, o1.g);
            }
        });

        int same = 0;
        int rank = 1;
        Info before = arr[0];
        for (int i = 1; i < n; i++) {
            Info now = arr[i];

            if(before.g != now.g || before.s != now.s || before.b != now.b) {
                before = now;
                rank += (same + 1);
            } else {
                same ++;
            }
            if(arr[i].num == k) break;
        }

        System.out.println(rank);
    }

    static class Info {
        int num, g, s, b;

        public Info(int num, int g, int s, int b) {
            this.num = num;
            this.g = g;
            this.s = s;
            this.b = b;
        }
    }
}