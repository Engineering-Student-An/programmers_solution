import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] arr;
    static List<Integer> minus = new ArrayList<>();
    static Set<Integer> result = new HashSet<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                yaksu(i, j);
            }
        }

        int[] ans = new int[result.size()];
        int index = 0;
        for (Integer integer : result) {
            ans[index ++] = integer;
        }

        Arrays.sort(ans);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ans.length; i++) {
            sb.append(ans[i]).append(" ");
        }

        System.out.println(sb);
    }

    static void yaksu(int a, int b) {
        a = arr[a];
        b = arr[b];

        int m = Math.abs(a - b);
        if(minus.contains(m)) return;

        List<Integer> temp = new ArrayList<>();
        // 제곱 수 판별
        double sqrt = Math.sqrt(m);
        temp.add(m);
        for (int i = 2; i < sqrt; i++) {
            if(m % i == 0) {
                temp.add(i);
                temp.add(m / i);
            }
        }

        int s = (int) sqrt;
        if((int) Math.pow(s, 2) == m) temp.add((int) sqrt);

        if(result.isEmpty()) {
            for (Integer integer : temp) {
                result.add(integer);
            }
        } else {
            for (Integer integer : temp) {
                if(!result.contains(integer)) result.remove(integer);
            }
            result.removeIf(integer -> !temp.contains(integer));
        }
    }
}