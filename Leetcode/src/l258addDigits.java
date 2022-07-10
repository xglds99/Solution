public class l258addDigits {
    public static void main(String[] args) {
       l258addDigits l258addDigits=new l258addDigits();
        System.out.println(l258addDigits.addDigits1(1247));
    }

    public int addDigits(int num) {
        boolean flag=false;
        int resu=0;
        while (!flag){
            String str=Integer.toString(num);
            int []a=new int[str.length()];
            int i=0;
           resu=0;
            //取出各个位数放入数组
            while(num>0){
                a[i]=num%10;
                num/=10;
                i++;
            }
            for(int j=0;j<i;j++){
                resu+=a[j];
            }
            if(resu<10) {
                flag = true;
            }
            else {
                num=resu;
            }

        }
        return resu;
    }
/*

 */
    public int addDigits1(int num){
        while(num>=10){
        int sum=0;
        while(num>0){
            sum+=num%10;
            num/=10;
        }
            num=sum;
        }
        return  num;
    }
}
