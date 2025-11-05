import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();
        PriorityQueue<String> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            String[] split = line.split("\\.");

            if(!map.containsKey(split[1])) {
                map.put(split[1], 1);
                queue.add(split[1]);
            } else {
                map.replace(split[1], map.get(split[1]) + 1);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()) {
            String word = queue.poll();

            sb.append(word).append(" ").append(map.get(word)).append("\n");
        }

        System.out.print(sb);
    }
}