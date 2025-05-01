import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first = br.readLine();
        String second = br.readLine();

        int secondLen = second.length();
        int firstLen = first.length();
        int[][] lcs = new int[secondLen + 1][firstLen + 1];

        for (int i = 1; i <= secondLen; i++) {
            for (int j = 1; j <= firstLen; j++) {
                char f = first.charAt(j - 1);
                char s = second.charAt(i - 1);

                if (f != s) lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                else lcs[i][j] = lcs[i - 1][j - 1] + 1;

            }
        }

        System.out.println(lcs[secondLen][firstLen]);
        if (lcs[secondLen][firstLen] > 0) {
            String result = "";
            int i = secondLen;
            int j = firstLen;

            while (i >= 1 && j >= 1) {
                if (first.charAt(j - 1) == second.charAt(i - 1)) {
                    result = first.charAt(j - 1) + result;
                    i--;
                    j--;
                } else {
                    if (lcs[i - 1][j] > lcs[i][j - 1]) {
                        i--;
                    } else {
                        j--;
                    }
                }
            }
            System.out.println(result);
        }
    }
}