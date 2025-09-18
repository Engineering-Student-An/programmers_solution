import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, gas;
    static int[][] road;
    static int[] dirRow = {-1, 0, 0, 1};
    static int[] dirCol = {0, -1, 1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        gas = Integer.parseInt(st.nextToken());

        road = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                road[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        Info now = new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        int[][] start = new int[n+1][n+1];
        int[] endR = new int[m + 1];
        int[] endC = new int[m + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            start[r1][c1] = i + 1;
            endR[i + 1] = r2;
            endC[i + 1] = c2;
        }

        boolean isPossible = true;
        for (int k = 0; k < m; k++) {
            Route route = findCustomer(now, start);
            gas -= route.distance;
            if(route.distance == Integer.MAX_VALUE || gas < 0) {
                isPossible = false;
                break;
            }

            Info info = goToDestination(route.customerNum, route.r, route.c, endR[route.customerNum], endC[route.customerNum]);
            if(info.count == Integer.MAX_VALUE || info.count > gas) {
                isPossible = false;
                break;
            } else {
                gas -= info.count;
                gas += (info.count * 2);
                now.r = info.r;
                now.c = info.c;
                start[route.r][route.c] = 0;
            }
        }

        if(!isPossible) System.out.println(-1);
        else System.out.println(gas);
    }

    static Info goToDestination(int num, int r, int c, int endR, int endC) {
        boolean[][] visit = new boolean[n + 1][n + 1];
        visit[r][c] = true;

        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(r, c, 0));

        while (!queue.isEmpty()) {
            Info now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now.r + dirRow[i];
                int nc = now.c + dirCol[i];

                if(nr > 0 && nc > 0 && nr <= n && nc <= n && !visit[nr][nc] && road[nr][nc] == 0) {
                    if(nr == endR && nc == endC) return new Info(nr, nc, now.count + 1);

                    visit[nr][nc] = true;
                    queue.add(new Info(nr, nc, now.count + 1));
                }
            }
        }

        return new Info(0, 0, Integer.MAX_VALUE);
    }

    static Route findCustomer(Info first, int[][] start) {

        if(start[first.r][first.c] != 0) return new Route(start[first.r][first.c], 0, first.r, first.c);

        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(first.r, first.c, 0));

        boolean[][] visit = new boolean[n + 1][n + 1];
        visit[first.r][first.c] = true;

        List<Route> candidates = new ArrayList<>();

        int minDist = -1;

        while (!queue.isEmpty()) {
            Info now = queue.poll();

            if(minDist != -1 && now.count > minDist) break;

            // 고객이 있다면 후보에 추가
            if (start[now.r][now.c] != 0) {
                candidates.add(new Route(start[now.r][now.c], now.count, now.r, now.c));
                minDist = now.count;
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nr = now.r + dirRow[i];
                int nc = now.c + dirCol[i];


                if(nr > 0 && nc > 0 && nr <= n && nc <= n && !visit[nr][nc] && road[nr][nc] == 0) {
                    visit[nr][nc] = true;
                    queue.add(new Info(nr, nc, now.count + 1));
                }
            }
        }

        if(candidates.isEmpty()) return new Route(Integer.MAX_VALUE, Integer.MAX_VALUE, -1, -1);

        candidates.sort(new Comparator<Route>() {
            @Override
            public int compare(Route o1, Route o2) {
                if(o1.r == o2.r) return Integer.compare(o1.c, o2.c);

                return Integer.compare(o1.r, o2.r);
            }
        });

        return candidates.get(0);
    }

    static class Route {
        int customerNum, distance, r, c;

        public Route(int customerNum, int distance, int r, int c) {
            this.customerNum = customerNum;
            this.distance = distance;
            this.r = r;
            this.c = c;
        }
    }

    static class Info {
        int r, c, count;

        public Info(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public Info(int r, int c, int count) {
            this.r = r;
            this.c = c;
            this.count = count;
        }
    }
}