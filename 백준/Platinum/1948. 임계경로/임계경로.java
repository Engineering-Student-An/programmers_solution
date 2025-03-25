import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static ArrayList<Info>[] adjacencyList;
    static ArrayList<Info>[] reverseAdjacencyList;
    static int[] inDegree;
    static long[] result;
    static int start, end;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        adjacencyList = new ArrayList[n+1];
        reverseAdjacencyList = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            adjacencyList[i] = new ArrayList<>();
            reverseAdjacencyList[i] = new ArrayList<>();
        }

        inDegree = new int[n+1];
        result = new long[n+1];
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int node = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            adjacencyList[start].add(new Info(node, value));

            // 에지 뒤집기 한 인접리스트
            reverseAdjacencyList[node].add(new Info(start, value));

            // 진입 차수 배열
            inDegree[node] ++;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        // 위상 정렬 => 목적지까지 걸리는 최대 시간 계산
        topologicalSort(start);

        StringBuilder sb = new StringBuilder();
        sb.append(result[end]).append("\n");

        // 에지를 뒤집은 역인접리스트 통해서 도로의 수 카운트
        sb.append(countRoads());

        System.out.println(sb);
    }

    static int countRoads() {

        int count = 0;
        boolean[] visit = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(end);
        visit[end] = true;


        while (!queue.isEmpty()) {

            Integer poll = queue.poll();
            for (Info info : reverseAdjacencyList[poll]) {
                if(result[info.node] + info.value == result[poll]) {
                    count ++;
                    if(!visit[info.node]) {
                        queue.add(info.node);
                        visit[info.node] = true;
                    }
                }
            }
        }


        return count;
    }

    static void topologicalSort(int num) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();

            for (Info info : adjacencyList[poll]) {
                
                inDegree[info.node] --;
                if(inDegree[info.node] == 0) queue.add(info.node);
                
                result[info.node] = Math.max(result[info.node], result[poll] + info.value);
            }
        }
    }

    static class Info {
        int node;
        int value;

        public Info(int node, int value) {
            this.node = node;
            this.value = value;
        }
    }
}