import java.text.ParseException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException{

        Scanner scanner = new Scanner(System.in);

        String start_year = scanner.next();
        String start_month = scanner.next();
        String start_day = scanner.next();

        String finish_year = scanner.next();
        String finish_month = scanner.next();
        String finish_day = scanner.next();

        String startString = String.format("%4s",start_year).replace(" ", "0")
                + "-" + String.format("%2s", start_month).replace(" ", "0")
                + "-" + String.format("%2s",start_day).replace(" ", "0");
        String finishString = String.format("%4s",finish_year).replace(" ", "0")
                + "-" + String.format("%2s", finish_month).replace(" ", "0")
                + "-" + String.format("%2s",finish_day).replace(" ", "0");

        LocalDate startDate = LocalDate.parse(startString);
        LocalDate finishDate = LocalDate.parse(finishString);

        if(ChronoUnit.YEARS.between(startDate, finishDate) >=1000){
            System.out.println("gg");
        } else{
            System.out.println("D-" + ChronoUnit.DAYS.between(startDate, finishDate));
        }
    }
}