import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first = br.readLine();
        String second = br.readLine();

        int[][] lcs = new int[second.length()+1][first.length()+1];
//        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= second.length(); i++) {
            for (int j = 1; j <= first.length(); j++) {
                char f = first.charAt(j - 1);
                char s = second.charAt(i - 1);

                if(f!=s) lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
                else lcs[i][j] = lcs[i-1][j-1] + 1;
                
            }
        }
        System.out.println(lcs[second.length()][first.length()]);
    }
}