import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(arr);

        // 2개 선택
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                List<Integer> remove = new ArrayList<>();
                remove.addAll(arr);

                int one = arr.get(i) + arr.get(j);

                remove.remove(i);
                remove.remove(j - 1);
                min = Math.min(min, Math.abs(one - find(remove, one)));

            }
        }

        System.out.println(min);
    }

    static int find(List<Integer> arr, int num) {

        int l = 0, r = arr.size() - 1;
        int result = arr.get(l) + arr.get(r);
        while(r < arr.size() && l < r) {
            int sum = arr.get(l) + arr.get(r);
            if(sum == num) return sum;

            if(Math.abs(num - result) > Math.abs(num - sum)) result = sum;

            if(sum < num) l ++;
            else r --;
        }

        return result;
    }
}