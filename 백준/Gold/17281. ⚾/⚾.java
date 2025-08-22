import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, result = Integer.MIN_VALUE;
    static int[][] arr;
    static int[] seq;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][10];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < 10; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        seq = new int[10];
        visit = new boolean[10];
        visit[1] = true;
        seq[4] = 1;

        find(1);

        System.out.println(result);
    }

    static void find(int index) {
        if(index == 10) {
            play();
            return;
        }

        for (int i = 2; i < 10; i++) {
            if(!visit[i]) {
                seq[index] = i;
                visit[i] = true;

                if(index == 3) find(index + 2);
                else find(index + 1);

                visit[i] = false;
            }
        }
    }

    static void play() {
        int hitIndex = 1;
        int score = 0;


        for (int i = 0; i < n; i++) {
            int out = 0;
            int[] status = new int[4];
            while(out < 3) {

                int hit = arr[i][seq[hitIndex]];
                status[0] = 1;

                if (hit == 0) {
                    out++;
                } else {
                    // 홈으로 들어옴
                    for (int j = 3; j >= 3 - hit + 1; j --) {
                        if(status[j] == 1) {
                            score ++;
                            status[j] = 0;
                        }
                    }

                    // 진루
                    for (int j = 3; j >= hit; j--) {
                        if(status[j-hit] == 1) {
                            status[j] = 1;
                            status[j-hit] = 0;
                        }
                    }
                }
                hitIndex = (hitIndex + 1) % 10;
                if(hitIndex == 0) hitIndex = 1;
            }
        }
        result = Math.max(result, score);
    }
}