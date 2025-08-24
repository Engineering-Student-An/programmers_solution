import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> sosu = new ArrayList<>();
        boolean[] check = new boolean[1000001];
        for (int i = 2; i <= 1000000; i++) {
            if(!check[i]) {
                sosu.add(i);
                for (int j = i * 2; j <= 1000000; j+=i) {
                    check[j] = true;
                }
            }
        }

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T -- > 0) {
            int num = Integer.parseInt(br.readLine());
            int count = 0;
            int left = 0;
            int right = sosu.size() - 1;

            while(left <= right) {
                int l = sosu.get(left);
                int r = sosu.get(right);
                if(l + r == num) {
                    count ++;
                    left++;
                } else if(l + r > num) {
                    right --;
                } else left ++;
            }

            sb.append(count).append("\n");
        }

        System.out.print(sb);
    }
}