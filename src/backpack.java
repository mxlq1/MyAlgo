import java.util.Scanner;
public class backpack  { // classic

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int[] mas = new int[n+1];
        int[] cost = new int[n+1];
        int[][] dp = new int[n+1][m+1];

        for (int i = 1; i <= n; i++){
            mas[i] = in.nextInt();
        }
        for (int i = 1; i <= n; i++){
            cost[i] = in.nextInt();
        }

        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= m; j++){
                if (j - mas[i] < 0){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j-mas[i]] + cost[i], dp[i-1][j]);
                }
            }
        }
        findAns(n, m, dp, mas);
    }

    static void findAns(int n, int m, int[][] dp, int[] mas){
        if (dp[n][m] == 0){
            return;
        }
        if (dp[n-1][m] == dp[n][m]){
            findAns(n-1, m, dp, mas);
        }
        else{
            findAns(n-1, m - mas[n], dp, mas);
            System.out.println(n);
        }
    }
}
