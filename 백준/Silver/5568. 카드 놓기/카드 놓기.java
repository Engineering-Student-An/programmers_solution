import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    static int n, k;
    static boolean[] visit;
    static String[] arr;
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        visit = new boolean[n];
        find("", 0);

        System.out.println(set.size());
    }

    static void find(String num, int count) {
        if(count == k) {
            set.add(num);
            return;
        }

        for (int i = 0; i < n; i++) {
            if(!visit[i]) {
                visit[i] = true;
                find(num + arr[i], count + 1);
                visit[i] = false;
            }
        }
    }
}