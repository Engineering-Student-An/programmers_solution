import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<Long> len = new ArrayList<>();
        int[][] arr = new int[m + 1][2];
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i][0] = x;
            arr[i][1] = y;
        }
        arr[m][0] = 1; arr[m][1] = 1;

        int cut = Integer.parseInt(br.readLine()) * 2 + 1;
        
        int x = 2, y = 2;
        long now = 0;
        for (int i = 0; i < m + 1; i++) {
            int nx = arr[i][0] * 2;
            int ny = arr[i][1] * 2;

            // 위아래로 이동한 경우
            if(y != ny) {
                now += Math.abs(y - ny);
            } else {    // 좌우로 이동한 경우
                
                // 자르는 선에 걸리는 경우
                if(Math.min(x, nx) <= cut && Math.max(x, nx) > cut) {
                    now += Math.abs(cut - x);
                    len.add(now);

                    now = Math.abs(cut - nx);
                } else {
                    now += Math.abs(x - nx);
                }
            }
            
            x = nx;
            y = ny;
        }
        long max = len.get(0) + now;

        for (int i = 1; i < len.size(); i++) {
            max = Math.max(max, len.get(i));
        }
        System.out.println(max % 2 == 0 ? max / 2 : max / 2 + ".5");
    }
}