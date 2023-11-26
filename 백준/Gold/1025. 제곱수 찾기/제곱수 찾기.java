import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        char[][] arr = new char[n][m];

        for(int i=0;i<n;i++){
            String string = scanner.next();
            for (int j = 0; j < m; j++) {
                arr[i][j] = string.charAt(j);
            }
        }

        int maxSquare = -1;
        for (int i = -n+1; i < n; i++) {
            for (int j = -m+1; j < m; j++) {

                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < m; l++) {

                        for(int num = 0; num <= 10; num++) {
                            int checkI=-1, checkJ=-1;
                            String plus = "";
                            for (int mul = 0; mul <= num; mul++) {
                                if (k + i * mul >= 0 && k + i * mul < n && l + j * mul >= 0 && l + j * mul < m && (checkI != k + i * mul || checkJ != l + j * mul)) {
                                    plus += arr[k + i * mul][l + j * mul];
                                    checkI = k + i * mul;
                                    checkJ = l + j * mul;
                                }
                            }
                            if(isSquare(plus) && maxSquare<Integer.parseInt(plus)) maxSquare = Integer.parseInt(plus);
                        }
                    }
                }
            }
        }
        System.out.println(maxSquare);
    }

    public static boolean isSquare(String n) {
        if(n.isEmpty()) return false;
        return Math.sqrt(Integer.parseInt(n)) % 1 == 0;
    }
}