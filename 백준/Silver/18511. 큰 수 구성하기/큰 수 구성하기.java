import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static boolean isFound = false;
    static int n, m, result = 0;
    static Integer[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new Integer[m];
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });

        int jari = 0;
        while (true) {
            int r = (int) (n / (Math.pow(10, jari)));
            if(r == 0) break;
            jari++;
        }

        // 자리수 동일한 경우 가능한지 체크
        find(jari, 0);

        // 자리수 - 1 => 무조건 가능
        if(result == 0) {
            for (int i = 0; i < jari - 1; i++) {
                result = (result * 10) + arr[0];
            }
        }

        System.out.println(result);
    }

    static void find(int index, int num) {
        if(index == 0) {
            if(num <= n) {
                result = Math.max(result, num);
            }

            return;
        }

        for (int i = 0; i < m; i++) {
            find(index - 1, num * 10 + arr[i]);
        }
    }
}