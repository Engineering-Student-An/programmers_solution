import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        int result = 0;
        int stick = 0;
        int index = 0;

        while(index < line.length()) {

            char now = line.charAt(index);

            // 레이저
            if(now == '(' && line.charAt(index + 1) == ')') {
                result += stick;
                index ++;
            } else if(now == '(') {
                stick ++;
            } else {
                stick --;
                result ++;
            }

            index ++;
        }

        System.out.println(result);
    }
}