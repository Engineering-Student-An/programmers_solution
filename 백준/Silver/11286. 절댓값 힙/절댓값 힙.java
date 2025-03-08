import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Long> queue = new PriorityQueue<>(new QComparator());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            long m = Long.parseLong(br.readLine());

            if(m == 0) {
                if(queue.isEmpty()) {
                    sb.append("0\n");
                } else {
                    long poll = queue.poll();
                    sb.append(poll).append("\n");
                }
            } else {
                queue.add(m);
            }
        }

        System.out.print(sb);
    }

    static class QComparator implements Comparator<Long> {
        @Override
        public int compare(Long o1, Long o2) {
            long abs1 = Math.abs(o1);
            long abs2 = Math.abs(o2);

            if(abs1 == abs2) {
                return Long.compare(o1, o2);
            }

            return Long.compare(abs1, abs2);
        }
    }
}