import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int block = scanner.nextInt();
        int cross = scanner.nextInt();

        if(x<y) {
            int temp = x;
            x = y;
            y = temp;
        }

        int remain = 0;
        BigInteger ans = BigInteger.ZERO;
        if(cross < block*2){
            ans = ans.add(BigInteger.valueOf((long) y * cross));
            remain = x-y;
            if(cross * 2 < block*2){
                ans = ans.add(BigInteger.valueOf((long) (remain / 2) * cross * 2));
                ans = ans.add(BigInteger.valueOf(((long) (remain % 2) * block)));
            } else{
                ans = ans.add(BigInteger.valueOf((long) remain * block));
            }
        } else {
            ans = ans.add(BigInteger.valueOf((long) (x + y) * block));
        }
        System.out.println(ans);

    }
}
