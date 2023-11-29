import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int kim = scanner.nextInt();
        int lim = scanner.nextInt();

        int answer = 1;
        while(n>=1){
            if(Math.abs(kim - lim) == 1 && (kim/2) != (lim/2)){
                break;
            }
            kim = nextRound(kim);
            lim = nextRound(lim);

            n = nextRound(n);
            answer ++;
        }
        if(n<1) System.out.println(-1);
        else System.out.println(answer);
    }

    public static int nextRound(int n) {
        if(n%2==1) return n/2+1;
        return n/2;
    }
}