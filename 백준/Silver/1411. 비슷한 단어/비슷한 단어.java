import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        int result = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int[] change = new int[26];
                boolean[] visit = new boolean[26];
                for (int k = 0; k < 26; k++) {
                    change[k] = -1;
                }

                boolean isFound = true;
                for (int k = 0; k < arr[i].length(); k++) {
                    char now = arr[i].charAt(k);
                    char next = arr[j].charAt(k);

                    // 이미 앞에서 바꾼 경우
                    if(change[now - 'a'] != -1) {
                        now = (char) ('a' + change[now - 'a']);
                        if(now != next) {
                            isFound = false;
                            break;
                        }
                    }

                    // 안 바꾼 경우
                    else {
                        int c = next - 'a';
                        if(visit[c]) {
                            isFound = false;
                            break;
                        }
                        visit[c] = true;
                        change[now - 'a'] = next - 'a';
                    }
                }

                if(isFound) result ++;
            }
        }

        System.out.println(result);
    }
}