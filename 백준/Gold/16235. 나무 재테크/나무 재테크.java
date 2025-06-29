import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n, m, k;
    static PriorityQueue<Integer>[][] arr;
    static int[][] plus, food;
    static List<Integer>[][] die;
    static int[] dirRow = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dirCol = {1, 1, 0, -1, -1, -1, 0, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        plus = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                plus[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        arr = new PriorityQueue[n+1][n+1];
        food = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = new PriorityQueue<>();
                food[i][j] = 5;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[r][c].add(y);
        }

        die = new ArrayList[n+1][n+1];

        for (int i = 1; i <= k; i++) {

            spring();
            summer();
            fall();
            winter();
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                count += arr[i][j].size();
            }
        }

        System.out.println(count);
    }

    static void spring() {

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                die[i][j] = new ArrayList<>();
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                List<Integer> alive = new ArrayList<>();
                while (!arr[i][j].isEmpty()) {
                    Integer now = arr[i][j].poll();

                    if(now <= food[i][j]) {
                        food[i][j] -= now;
                        alive.add(now + 1);
                    } else {
                        die[i][j].add(now);
                    }
                }

                for(Integer y : alive) {
                    arr[i][j].add(y);
                }
            }
        }
    }

    static void summer() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (Integer y : die[i][j]) {
                    food[i][j] += (y / 2);
                }
            }
        }
    }

    static void fall() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (Integer y : arr[i][j]) {
                    if(y % 5 == 0) {
                        for (int k = 0; k < 8; k++) {
                            int nr = i + dirRow[k];
                            int nc = j + dirCol[k];

                            if(nr >= 1 && nc >= 1 && nr <= n && nc <= n) {
                                arr[nr][nc].add(1);
                            }
                        }
                    }
                }
            }
        }
    }

    static void winter() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                food[i][j] += plus[i][j];
            }
        }
    }
}