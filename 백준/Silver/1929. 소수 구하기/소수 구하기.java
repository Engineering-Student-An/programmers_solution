import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        boolean[] prime = new boolean[m+1];

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= m; i++) {
            if(!prime[i]){
                if(i>=n){
                    sb.append(i);
                    sb.append("\n");
                }
                for (int j = 2; j*i <= m; j++) {
                    prime[j*i] = true;
                }
            }
        }

        StringBuilder delete = sb.delete(sb.length() - 1, sb.length());

        System.out.print(delete);
    }


}
