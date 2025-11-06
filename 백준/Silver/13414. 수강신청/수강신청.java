import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String line = br.readLine();

            if(map.containsKey(line)) {
                map.replace(line, i);
            } else map.put(line, i);
        }

        PriorityQueue<Info> queue = new PriorityQueue<>();
        for (String string : map.keySet()) {
            queue.add(new Info(string, map.get(string)));
        }

        int count = 0;
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            sb.append(queue.poll().num).append("\n");
            count ++;

            if(k == count) break;
        }

        System.out.print(sb);
    }

    static class Info implements Comparable<Info>{
        String num;
        int seq;

        public Info(String num, int seq) {
            this.num = num;
            this.seq = seq;
        }

        @Override
        public int compareTo(Info o) {
            return Integer.compare(this.seq, o.seq);
        }
    }
}