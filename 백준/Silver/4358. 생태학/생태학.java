import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();
        int sum = 0;
        while(true) {
            String line = br.readLine();
            if (line == null || line.isEmpty()) break;

            sum ++;
            if(map.containsKey(line)) {
                map.replace(line, map.get(line) + 1);
            } else {
                map.put(line, 1);
            }
        }


        PriorityQueue<Info> queue = new PriorityQueue<>((o1, o2) -> o1.name.compareTo(o2.name));
        for(String name : map.keySet()) {
            queue.add(new Info(name, map.get(name)));
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Info now = queue.poll();

            sb.append(now.name).append(" ");

            double rate = (double) now.count / sum * 100;
            sb.append(String.format("%.4f", rate)).append("\n");
        }

        System.out.print(sb);
    }

    static class Info {
        String name;
        int count;

        public Info(String name, int count) {
            this.name = name;
            this.count = count;
        }
    }
}