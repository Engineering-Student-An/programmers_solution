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

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String word = br.readLine();

            if(word.length() < m) continue;

            if(map.get(word) != null) {
                map.replace(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }

        PriorityQueue<Info> queue = new PriorityQueue<>();
        for (String s : map.keySet()) {
            queue.add(new Info(s, map.get(s), s.length()));
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            sb.append(queue.poll().word).append("\n");
        }

        System.out.print(sb);
    }

    static class Info implements Comparable<Info> {
        String word;
        int count, length;

        public Info(String word, int count, int length) {
            this.word = word;
            this.count = count;
            this.length = length;
        }

        @Override
        public int compareTo(Info o) {
            if(this.count == o.count) {
                if(this.length == o.length) {
                    return this.word.compareTo(o.word);
                }
                return o.length - this.length;
            }
            return o.count - this.count;
        }
    }
}