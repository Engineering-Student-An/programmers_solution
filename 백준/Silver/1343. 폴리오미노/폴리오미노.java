import java.util.Scanner;

public class Main{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();

        int cont = 0;
        Boolean check = true;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            if(string.charAt(i) == 'X') cont++;
            else{
                if(cont % 2 != 0) {
                    check = false;
                    break;
                }
                // A
                sb.append("A".repeat(Math.max(0, (cont / 4) * 4)));
                cont = cont - (cont/4) * 4;
                sb.append("B".repeat(Math.max(0, (cont / 2) * 2)));
                sb.append('.');
                cont = 0;
            }
        }
        if(cont!=0){
            if(cont %2 != 0) check = false;
            else{
                sb.append("A".repeat(Math.max(0, (cont / 4) * 4)));
                cont = cont - (cont/4) * 4;
                sb.append("B".repeat(Math.max(0, (cont / 2) * 2)));
            }
        }

        if(!check){
            System.out.println(-1);
        } else{
            System.out.println(sb);
        }

    }
}