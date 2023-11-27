import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        BigInteger[] arr = new BigInteger[n];
        for(int i=0;i<n;i++){
            arr[i] = BigInteger.valueOf(scanner.nextLong());
        }

        int sum[] = new int[n];
        for (int i = 0; i < n; i++) {

            // 건물 기준 왼쪽
            for(int j=i-1;j>=0;j--){
                Boolean avail = true;
                for(int k=j+1; k<i;k++){    // i와 j 사이 체크
                    if( arr[k].multiply(BigInteger.valueOf(i-j)).compareTo(arr[j].multiply(BigInteger.valueOf(i-k)).
                            add(arr[i].multiply(BigInteger.valueOf(k-j)))) != -1){
                        avail = false;
                    }
                }
                if(avail) sum[i]++;
            }


            // 건물 기준 오른쪽
            for(int j=i+1;j<n;j++){
                Boolean avail = true;

                for(int k=i+1; k<j;k++){
                    if( arr[k].multiply(BigInteger.valueOf(j-i)).compareTo(arr[j].multiply(BigInteger.valueOf(k-i)).
                            add(arr[i].multiply(BigInteger.valueOf(j-k)))) != -1){
                        avail = false;
                    }
                }
                if(avail) sum[i]++;
            }
        }
        Arrays.sort(sum);
        System.out.println(sum[sum.length-1]);
    }
}