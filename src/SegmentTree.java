public class SegmentTree {

    static int n = 8;
    static int[] t = new int[4*n];

    public static void main(String[] args) {
        int[] mas = new int[n];
        mas[0] = 6;
        mas[1] = 1;
        mas[2] = -2;
        mas[3] = 3;
        mas[4] = 8;
        mas[5] = -3;
        mas[6] = 11;
        mas[7] = 2;

        build(mas, 1, 0, n-1);
        System.out.println(getSum(1, 0, n-1, 0, 4));


    }

    static void build(int[] a, int v, int tl, int tr){
        if (tl == tr){
            t[v] = a[tl];
        }
        else{
            int tm = (tl + tr) / 2;
            build(a, v*2, tl, tm);
            build(a, v*2+1, tm+1, tr);
            t[v] = t[v*2] + t[v*2+1];
        }
    }

    static int getSum(int v, int tl, int tr, int l, int r){
        if (l > r){
            return 0;
        }
        if (l == tl && r == tr){
            return t[v];
        }
        int tm = (tl + tr) / 2;
        return getSum(v*2, tl, tm, l, Math.min(r, tm)) + getSum(v*2+1, tm+1, tr, Math.max(l, tm+1), r);
    }

}
