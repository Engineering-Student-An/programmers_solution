import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new LinkedList<>();
        int[] check = new int[100001];

        int max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());

            if(deque.isEmpty()) {
                deque.addLast(num);
                check[num] ++;
            } else {
                // 이미 k번 사용
                if(check[num] == k) {
                    while(!deque.isEmpty()) {
                        Integer m = deque.removeFirst();
                        check[m] --;
                        if(m == num) break;
                    }
                }

                deque.addLast(num);
                check[num] ++;
            }

            max = Math.max(deque.size(), max);
        }

        System.out.println(max);
    }
}