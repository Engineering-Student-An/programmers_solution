import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[] visit = new boolean[n+1];
        int[] count = new int[n+1];
        ArrayList<Integer>[] list = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list[start].add(end);
            count[end] ++;
        }

        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if(count[i] == 0 && !visit[i]) {
                queue.add(i);
                while(!queue.isEmpty()) {

                    Integer poll = queue.poll();
                    visit[poll] = true;
                    sb.append(poll).append(" ");

                    for(Integer integer : list[poll]) {
                        count[integer]--;
                        if(count[integer] == 0) {
                            queue.add(integer);
                        }
                    }
                }
            }
        }

        System.out.print(sb);



    }
}