import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] parent, count;
    static Map<String, Integer> map;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < testcase; t++) {
            n = Integer.parseInt(br.readLine());

            parent = new int[200001];
            count = new int[200001];
            for (int i = 0; i <= 200000; i++) {
                parent[i] = i;
                count[i] = 1;
            }

            map = new HashMap<>();
            int index = 1;
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                String[] names = new String[2];
                for (int j = 0; j < 2; j++) {
                    names[j] = st.nextToken();
                }
                for (int j = 0; j < 2; j++) {
                    if(map.get(names[j]) == null) {
                        map.put(names[j], index ++);
                    }
                }
                sb.append(union(map.get(names[0]), map.get(names[1]))).append("\n");
            }
        }
        System.out.print(sb);
    }

    static int union(int a, int b) {

        a = find(a);
        b = find(b);

        int min = Math.min(a, b);
        int max = Math.max(a, b);
        if(min != max) {
            parent[max] = min;
            count[min] += count[max];
            count[max] = 0;
        }

        return count[min];
    }

    static int find(int a) {
        if(a == parent[a]) return a;

        return parent[a] = find(parent[a]);
    }
}