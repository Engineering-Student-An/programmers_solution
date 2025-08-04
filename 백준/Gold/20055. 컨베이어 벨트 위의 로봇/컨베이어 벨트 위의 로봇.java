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
        int k = Integer.parseInt(st.nextToken());

        Info[] arr = new Info[2 * n];
        PriorityQueue<Info> robot = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * n; i++) {
            arr[i] = new Info(Integer.parseInt(st.nextToken()), false);
        }

        int step = 1;
        while(true) {

            // 1. 회전
            Info last = arr[2 * n - 1];
            for (int i = 2 * n - 1; i > 0; i--) {
                arr[i] = arr[i - 1];
            }
            arr[0] = last;
            arr[n - 1].isRobot = false;     // 내리는 위치 도달 시 로봇 떨어짐

            // 2. 가장 먼저 벨트에 올라간 로봇부터 회전방향으로 이동
            for (int i = n - 2; i >= 0; i--) {
                if(arr[i].isRobot && arr[i + 1].remain > 0 && !arr[i + 1].isRobot) {
                    arr[i].isRobot = false;
                    arr[i + 1].isRobot = true;
                    arr[i + 1].remain --;
                }
            }
            arr[n - 1].isRobot = false;     // 내리는 위치 도달 시 로봇 떨어짐

            // 3. 올리는 위치에 로봇 올리기
            if(arr[0].remain > 0) {
                arr[0].isRobot = true;
                arr[0].remain --;
            }
            
            // 4. 내구도가 0인 칸의 개수 조사
            int zeros = 0;
            for (int i = 0; i < 2 * n; i++) {
                if(arr[i].remain == 0) zeros ++;
            }

            if(zeros >= k) break;
            
            step ++;
        }

        System.out.println(step);
    }

    static class Info {
        int remain;
        boolean isRobot;

        public Info(int remain, boolean isRobot) {
            this.remain = remain;
            this.isRobot = isRobot;
        }
    }
}