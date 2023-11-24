import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] count = new int[26];
        String str = scanner.nextLine();
        str = str.toUpperCase();

        for (int i = 0; i < str.length(); i++) {
            count[(str.charAt(i) - 'A')] ++;
        }

        int max = 0;
        char ch = '?';
        for (int i = 0; i < 26; i++) {
            if(count[i]>max){
                 ch = (char) ('A' + i);
                 max = count[i];
            } else if (count[i] == max) {
                ch = '?';
            }
        }

        System.out.println(ch);
    }
}