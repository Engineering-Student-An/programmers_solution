import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int[][] arr = new int[p][2];
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        int result = 0;
        boolean[] check = new boolean[p];
        double radius = (double) h/2;
        int circleY = y + (int) radius;
        for (int i = 0; i < p; i++) {
            int nowX = arr[i][0];
            int nowY = arr[i][1];
            if(!check[i] && nowX >= x && nowX <= (x+w) && nowY >= y && nowY <= (y+h)) {
                check[i] = true;
                result ++;
            }
            double distance = Math.sqrt( (Math.pow( (nowX - x), 2) + Math.pow( (nowY - circleY), 2)) );
            if(!check[i] && distance <= radius) {
                check[i] = true;
                result ++;
            }

            distance = Math.sqrt( (Math.pow( (nowX - (x + w)), 2) + Math.pow( (nowY - circleY), 2)) );
            if(!check[i] && distance <= radius) {
                check[i] = true;
                result ++;
            }
        }

        System.out.println(result);
    }
}