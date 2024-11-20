import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String word = scanner.next();
        String[] alpa = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        int ind = 0;
        int result = 0;
        while(ind < word.length()) {
            boolean isCro = false;
            for (int i = 0; i < 8; i++) {
                if(ind + alpa[i].length() <= word.length()) {
                    String now = word.substring(ind, ind + alpa[i].length());
                    if (now.equals(alpa[i])) {
                        result++;
                        isCro = true;
                        ind += alpa[i].length();
                        break;
                    }
                }
            }
            if(!isCro) {
                result ++;
                ind ++;
            }
        }

        System.out.println(result);
    }
}