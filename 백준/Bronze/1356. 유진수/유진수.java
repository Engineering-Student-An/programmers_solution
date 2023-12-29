import java.util.Scanner;

public class Main{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String num = scanner.next();
        Boolean check = false;
        for(int i=1;i<num.length();i++){
            int mul1=1, mul2=1;
            for(int j=0;j<i;j++){
                mul1 *= (int) (num.charAt(j)-'0');
            }
            for(int j=i;j<num.length();j++){
                mul2 *= (int) (num.charAt(j)-'0');
            }
            if(mul1 == mul2){
                check=true;
                break;
            }
        }
        if(check) System.out.println("YES");
        else System.out.println("NO");
    }
}