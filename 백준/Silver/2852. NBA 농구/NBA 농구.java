import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] sum = new int[3];
        int start = 0;
        int one = 0, two = 0, winning = 0;

        int T = Integer.parseInt(br.readLine());
        while(T -- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int team = Integer.parseInt(st.nextToken());
            String timeString = st.nextToken();
            int m = Integer.parseInt(timeString.split(":")[0]);
            int s = Integer.parseInt(timeString.split(":")[1]);
            int time = m * 60 + s;

            if(team == 1) one ++;
            else two ++;

            if(one != two) {
                if(winning == 0) {  // 그 전까지 비기는 중
                    if(one > two) winning = 1;
                    else winning = 2;

                    start = time;
                }
            } else {
                if(winning != 0) {  // 한 팀이 이기다가 비기게 된 경우
                    if(winning == 1) {
                        sum[1] += time - start;
                    } else {
                        sum[2] += time - start;
                    }

                    winning = 0;
                }
            }
        }

        int end = 48 * 60;
        if(winning != 0) {
            if(winning == 1) {
                sum[1] += end - start;
            } else {
                sum[2] += end - start;
            }
        }

        String min1 = String.valueOf((sum[1] / 60));
        if(min1.length() == 1) min1 = "0" + min1;
        String sec1 = String.valueOf((sum[1] % 60));
        if(sec1.length() == 1) sec1 = "0" + sec1;

        String min2 = String.valueOf((sum[2] / 60));
        if(min2.length() == 1) min2 = "0" + min2;
        String sec2 = String.valueOf((sum[2] % 60));
        if(sec2.length() == 1) sec2 = "0" + sec2;

        System.out.println(min1 + ":" + sec1);
        System.out.println(min2 + ":" + sec2);
    }
}