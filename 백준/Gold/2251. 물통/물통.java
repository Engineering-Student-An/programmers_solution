import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static boolean[][] visit;
    static Water[] waters;
    static int[] cap;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        cap = new int[3];
        for (int i = 0; i < 3; i++) {
            cap[i] = scanner.nextInt();
        }

        // 물 이동 경로 전체 경우
        waters = new Water[6];
        waters[0] = new Water(0, 1);
        waters[1] = new Water(0, 2);
        waters[2] = new Water(1, 0);
        waters[3] = new Water(1, 2);
        waters[4] = new Water(2, 0);
        waters[5] = new Water(2, 1);

        int[] now = {0, 0, cap[2]};

        visit = new boolean[cap[0]+1][cap[2]+1];    // a, c

        bfs(now);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= cap[2]; i++) {
            if(visit[0][i]) sb.append(i).append(" ");
        }

        System.out.print(sb);
    }

    public static void bfs(int[] now) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{now[0], now[1], now[2]});

        visit[now[0]][now[2]] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            now = new int[] {poll[0], poll[1], poll[2]};

            for (int i = 0; i < 6; i++) {
                Water water = waters[i];

                int[] temp = new int[3];
                for (int j = 0; j < 3; j++) {
                    temp[j] = now[j];
                }
                if(temp[water.sender] > 0) {
                    temp[water.receiver] += temp[water.sender];
                    temp[water.sender] = 0;
                    int nam = temp[water.receiver] - cap[water.receiver];

                    if(nam > 0) {
                        temp[water.receiver] -= nam;
                        temp[water.sender] += nam;
                    }
                    if(!visit[temp[0]][temp[2]]) {
                        queue.add(new int[]{temp[0], temp[1], temp[2]});
                        visit[temp[0]][temp[2]] = true;
                    }
                }


            }
        }
    }

    static class Water {

        int sender;
        int receiver;

        public Water(int sender, int receiver) {
            this.sender = sender;
            this.receiver = receiver;
        }
    }
}