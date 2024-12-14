import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        char[] arr = new char[n];
        String line = scanner.next();
        for (int i = 0; i < n; i++) {
            arr[i] = line.charAt(i);
        }

        int nowR = 0;
        int nowC = 0;
        int[] dirR = {1, 0, -1, 0};
        int[] dirC = {0, -1, 0 , 1};
        int dir = 0;

        List<Node> list = new ArrayList<>();
        list.add(new Node(0, 0));
        for (int i = 0; i < n; i++) {
            if(arr[i] == 'L') {
                dir = (dir+3) % 4;
            } else if(arr[i] == 'R') {
                dir = (dir+1) % 4;
            } else {
                nowR += dirR[dir];
                nowC += dirC[dir];

                list.add(new Node(nowR, nowC));
            }
        }

        int minR = 0;
        int minC = 0;
        for (Node node : list) {
            if(minR > node.row) minR = node.row;
            if(minC > node.col) minC = node.col;
        }

        int maxR = -1;
        int maxC = -1;
        PriorityQueue<Node> newList = new PriorityQueue<>(new NodeComparator());
        for (Node node : list) {
            int newR = (minR < 0) ? node.row - minR : node.row;
            int newC = (minC < 0) ? node.col - minC : node.col;
            maxR = Math.max(maxR, newR);
            maxC = Math.max(maxC, newC);
            Node newNode = new Node(newR, newC);

            if(newList.isEmpty()) {
                newList.add(newNode);
            } else {
                boolean isSame = false;
                for (Node node1 : newList) {
                    if(node1.row == newNode.row && node1.col == newNode.col) {
                        isSame = true;
                    }
                }
                if(!isSame) newList.add(newNode);
            }
        }

        Node check = newList.poll();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= maxR; i++) {
            for (int j = 0; j <= maxC; j++) {
                if(check != null && i == check.row && j == check.col) {
                    sb.append(".");
                    check = newList.poll();
                } else {
                    sb.append("#");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static class Node {
        int row;
        int col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static class NodeComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            if(o1.row == o2.row) {
                return o1.col - o2.col;
            }
            return o1.row - o2.row;
        }
    }
}