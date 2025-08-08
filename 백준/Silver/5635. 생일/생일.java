import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Info> max = new PriorityQueue<>(new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                if(o1.year == o2.year) {
                    if(o1.month == o2.month) {
                        return o1.day - o2.day;
                    }
                    return o1.month - o2.month;
                }
                return o1.year - o2.year;
            }
        });
        PriorityQueue<Info> min = new PriorityQueue<>(new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                if(o1.year == o2.year) {
                    if(o1.month == o2.month) {
                        return o2.day - o1.day;
                    }
                    return o2.month - o1.month;
                }
                return o2.year - o1.year;
            }
        });
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Info now = new Info(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            max.add(now);
            min.add(now);
        }

        System.out.println(min.poll().name);
        System.out.println(max.poll().name);
    }

    static class Info {
        String name;
        int day, month, year;

        public Info(String name, int day, int month, int year) {
            this.name = name;
            this.month = month;
            this.day = day;
            this.year = year;
        }
    }
}
