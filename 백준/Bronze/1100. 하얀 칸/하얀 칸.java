
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int count = 0;

        for(int i=0;i<8;i++){
            String row = scanner.nextLine();
            if (i % 2 == 0) {
                for(int j=0;j<8;j+=2){
                    if(row.charAt(j) == 'F') count++;
                }
            } else{
                for(int j=1;j<8;j+=2){
                    if(row.charAt(j)=='F') count++;
                }
            }
        }
        System.out.println(count);
    }
}