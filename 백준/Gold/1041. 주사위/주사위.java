import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[7];     // A B C D E F 입력받은 배열
        for (int i = 1; i <= 6; i++) {
            arr[i] = scanner.nextInt();
        }

        long[] min = {0L, 200L, 200L, 200L};     // 3개, 2개, 1개의 합의 최소값
        for(int i=1;i<=6;i++){
            if(arr[i] < min[1]) min[1] = arr[i];
        }

        for(int i=1;i<=6;i++){
            for(int j=i+1;j<=6;j++){
                if(i+j!=7){
                    if(arr[i]+arr[j] < min[2]) min[2] = arr[i] + arr[j];
                }
            }
        }

        for(int i=1;i<=6;i++){
            for(int j=i+1;j<=6;j++){
                for(int k=j+1;k<=6;k++){
                    if(i+j!=7 && i+k!=7 && j+k!=7){
                        if(arr[i]+arr[j]+arr[k] < min[3]) min[3] = arr[i] + arr[j] + arr[k];
                    }
                }

            }
        }

        // x축 1, N 번째 index
        BigInteger sum1 = BigInteger.ZERO;
        sum1 = sum1.add(BigInteger.valueOf(min[3]*2));
        sum1 = sum1.add(BigInteger.valueOf(min[2]*(3*n-4)));
        sum1 = sum1.add(BigInteger.valueOf(min[1]*(n-1)*(n-2)));
        sum1 = sum1.multiply(BigInteger.TWO);

        // x축 나머지 index
        BigInteger sum2 = BigInteger.ZERO;
        sum2 = sum2.add(BigInteger.valueOf(min[2]*2));
        sum2 = sum2.add(BigInteger.valueOf(min[1]*(3*n-4)));
        sum2 = sum2.multiply(BigInteger.valueOf((n-2)));

        BigInteger sum = BigInteger.ZERO;
        sum = sum.add(sum1);
        sum = sum.add(sum2);
        if(n==1){
            Arrays.sort(arr);
            System.out.println(arr[1]+arr[2]+arr[3]+arr[4]+arr[5]);
        }else{
            System.out.println(sum);
        }
    }
}