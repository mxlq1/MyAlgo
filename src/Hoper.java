import java.util.Scanner;
class Hoper {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        double[] mas = new double[n+1];

        mas[n] = 1;

        for (int i = n-1; i >= 0; i--){
            mas[i] += mas[i+1];
            if (i < n - 1) mas[i] += mas[i+2];
            if (i < n - 2) mas[i] += mas[i+3];
            mas[i] %= Math.pow(10, 9) + 7;
        }

        System.out.print((long) mas[0]);
    }

}