import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T -- > 0) {
            int n = Integer.parseInt(br.readLine());
            arr = new String[n];
            for (int i = 0; i < n; i++) {
                arr[i] = br.readLine();
            }

            boolean isFound = false;
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    String pal = find(i, j);
                    if (!pal.isEmpty()) {
                        sb.append(pal).append("\n");
                        isFound = true;
                        break;
                    }
                }
                if(isFound) break;
            }

            if(!isFound) sb.append(0).append("\n");
        }

        System.out.print(sb);
    }

    static String find(int i, int j) {
        String first = arr[i] + arr[j];
        String second = arr[j] + arr[i];

        boolean isFirst = true, isSecond = true;
        int l = 0, r = first.length() - 1;
        while(l < r) {
            if(isFirst && first.charAt(l) != first.charAt(r)) {
                isFirst = false;
            }

            if(isSecond && second.charAt(l) != second.charAt(r)) {
                isSecond = false;
            }

            if(!isFirst && !isSecond) break;

            l ++;
            r --;
        }

        if(isFirst) return first;
        if(isSecond) return second;
        return "";
    }
}