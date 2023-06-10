import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Dijkstra {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int b = in.nextInt();
        int e = in.nextInt();

        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < m; i++){
            int s = in.nextInt();
            int f = in.nextInt();
            int w = in.nextInt();
            graph.get(s-1).add(new Pair(f-1, w));
            graph.get(f-1).add(new Pair(s-1, w));
        }

        int[] d = new int[n];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[b-1] = 0;
        int[] p = new int[n];
        boolean[] used = new boolean[n];

        for (int i = 0; i < n; i++){
            int v = -1;
            for (int j = 0; j < n; j++){
                if (!used[j] && (v == -1 || d[j] < d[v])){
                    v = j;
                }

            }
            if (d[v] == Integer.MAX_VALUE) break;
            used[v] = true;

            for (int j = 0; j < graph.get(v).size(); j++){
                int to = graph.get(v).get(j).first;
                int weight = graph.get(v).get(j).second;

                if (d[v] + weight < d[to]){
                    d[to] = d[v] + weight;
                    p[to] = v;
                }
            }
        }

        ArrayList<Integer> path = new ArrayList<>();
        System.out.print(d[e-1] + " ");
        for (int v = e-1; v!=b-1;v = p[v]){
            path.add(v);
        }
        path.add(b-1);
        int counter = 0;
        String s = "";

        for(int x = path.size() - 1; x >= 0; x--){
            s += path.get(x) + 1 + " ";
            counter++;
        }
        System.out.println(counter);
        System.out.print(s);

    }

}

class Pair{
    int first;
    int second;

    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}