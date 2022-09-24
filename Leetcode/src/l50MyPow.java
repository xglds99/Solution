import java.util.HashMap;

public class l50MyPow
{
    public static  double myPow(double x, int n){
        double N = n;
        return N>=0 ? quickMal(x,n) : 1.0 / quickMal(x, n);
    }

    public static double quickMal(double x, int N){
        if (N == 1)
            return x;
        double y = quickMal(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }


    public static void main(String[] args) {
        double x = myPow(2, 67);
        System.out.println(x);
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 2);
        Integer integer = map.get(2);
        System.out.println(integer);
    }
}
