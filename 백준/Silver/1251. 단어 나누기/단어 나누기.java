import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String x = scanner.nextLine();
        int size = x.length();

        StringBuffer word = new StringBuffer(x);
        String min = "{";

        for (int i = 1; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                StringBuffer makeWord1 = new StringBuffer(word.substring(0,i)).reverse();
                StringBuffer makeWord2 = new StringBuffer(word.substring(i,j)).reverse();
                StringBuffer makeWord3 = new StringBuffer(word.substring(j,size)).reverse();
                String makeWord = makeWord1.toString() + makeWord2.toString() + makeWord3.toString();
                if(min.compareTo(makeWord) > 0) {
                    min=makeWord;
                }

            }
        }
        System.out.println(min);

    }
}