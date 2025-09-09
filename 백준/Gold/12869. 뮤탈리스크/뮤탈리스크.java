import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] scv;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        scv = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            scv[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(bfs());
    }

    static int bfs() {

        int[][] attack = {
                {-9, -3, -1},
                {-9, -1, -3},
                {-3, -9, -1},
                {-3, -1, -9},
                {-1, -9, -3},
                {-1, -3, -9}
        };

        boolean[][][] visit = new boolean[61][61][61];
        PriorityQueue<Info> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.count, o2.count));
        queue.add(new Info(scv[0], scv[1], scv[2], 0));
        visit[scv[0]][scv[1]][scv[2]] = true;

        while (!queue.isEmpty()) {
            Info now = queue.poll();

            for (int i = 0; i < 6; i++) {
                int a = Math.max(0, now.a + attack[i][0]);
                int b = Math.max(0, now.b + attack[i][1]);
                int c = Math.max(0, now.c + attack[i][2]);

                if(visit[a][b][c]) continue;

                visit[a][b][c] = true;
                if(a == 0 && b == 0 && c == 0) return now.count + 1;

                queue.add(new Info(a, b, c, now.count + 1));
            }
        }

        return 0;
    }

    static class Info {
        int a, b, c, count;

        public Info(int a, int b, int c, int count) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.count = count;
        }
    }
}