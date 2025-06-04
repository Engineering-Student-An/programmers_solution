import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String original = scanner.next();
        String find = scanner.next();
        int findLen = find.length();

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < original.length(); i++) {
            stack.push(original.charAt(i));

            if (stack.size() >= findLen && stack.peek() == find.charAt(findLen - 1)) {
                List<Character> list = new ArrayList<>();
                boolean isFound = true;
                int index = findLen - 1;

                while(!stack.isEmpty() && index >= 0) {
                    Character pop = stack.pop();
                    list.add(pop);
                    if(pop != find.charAt(index)) {
                        isFound = false;
                        break;
                    } else {
                        index --;
                    }
                }

                if(!isFound) {
                    for (int j = list.size() - 1; j >= 0; j --) {
                        stack.push(list.get(j));
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println((sb.length() == 0) ? "FRULA" : sb.reverse());
    }
}