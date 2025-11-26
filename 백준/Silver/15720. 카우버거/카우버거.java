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
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int min = Math.min(n, Math.min(m, k));
        Integer[] ns = new Integer[n];
        Integer[] ms = new Integer[m];
        Integer[] ks = new Integer[k];

        int sum = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ns[i] = Integer.parseInt(st.nextToken());
            sum += ns[i];
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            ms[i] = Integer.parseInt(st.nextToken());
            sum += ms[i];
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            ks[i] = Integer.parseInt(st.nextToken());
            sum += ks[i];
        }

        System.out.println(sum);

        Arrays.sort(ns, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });

        Arrays.sort(ms, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });

        Arrays.sort(ks, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });

        sum = 0;
        for (int i = 0; i < min; i++) {
            sum += (int) ((ns[i] + ms[i] + ks[i]) * 0.9);
        }

        for (int i = min; i < n; i++) sum += ns[i];
        for (int i = min; i < m; i++) sum += ms[i];
        for (int i = min; i < k; i++) sum += ks[i];

        System.out.println(sum);
    }
}