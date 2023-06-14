import java.util.Scanner;

public class prefix {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String first = in.nextLine();
        String second = in.nextLine();
        String s = second + "#" + first;
        int[] mas = prefixFunc(s);
        for (int i = second.length() + 1; i < mas.length; i++){
            //System.out.print(mas[i] + " ");

            if (mas[i] == second.length()){
                System.out.print(i-(2 * second.length()) + " ");
            }
        }
    }

    static int[] prefixFunc(String s){
        int n = s.length();
        int[] pi = new int[n];

        for (int i = 1; i < n; i++){
            int j = pi[i-1];
            while (j > 0 && s.charAt(i) != s.charAt(j)){
                j = pi[j-1];
            }
            if (s.charAt(i) == s.charAt(j)){
                j++;
            }
            pi[i] = j;
        }

        return pi;
     }

}
