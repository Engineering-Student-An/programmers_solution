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

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer>[] adjacencyList = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        int[] inDegree = new int[n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());

            int before = 0;
            for (int j = 0; j < t; j++) {
                int next = Integer.parseInt(st.nextToken());
                if(before != 0) {
                    adjacencyList[before].add(next);
                    inDegree[next] ++;
                }
                before = next;
            }
        }

        int[] result = new int[n+1];
        boolean[] visit = new boolean[n+1];
        int index = 1;

        while(index <= n) {
            boolean zeroInDegree = false;

            for (int i = 1; i <= n; i++) {
                if(!visit[i] && inDegree[i] == 0) {
                    visit[i] = true;
                    for (Integer next : adjacencyList[i]) {
                        inDegree[next] --;
                    }
                    result[index ++] = i;
                    zeroInDegree = true;
                }
            }

            if(!zeroInDegree) break;
        }

        if(result[n] == 0) System.out.println(0);
        else {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                sb.append(result[i]).append("\n");
            }

            System.out.print(sb);
        }
    }
}