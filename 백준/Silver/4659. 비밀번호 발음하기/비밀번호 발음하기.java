import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while(true) {
            String line = br.readLine();
            if(line.equals("end")) break;

            // 모음 포함 여부
            boolean check = true;
            if(!moeum(line)) check = false;

            if(check && !yeonsok(line)) check = false;

            if(check && !twice(line)) check = false;

            if(check) {
                sb.append("<").append(line).append("> is acceptable.\n");
            } else {
                sb.append("<").append(line).append("> is not acceptable.\n");
            }
        }

        System.out.print(sb);
    }

    static boolean twice(String line) {

        char before = line.charAt(0);
        for (int i = 1; i < line.length(); i++) {
            char c = line.charAt(i);
            if(before == c) {
                if(before != 'e' && before != 'o') return false;
            }

            before = c;
        }

        return true;
    }

    static boolean yeonsok(String line) {
        int count = 0;
        boolean isMoeum = false;

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if(isMoeum) {
                if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    count ++;
                } else {
                    isMoeum = false;
                    count = 1;
                }
            } else {
                if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    isMoeum = true;
                    count = 1;
                } else {
                    count ++;
                }
            }

            if(count >= 3) return false;
        }

        return true;
    }

    static boolean moeum(String line) {

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') return true;
        }

        return false;
    }
}