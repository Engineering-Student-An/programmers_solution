import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        BigInteger[][] arr = new BigInteger [30][30];
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
                arr[i][j] = BigInteger.ZERO;
            }
        }
        BigInteger[] fact = new BigInteger[30];
        fact[0] = BigInteger.ONE; fact[1] = BigInteger.ONE;
        for(int i=2;i<30;i++){
            fact[i] = fact[i-1].multiply(BigInteger.valueOf(i));
        }
        for(int i=0;i<t;i++){

            int n = scanner.nextInt();
            int m = scanner.nextInt();

            // m C n

            if(!arr[m][n].equals(BigInteger.ZERO)) {
                System.out.println(arr[m][n]);
            }
            else{
                for (int j = 0; j <= m / 2; j++) {
                    arr[m][j] = fact[m].divide(fact[m-j].multiply(fact[j]));
                }
                for(int j=m/2+1;j<=m;j++){
                    arr[m][j] = arr[m][m-j];
                }
                System.out.println(arr[m][n]);
            }
        }

    }
}