import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(T -- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int count = 0;
            long a;
            int gcd = gcd(m, n);
            long lcm = (long) gcd * (m / gcd) * (n / gcd);
            
            while(true) {

                a = x + ((long) m * count);
                if(a > lcm) {
                    a = -1;
                    break;
                }

                if((a - y) % n == 0) break;

                count ++;
            }

            sb.append(a).append("\n");
        }

        System.out.print(sb);
    }

    static int gcd(int a, int b) {
        if(a < b) {
            int temp = a;
            a = b;
            b = temp;
        }

        while(b > 0) {
            int mod = a % b;
            a = b;
            b = mod;
        }

        return a;
    }
}


/*
3 -> 13 -> 23 -> 33 ...
9 -> 21 -> 33

2 -> 14 -> 26 -> 32 -> 44 -> 56 -> 68
7 -> 17 -> 27 -> 37 -> 47 -> 57 -> 67

6 -> 17 -> 28 -> 39 -> 50 - > 61 -> 72 -> 83 ...
5 -> 18 -> 31 -> 44 -> 57 -> 70 -> 83 ...


10 12 -> 60
 */