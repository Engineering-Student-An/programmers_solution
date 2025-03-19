import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] alphaSum = new long[26];
        for (int t = 0; t < n; t++) {
            String line = br.readLine();

            int len = line.length();
            for (int i = 0; i < len; i++) {
                int now = line.charAt(i) - 'A';

                alphaSum[now] += (long) Math.pow(10, len - 1 - i);
            }
        }

        PriorityQueue<Long> queue = new PriorityQueue<>(new QComparator());
        for (int i = 0; i < 26; i++) {
            if(alphaSum[i] > 0) queue.add(alphaSum[i]);
        }

        long result = 0;
        long now = 9;
        while (!queue.isEmpty()) {
            Long poll = queue.poll();
            result += poll * (now--);
        }

        System.out.println(result);
    }

    static class QComparator implements Comparator<Long> {
        @Override
        public int compare(Long o1, Long o2) {
            return o1 > o2 ? -1 : 1;
        }
    }
}