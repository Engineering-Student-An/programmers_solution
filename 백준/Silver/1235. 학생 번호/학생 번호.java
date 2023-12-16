import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        String[] name = new String[n];
        for (int i = 0; i < n; i++) {
            name[i] = scanner.next();
        }
        Boolean ans = false;
        for (int i = 1; i < name[0].length(); i++) {
            String[] temp = new String[n];
            for (int j = 0; j < n; j++) {
                temp[j] = name[j].substring(name[j].length() - i);
            }
            Boolean isEqual = false;
            for (int j = 0; j < n-1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if(temp[j].equals(temp[k])){
                        isEqual = true;
                        break;
                    }
                }
                if(isEqual) break;
            }
            if(!isEqual){
                ans = true;
                System.out.println(i);
                break;
            }
        }
        if(!ans) System.out.println(name[0].length());
    }
}