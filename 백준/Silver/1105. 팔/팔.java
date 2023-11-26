import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String l = scanner.next();
        String r = scanner.next();
        int answer = 0;
        if(l.length() == r.length()) {
            for (int i = 0; i < l.length(); i++) {
                if (l.charAt(i) == r.charAt(i)) {
                    if (l.charAt(i) == '8') {
                        answer++;
                    }
                } else {
                    break;
                }
            }
        }
        System.out.println(answer);
    }

}
