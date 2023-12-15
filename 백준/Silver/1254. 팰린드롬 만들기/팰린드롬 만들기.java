import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();

        int ans = -1;
        for (int i = word.length() / 2; i < word.length(); i++) {
            for (int j = 0; j <= 1; j++) {
                String before = word.substring(0,i);
                StringBuffer sb = new StringBuffer(before);
                before = sb.reverse().toString();
                String after = word.substring(i+j);

                if(before.startsWith(after)){
                    ans = before.length() - after.length();
                    break;
                }
            }
            if(ans!=-1) break;

        }

        System.out.println(word.length() + ans);

    }
}