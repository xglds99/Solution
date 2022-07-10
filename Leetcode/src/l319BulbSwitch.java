public class l319BulbSwitch {
    public static void main(String[] args) {
        int i = new l319BulbSwitch().bulbSwitch1(99999);
        System.out.println(i);
    }
    public  int bulbSwitch1(int n){
        return (int)Math.sqrt(n+0.5);
    }
    public  int bulbSwitch(int n) {
        if (n == 0)
            return 0;
        int[] arry = new int[n];
        for (int i = 0; i < n; i++) {
            arry[i] = 1;
        }
        for (int j = 2; j <=n; j++) {
            for (int i = 0; i < n; i++) {
                if ((i + 1) % j == 0) {
                    if(arry[i]==1){
                        arry[i]=0;
                    }else {
                        arry[i]=1;
                    }
                }
            }
        }
        int sum=0;
        for (int i = 0; i < n; i++) {
            sum+=arry[i];
        }
        return sum;
    }
}
