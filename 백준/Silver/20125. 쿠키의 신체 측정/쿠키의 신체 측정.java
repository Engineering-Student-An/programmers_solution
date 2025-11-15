import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static boolean[][] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new boolean[n + 1][n + 1];

        Info head = null;
        for (int i = 1; i <= n; i++) {
            String line = br.readLine();
            for (int j = 1; j <= n; j++) {
                char c = line.charAt(j - 1);
                if(c == '*') arr[i][j] = true;
                if(head == null && arr[i][j]) head = new Info(i, j);
            }
        }

        Info heart = null;
        int leftHand = 1, rightHand = 1;
        int leftFoot = 0, rightFoot = 0;
        int waist;
        for (int k = 0; head.r + k <= n; k++) {
            if(arr[head.r + k][head.c] && arr[head.r + k][head.c - 1] && arr[head.r + k][head.c + 1]) {
                heart = new Info(head.r + k, head.c);

                for (leftHand = 1; heart.c - leftHand >= 1 && arr[heart.r][heart.c - leftHand]; leftHand++) {}
                leftHand --;

                for (rightHand = 1; heart.c + rightHand <= n && arr[heart.r][heart.c + rightHand]; rightHand++) {}
                rightHand --;
                break;
            }
        }

        for (waist = 1; heart.r + waist <= n && arr[heart.r + waist][heart.c]; waist++) {}
        waist--;

        int footStart = heart.r + waist + 1;
        for (int k = 0; footStart + k <= n; k++) {
            if(arr[footStart + k][heart.c - 1]) leftFoot ++;
            if(arr[footStart + k][heart.c + 1]) rightFoot ++;
        }

        System.out.println(heart.r + " " + heart.c);
        System.out.println(leftHand + " " + rightHand + " " + waist + " " + leftFoot + " " + rightFoot);
    }

    static class Info {
        int r, c;

        public Info(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}