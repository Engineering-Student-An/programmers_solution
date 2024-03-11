import java.io.*;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>( (o1, o2) -> {
            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);
            if(first_abs == second_abs) {
                return o1 > o2 ? 1: -1;
            } else {
                return first_abs - second_abs;
            }
        });

        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(br.readLine());
            if(now!=0) {
                queue.add(now);
            } else {
                if(queue.isEmpty()) {
                    bw.write(0 + "\n");
                } else {
                    bw.write(queue.poll() + "\n");
                }
            }
        }

        bw.flush();
        bw.close();
    }

}