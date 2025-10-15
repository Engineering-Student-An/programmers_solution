import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double x = Double.parseDouble(st.nextToken());
        double y = Double.parseDouble(st.nextToken());
        double d = Double.parseDouble(st.nextToken());
        double t = Double.parseDouble(st.nextToken());

        double len = Math.sqrt(x * x + y * y);

        if(d <= t) System.out.println(len);
        else {
            double time = 0.0;
            while(len >= d * 2) {
                len -= d;
                time += t;
            }

            // 딱 d만큼 남은 경우
            if(len == d) System.out.println(time + t);

            // t*2 or 점프하고 걷기 or 그냥 걷기
            else {
                double twice = t * 2;
                double jumpAndWalk = Math.abs(len - d) + t;
                
                System.out.println(time + Math.min(len, Math.min(twice, jumpAndWalk)));
            }
        }
    }
}