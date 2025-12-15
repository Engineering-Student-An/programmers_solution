import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int u = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        List<String>[] arr = new ArrayList[u + 1];
        for (int i = 1; i <= u; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int money = Integer.parseInt(st.nextToken());

            arr[money].add(name);
        }

        int[] result = new int[2];
        result[0] = Integer.MAX_VALUE;
        for (int i = 1; i <= u; i++) {
            if(arr[i].isEmpty()) continue;

            if(arr[i].size() < result[0]) {
                result[0] = arr[i].size();
                result[1] = i;
            }
        }

        System.out.println(arr[result[1]].get(0) + " " + result[1]);
    }
}