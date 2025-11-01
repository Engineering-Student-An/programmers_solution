import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String find = br.readLine();

        int n = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            String plus = line.substring(0, find.length() - 1);

            line += plus;

            for (int j = 0; j < line.length() - find.length() + 1; j++) {
                String sub = line.substring(j, j + find.length());
                if(sub.equals(find)) {
                    count ++;
                    break;
                }
            }
        }

        System.out.println(count);
    }
}