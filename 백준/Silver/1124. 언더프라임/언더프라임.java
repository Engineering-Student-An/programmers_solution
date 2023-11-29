import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        Boolean[] primeCheck = new Boolean[100001];

        int ans = 0;
        for (int i = a; i <= b; i++) {
            int number = factorization(i);
            if(isPrime(number)) {
                ans++;
            }
        }

        System.out.println(ans);
    }

    public static int factorization(int n){
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 2; i * i <= n; i++) {
            while(n%i==0) {
                arr.add(i);
                n /= i;
            }
        }
        if(n>1) arr.add(n);
        return arr.size();
    }

    public static Boolean isPrime(int n) {
        if(n<=1) return false;
        for(int i=2;i<n;i++){
            if(n%i == 0) return false;
        }
        return true;
    }
}