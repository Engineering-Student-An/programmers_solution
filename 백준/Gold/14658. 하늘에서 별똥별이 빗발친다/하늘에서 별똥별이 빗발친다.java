import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int n, m, l, k;
    static Info[] star;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        star = new Info[k];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            star[i] = new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Set<Integer> rSet = new HashSet<>();
        Set<Integer> cSet = new HashSet<>();

        for (int i = 0; i < k; i++) {
            rSet.add(star[i].r);
            rSet.add(Math.max(0, star[i].r - l));

            cSet.add(star[i].c);
            cSet.add(Math.max(0, star[i].c - l));
        }

        int max = -1;
        for (Integer r : rSet) {
            for (Integer c : cSet) {
                max = Math.max(max, count(r, c));
            }
        }

        System.out.println(k - max);
    }

    static int count(int rs, int cs) {

        int re = rs + l;
        int ce = cs + l;
        int count = 0;
        for (int i = 0; i < k; i++) {
            int r = star[i].r;
            int c = star[i].c;

            if(r >= rs && r <= re && c >= cs && c <= ce) {
                count ++;
            }
        }

        return count;
    }

    static class Info {
        int r, c;

        public Info(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}