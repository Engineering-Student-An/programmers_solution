import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        System.out.println((n%2 == 0) ? "SK" : "CY");
    }
}