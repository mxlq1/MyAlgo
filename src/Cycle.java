import java.util.HashMap;
import java.util.Scanner;

public class Cycle {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        HashMap<Character, StringBuilder> graph = new HashMap<>();
        HashMap<Character, Boolean> grey = new HashMap<>();
        HashMap<Character, Boolean> black = new HashMap<>();
        boolean[] flag = {false};

        for (int k = 0; k < n; k++){
            Character g = Character.forDigit(k+1, 10);
            graph.put(g, new StringBuilder());
            grey.put(g, false);
            black.put(g, false);
        }

        for (int i = 0; i < n; i++){
            Character i_1 = Character.forDigit(i+1, 10);
            for (int j = 0; j < n; j++){
                int q = in.nextInt();
                if (q == 1){
                    StringBuilder a = graph.get(i_1);
                    a.append(j+1);
                    graph.put(i_1, a);
                }
            }
        }

        for (Character v: graph.keySet()){
            if (!grey.get(v) && !black.get(v)){
                dfs(v, graph, grey, black, flag);
            }
        }

        if (flag[0]){
            System.out.println(1);
        }
        else{
            System.out.println(0);
        }
    }

    static void dfs(Character v, HashMap<Character, StringBuilder> graph, HashMap<Character, Boolean> grey, HashMap<Character, Boolean> black, boolean[] flag){
        grey.put(v, true);

        for (int to = 0; to < graph.get(v).length(); to++){
            if (!grey.get(graph.get(v).charAt(to)) && !black.get(graph.get(v).charAt(to))){
                dfs(graph.get(v).charAt(to), graph, grey, black, flag);
            }
            else if (grey.get(graph.get(v).charAt(to))){
                flag[0] = true;
            }
        }
        black.put(v, true);
    }
}
