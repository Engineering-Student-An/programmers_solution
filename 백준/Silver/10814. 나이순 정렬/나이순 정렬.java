import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Info> queue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            queue.add(new Info(i, age, name));
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Info info = queue.poll();

            sb.append(info.age).append(" ").append(info.name).append("\n");
        }

        System.out.print(sb);

    }

    static class Info implements Comparable<Info> {

        int index;
        int age;
        String name;

        public Info (int index, int age, String name) {
            this.index = index;
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Info o) {
            if(this.age == o.age) {
                return this.index - o.index;
            }

            return this.age - o.age;
        }
    }
}