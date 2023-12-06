import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();

        String outside = "";
        String inside = "";

        int[] count = new int[26];
        for (int i = 0; i < name.length(); i++) {
            count[ (name.charAt(i)-'A') ] ++;
        }
        for (int i = 0; i < 26; i++) {
            if(count[i]%2==0){
                for (int j = 0; j < count[i] / 2; j++) {
                    outside += (char)(i + 'A');
                }
            } else if(count[i]>1){
                for (int j = 0; j < count[i] / 2; j++) {
                    outside += (char)(i + 'A');
                }
                inside+=(char)(i + 'A');
            } else if(count[i]==1){
                inside+=(char)(i + 'A');
            }
        }

        if(inside.length() > 1){
            System.out.println("I'm Sorry Hansoo");
        } else{
            System.out.print(outside);
            System.out.print(inside);
            for(int i=outside.length()-1;i>=0;i--){
                System.out.print(outside.charAt(i));
            }
        }

    }
}