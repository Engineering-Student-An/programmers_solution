import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[] month = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int sum = 0;
        for (int i = 1; i < m; i++) {
            sum += month[i];
        }

        sum += d;
        int r = sum % 7;
        if(r == 1) System.out.println("MON");
        else if(r == 2) System.out.println("TUE");
        else if(r == 3) System.out.println("WED");
        else if(r == 4) System.out.println("THU");
        else if(r == 5) System.out.println("FRI");
        else if(r == 6) System.out.println("SAT");
        else System.out.println("SUN");
    }
}