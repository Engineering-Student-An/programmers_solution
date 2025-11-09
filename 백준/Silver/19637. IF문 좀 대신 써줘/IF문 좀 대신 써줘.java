import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Name[] names = new Name[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            names[i] = new Name(st.nextToken(), Integer.parseInt(st.nextToken()));
        }

        StringBuilder sb = new StringBuilder();
        Info[] infos = new Info[m];
        for (int i = 0; i < m; i++) {
            infos[i] = new Info(i, Integer.parseInt(br.readLine()));
        }

        Arrays.sort(infos, new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                return Integer.compare(o1.power, o2.power);
            }
        });

        Name[] result = new Name[m];
        int index = 0;
        for (int i = 0; i < m; i++) {
            while(names[index].max < infos[i].power) {
                index ++;
            }

            result[i] = new Name(names[index].name, infos[i].index);
        }

        Arrays.sort(result, new Comparator<Name>() {
            @Override
            public int compare(Name o1, Name o2) {
                return Integer.compare(o1.max, o2.max);
            }
        });

        for (int i = 0; i < m; i++) {
            sb.append(result[i].name).append("\n");
        }

        System.out.print(sb);
    }

    static class Name {
        String name;
        int max;

        public Name(String name, int max) {
            this.name = name;
            this.max = max;
        }
    }

    static class Info {
        int index, power;

        public Info(int index, int power) {
            this.index = index;
            this.power = power;
        }
    }
}