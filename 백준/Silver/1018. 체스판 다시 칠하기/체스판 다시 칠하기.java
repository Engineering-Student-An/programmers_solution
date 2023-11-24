import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();
        int n = scanner.nextInt();

        String[] chessW = new String[8];
        String[] chessB = new String[8];

        for(int i=0;i<8;i++)
        {
            if(i%2==0){
                chessW[i] = "WBWBWBWB";
                chessB[i] = "BWBWBWBW";
            } else{
                chessW[i] = "BWBWBWBW";
                chessB[i] = "WBWBWBWB";
            }
        }

        String[] str = new String[m];
        for (int i = 0; i < m; i++) {
            str[i] = scanner.next();
        }

        int min = 100;
        for (int i = 0; i <= m - 8; i++) {
            for (int j = 0; j <= n - 8; j++) {
                int countW = 0;
                int countB = 0;
                for (int k = i; k < i + 8; k++) {
                    for (int l = j; l < j + 8; l++) {
                        if(str[k].charAt(l) != chessW[k-i].charAt(l-j)) countW ++;
                        if(str[k].charAt(l) != chessB[k-i].charAt(l-j)) countB ++;
                    }
                }
                min = Math.min(min, (Math.min(countW, countB)));
            }
        }

        System.out.println(min);
    }
}