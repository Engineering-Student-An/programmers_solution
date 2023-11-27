import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        ArrayList<BigInteger> arr = new ArrayList<>();
        for (long i = 0; i <= 9; i++) {
            arr.add(BigInteger.valueOf(i));
        }
        for(int i=2;i<=10;i++){
            num(n, arr, i, "", true);
        }
        
        if(arr.size() <= n){
            System.out.println(-1);
        }
        else{
            System.out.println(arr.get(n));
        }
    }

    public static void num(int n, ArrayList<BigInteger> arr, int digit, String now, Boolean isFirst){

        if(digit == 0){
            if(!new BigInteger(now).equals(BigInteger.ZERO)) arr.add(BigInteger.valueOf(Long.parseLong(now)));
            return;
        }
        for(int i=0;i<=9;i++){
            if(isFirst && i==0){
                continue;
            } else if(isFirst && i!=0){
                now += Long.toString(i);
                num(n, arr, digit - 1, now, false);
                now = now.substring(0, now.length() - 1);
            } else if(!isFirst){
                if (Integer.parseInt(String.valueOf(now.charAt(now.length()-1))) > i) {

                    now += Long.toString(i);
                    num(n, arr, digit - 1, now, false);
                    now = now.substring(0, now.length() - 1);
                }
            }
        }

    }
}