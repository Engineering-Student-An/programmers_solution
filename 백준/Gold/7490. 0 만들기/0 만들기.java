import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static char[] m = {' ', '+', '-'};
    static char[] pick;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while(T -- > 0) {
            n = Integer.parseInt(br.readLine());
            pick = new char[n];
            find(1);
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static void find(int index) {
        if(index == n) {
            check();
            return;
        }

        for (int i = 0; i < 3; i++) {
            pick[index] = m[i];
            find(index + 1);
        }
    }

    static void check() {
        String line = "";
        StringBuilder fullLine = new StringBuilder();
        for (int i = 1; i < n; i++) {
            line += Integer.toString(i);
            if(pick[i] != ' ') line += Character.toString(pick[i]);

            fullLine.append(i).append(pick[i]);
        }
        line += n;
        fullLine.append(n);

        char m = '+';
        int sum = 0;    
        int now = line.charAt(0) - '0';
        for (int i = 1; i < line.length(); i++) {
            char c = line.charAt(i);
            if(c == '+' || c == '-') {
                sum = (m == '+') ? sum + now : sum - now;
                m = c;
                now = 0;
            } else {
                now *= 10;
                now += c - '0';
            }

            if(i == line.length() - 1) sum = (m == '+') ? sum + now : sum - now;

        }

        if(sum == 0) sb.append(fullLine).append("\n");
    }
}