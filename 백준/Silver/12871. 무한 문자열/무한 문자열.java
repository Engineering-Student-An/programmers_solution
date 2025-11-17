import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String t = br.readLine();

        if (s.length() > t.length()) {
            String temp = s;
            s = t;
            t = temp;
        }

        int lcm = lcm(t.length(), s.length());

        String sRepeat = s.repeat(lcm / s.length());
        String tRepeat = t.repeat(lcm / t.length());

        if(sRepeat.equals(tRepeat)) System.out.println(1);
        else System.out.println(0);
    }
    
    static int lcm(int a, int b) {
        int one = a, two = b;

        while(a % b > 0) {
            int mod = a % b;
            a /= b;
            b = mod;
        }
        
        return b * (one / b) * (two / b);
    }
}