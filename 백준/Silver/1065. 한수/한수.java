import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int answer = 0;
        if(n<100) {
            answer = n;
        } else{
            answer+=99;
            for(int i=100;i<=n;i++){
                int one = i/100;
                int two = (i%100)/10;
                int three = i%10;
                if(one - two == two-three) answer++;
            }
        }

        System.out.println(answer);
    }


}