import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

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

        PriorityQueue<Long>[] result = new PriorityQueue[n+1];
        for (int i = 0; i <= n; i++) {
            result[i] = new PriorityQueue<>(new QComparator());
        }
        result[1].add(0L);

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(1, 0));

        while(!queue.isEmpty()) {
            Node poll = queue.poll();
            for(Node node : adjacencyList[poll.ind]) {
                if(result[node.ind].size() < k) {
                    result[node.ind].add((long) (poll.value + node.value));
                    queue.add(new Node(node.ind, poll.value + node.value));
                } else if(result[node.ind].peek() > poll.value + node.value){
                    result[node.ind].poll();
                    result[node.ind].add((long) (poll.value + node.value));
                    queue.add(new Node(node.ind, poll.value + node.value));
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.println((result[i].size() == k) ? result[i].peek() : "-1");
        }
    }

    static class Node implements Comparable<Node>{
        int ind;
        int value;

        public Node(int ind, int value) {
            this.ind = ind;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return (this.value < o.value) ? -1 : 1;
        }
    }

    static class QComparator implements Comparator<Long> {
        @Override
        public int compare(Long o1, Long o2) {
            return (o2 > o1) ? 1 : -1;
        }
    }
}