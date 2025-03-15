import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String monthString = scanner.next();
        String dayString = scanner.next();
        int day = (dayString.split(",")[0].charAt(0)-'0') * 10 + dayString.split(",")[0].charAt(1)-'0';

        String yearString = scanner.next();
        int year = (yearString.charAt(0) - '0') * 1000 + (yearString.charAt(1) - '0') * 100 + (yearString.charAt(2) - '0') * 10 + (yearString.charAt(3) - '0');

        String time = scanner.next();

        String[] split = time.split(":");
        int hour = (split[0].charAt(0) - '0') * 10 + (split[0].charAt(1) - '0');
        int minute = (split[1].charAt(0) - '0') * 10 + (split[1].charAt(1) - '0');
        
        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        long total = 365;
        if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)){
            days[2] ++;
            total ++;
        }
        total *= 24 * 60;
        
        int month = 0;
        if(monthString.equals("January")) month = 1;
        else if(monthString.equals("February")) month = 2;
        else if(monthString.equals("March")) month = 3;
        else if(monthString.equals("April")) month = 4;
        else if(monthString.equals("May")) month = 5;
        else if(monthString.equals("June")) month = 6;
        else if(monthString.equals("July")) month = 7;
        else if(monthString.equals("August")) month = 8;
        else if(monthString.equals("September")) month = 9;
        else if(monthString.equals("October")) month = 10;
        else if(monthString.equals("November")) month = 11;
        else if(monthString.equals("December")) month = 12;


        long sum = 0;
        for (int i = 0; i < month; i++) {
            sum += days[i];
        }
        sum += day-1;
        sum *= 24 * 60;

        sum += (60L * hour) + minute;

        System.out.println((double) sum / total * 100);
    }
}