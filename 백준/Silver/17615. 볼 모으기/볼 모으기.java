import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String line = br.readLine();

        int last = 0;
        for (int i = line.length() - 2; i >= 0; i--) {
            if(line.charAt(line.length() - 1) != line.charAt(i)) {
                last = i;
                break;
            }
        }

        int R = 0, B = 0;
        for (int i = 0; i <= last; i++) {
            if(line.charAt(i) == 'R') R ++;
            else B ++;
        }

        int result = Math.min(R, B);

        int first = 0;
        for (int i = 1; i < line.length(); i++) {
            if(line.charAt(0) != line.charAt(i)) {
                first = i;
                break;
            }
        }

        R = 0;
        B = 0;
        for (int i = first; i < line.length(); i++) {
            if(line.charAt(i) == 'R') R ++;
            else B ++;
        }

        result = Math.min(Math.min(R, B), result);
        System.out.println(result);
    }
}