import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        String[] str = new String[n];

        int rowCount = 0; int colCount = 0;
        Boolean rowBool, colBool;

        for(int i=0;i<n;i++){
            rowBool=true;
            str[i] = scanner.next();
            for(int j=0;j<str[i].length();j++){
                if (str[i].charAt(j) == 'X') {
                    rowBool = false;
                    break;
                }
            }
            if(rowBool) rowCount ++;
        }
        for(int i=0;i<m;i++){
            colBool=true;
            for(int j=0;j<str.length;j++){
                if (str[j].charAt(i) == 'X') {
                    colBool = false;
                    break;
                }
            }
            if(colBool) colCount++;
        }

        System.out.println(Math.max(rowCount,colCount));
    }
}