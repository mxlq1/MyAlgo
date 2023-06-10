import java.util.Scanner;

public class Turtle {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        int[][] map = new int[n][m];
        String[][] path = new String[n][m];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                map[i][j] = in.nextInt();
            }
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (i == 0 && j == 0){
                    continue;
                }
                else if (i == 0){
                    map[i][j] += map[i][j-1];
                    path[i][j] = "R";
                }
                else if (j == 0){
                    map[i][j] += map[i-1][j];
                    path[i][j] = "D";
                }
                else{
                    //map[i][j] += Math.max(map[i-1][j], map[i][j-1]);
                    if (map[i-1][j] > map[i][j-1]){
                        map[i][j] += map[i-1][j];
                        path[i][j] = "D";
                    }
                    else{
                        map[i][j] += map[i][j-1];
                        path[i][j] = "R";
                    }
                }
            }
        }

        System.out.println(map[n-1][m-1]);

        int i = n-1;
        int j = m-1;
        String s = "";
        while (i != 0 || j != 0){
            if (path[i][j].equals("D")){
                i--;
                s = "D" + " " + s;
            }
            else{
                j--;
                s = "R" + " " + s;
            }
        }
        System.out.print(s);
    }

}
