import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        final long INF = 999999999;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Node>[] adjacencyList = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            adjacencyList[start].add(new Node(end, value));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        long[] result = new long[n+1];
        for (int i = 1; i <= n; i++) {
            if(i!=start) result[i] = INF;
        }
        boolean[] visit = new boolean[n+1];

        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= n; i++) {

            long min = INF+1;
            int index = 0;
            for (int j = 1; j <= n; j++) {
                if(!visit[j] && min > result[j]) {
                    index = j;
                    min = result[j];
                }
            }

            stack.push(index);
            while(!stack.isEmpty()) {
                Integer pop = stack.pop();
                visit[pop] = true;

                for(Node node : adjacencyList[pop]) {
                    result[node.ind] = Math.min(result[node.ind], result[pop] + node.value);
                }
            }

        }

        System.out.print(result[end]);

    }

    static class Node {
        int ind;
        int value;

        public Node(int ind, int value) {
            this.ind = ind;
            this.value = value;
        }
    }
}