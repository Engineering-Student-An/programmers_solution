import java.util.Scanner;

public class Main {

    public static int max = -1;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        String[] word = new String[n];
        for (int i = 0; i < n; i++) {
            word[i] = scanner.next();
        }

        int[] newAlpha = new int[n];             // 글자마다 배워야 할 알파벳 (뒤에서부터 a)
        int allBit = 0;                          // 배워야 할 모든 알파벳

        k -= 5;

        if (k < 0) {
            System.out.println(0);
        } else {
            for (int i = 0; i < n; i++) {
                int bitCheck = 0;
                for (int j = 0; j < 26; j++) {

                    String temp = String.valueOf((char)('a' + j));
                    if (j != 0 && j != 13 && j != 19 && j != 8 && j != 2 && word[i].contains(temp)) {
                        bitCheck |= (1 << j);
                    }
                }
                newAlpha[i] = bitCheck;
            }

            for (int i = 0; i < n; i++) {
                allBit |= newAlpha[i];
            }
            if (k >= Integer.bitCount(allBit)) {    //  가르칠 글자수 >= 배울 글자수 합
                System.out.println(n);
            } else{                                 // 가르칠 글자수 < 배울 글자수 합
                for(int i=0;i< allBit; i++){
                    if(Integer.bitCount(i) == k){
                        setMax(newAlpha, allBit, i);
                    }
                }
                System.out.println(max);
            }
        }

    }

    private static void setMax(int[] newAlpha, int allBit, int i) {
        int count = 0;
        for (int j = 0; j < newAlpha.length; j++) {
            if( (i & newAlpha[j]) == newAlpha[j]){
                count++;
            }
        }
        max = Math.max(max, count);
    }
}