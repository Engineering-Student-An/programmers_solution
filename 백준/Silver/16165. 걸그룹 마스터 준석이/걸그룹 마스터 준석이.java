import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<String>[] team = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            team[i] = new ArrayList<>();
        }

        String[] teamNames = new String[n];
        Map<String, Integer> teamIndex = new HashMap<>();
        Map<String, Integer> memberIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String teamName = br.readLine();
            teamNames[i] = teamName;

            teamIndex.put(teamName, i);

            int s = Integer.parseInt(br.readLine());
            for (int j = 0; j < s; j++) {
                String name = br.readLine();

                memberIndex.put(name, i);
                team[i].add(name);
            }

            Collections.sort(team[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String name = br.readLine();
            int type = Integer.parseInt(br.readLine());

            if(type == 0) {
                int index = teamIndex.get(name);
                for (String member : team[index]) {
                    sb.append(member).append("\n");
                }
            } else {
                int index = memberIndex.get(name);
                sb.append(teamNames[index]).append("\n");
            }
        }

        System.out.print(sb);
    }
}