import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] result = new int[10];
        PriorityQueue<Info> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            String line = br.readLine();

            for (int j = 1; j < m - 1; j++) {
                if(line.charAt(j) != '.' && (line.charAt(j + 1) == '.' || line.charAt(j + 1) == 'F')) {
                    int index = line.charAt(j) - '0';
                    queue.add(new Info(index, j));
                    break;
                }
            }
        }

        Info before = new Info(0, m);
        while (!queue.isEmpty()) {
            Info now = queue.poll();

            if(now.last < before.last) {
                before.index ++;
                before.last = now.last;

                result[now.index] = before.index;
            } else if(now.last == before.last) {
                result[now.index] = before.index;
            }
        }

        for (int i = 1; i <= 9; i++) {
            System.out.println(result[i]);
        }
    }

    static class Info implements Comparable<Info> {
        int index, last;

        public Info(int index, int last) {
            this.index = index;
            this.last = last;
        }

        @Override
        public int compareTo(Info o) {
            return Integer.compare(o.last, this.last);
        }
    }
}
