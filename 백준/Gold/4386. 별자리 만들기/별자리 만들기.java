import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static PriorityQueue<Info> queue = new PriorityQueue<>((o1, o2) -> Double.compare(o1.value, o2.value));
    static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        double[][] arr = new double[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                arr[i][j] = Double.parseDouble(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                queue.add(new Info(i, j, Math.sqrt(Math.pow(arr[i][0] - arr[j][0], 2) + Math.pow(arr[i][1] - arr[j][1], 2) )));
            }
        }
        
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        double sum = 0.0;
        int count = 0;
        while(!queue.isEmpty() && count < n-1) {
            Info poll = queue.poll();

            if(find(poll.s) != find(poll.e)) {
                union(poll.s, poll.e);
                count ++;
                sum += poll.value;
            }
        }

        System.out.println(sum);
    }

    static int find(int a) {
        if(a == parent[a]) return a;

        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b) {
            parent[Math.max(a, b)] = Math.min(a, b);
        }
    }

    static class Info {
        int s;
        int e;
        double value;

        public Info(int s, int e, double value) {
            this.s = s;
            this.e = e;
            this.value = value;
        }
    }
}