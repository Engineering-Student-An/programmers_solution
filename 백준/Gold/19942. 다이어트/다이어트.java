import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n, min = Integer.MAX_VALUE;
    static int[][] arr;
    static int[] m;
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        m = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) m[i] = Integer.parseInt(st.nextToken());

        arr = new int[n+1][5];
        int[] sum = new int[4];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(j != 4) sum[j] += arr[i][j];
            }
        }

        if(m[0] > sum[0] || m[1] > sum[1] || m[2] > sum[2] || m[3] > sum[3]) {
            System.out.println(-1);
        } else {

            find(1, 0, new int[]{0, 0, 0, 0}, new ArrayList<>());

            System.out.println(min);
            for (Integer integer : result) {
                System.out.print(integer + " ");
            }
        }
    }

    static void find(int index, int cost, int[] ing, List<Integer> list) {

        if(ing[0] >= m[0] && ing[1] >= m[1] && ing[2] >= m[2] && ing[3] >= m[3]) {
            if(min > cost) {
                min = cost;
                result = List.copyOf(list);
            }
            return;
        }

        if(index > n) return;

        // 선택
        list.add(index);
        find(index + 1, cost + arr[index][4],
                new int[] {(ing[0] + arr[index][0]), (ing[1] + arr[index][1]), (ing[2] + arr[index][2]), (ing[3] + arr[index][3])},
                list);

        // 선택 x
        list.remove((Integer) index);
        find(index + 1, cost, ing, list);
    }
}