import java.util.Scanner;

public class Main{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
        for (int i = 0; i < n; i++) {
            String word = scanner.next();
            Boolean[] check = new Boolean[26];
            for (int j = 0; j < 26; j++) {
                check[j] = false;
            }
            Boolean isTrue = true;
            char c = word.charAt(0);

            check[(int) (c - 'a')] = true;
            for(int j=1;j<word.length();j++){
                if(word.charAt(j) == c){
                    continue;
                } else if(check[(int) (word.charAt(j) - 'a')]){
                    isTrue = false;
                    break;
                } else{
                    c = word.charAt(j);
                    check[(int) (c - 'a')] = true;
                }
            }
            if(isTrue) count ++;
        }
        System.out.println(count);

    }
}