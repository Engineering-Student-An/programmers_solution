import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        int s = scanner.nextInt();

        PriorityQueue<Info> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.count, o2.count));
        queue.add(new Info(1, 0, 0));

        boolean[] visit = new boolean[2001];
        visit[1] = true;

        while (!queue.isEmpty()) {
            Info now = queue.poll();

            if(now.n == s) {
                System.out.println(now.count);
                break;
            }

            // 복사
            if(now.copy != now.n) {
                queue.add(new Info(now.n, now.count + 1, now.n));
            }

            // 붙여넣기
            int next = now.n + now.copy;
            if(next <= 2000) {
                queue.add(new Info(next, now.count + 1, now.copy));
            }

            // 빼기
            next = now.n - 1;
            if(next >= 0 && !visit[next]) {
                queue.add(new Info(next, now.count + 1, now.copy));
                visit[next] = true;
            }
        }
    }

    static class Info {
        int n, count, copy;

        public Info(int n, int count, int copy) {
            this.n = n;
            this.count = count;
            this.copy = copy;
        }
    }
}