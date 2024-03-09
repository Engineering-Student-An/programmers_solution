import java.util.Scanner;

public class Main {

    public static int ans = 0;
    public static int[] arr;
    public static int[] chk;

    public static void main(String[] args) {

       Scanner scanner = new Scanner(System.in);

       int n = scanner.nextInt();
       int p = scanner.nextInt();

       String word = scanner.next();

        arr = new int[4];
        for (int i = 0; i < 4; i++) {
            arr[i] = scanner.nextInt();
        }

        int start = 0;
        int end = p-1;

        chk = new int[4];
        for (int i = start; i <= end; i++) {
            char now = word.charAt(i);
            if(now == 'A') {
                chk[0] ++;
            } else if(now == 'C') {
                chk[1] ++;
            } else if(now == 'G') {
                chk[2] ++;
            } else if(now == 'T') {
                chk[3]++;
            }
        }

        if(!isCheck(chk, arr)) ans ++;


        start ++;
        end ++;
        while (end < n) {

            delete(word, start-1);
            add(word, end);

            boolean check = isCheck(chk, arr);
            if(!check) {
                ans ++;
            }
            start ++;
            end ++;
        }
        System.out.println(ans);
    }

    private static void add(String word, int end) {
        char now = word.charAt(end);
        if(now == 'A') {
            chk[0] ++;
        } else if(now == 'C') {
            chk[1] ++;
        } else if(now == 'G') {
            chk[2] ++;
        } else if(now == 'T') {
            chk[3] ++;
        }
    }

    private static void delete(String word, int start) {
        char now = word.charAt(start);
        if(now == 'A') {
            chk[0] --;
        } else if(now == 'C') {
            chk[1] --;
        } else if(now == 'G') {
            chk[2] --;
        } else if(now == 'T') {
            chk[3] --;
        }
    }

    private static boolean isCheck(int[] chk, int[] arr) {
        boolean check = false;
        for (int i = 0; i < 4; i++) {
            if(chk[i] < arr[i]) {
                check = true;
                break;
            }
        }
        return check;
    }
}