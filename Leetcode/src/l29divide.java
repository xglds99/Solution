import org.junit.Test;

public class l29divide {

    @Test
    public void test(){
        System.out.println(divide(7, -3));
    }
    public int divide1(int dividend,int divisor){
        if (dividend == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean negative;
        negative = (dividend ^ divisor) < 0;//������������Ƿ��������
        long t = Math.abs((long) dividend);
        long d= Math.abs((long) divisor);
        int result = 0;
        for (int i=31; i>=0;i--) {
            if ((t>>i)>=d) {//�ҳ��㹻�����2^n*divisor
                result+=1<<i;//���������2^n
                t-=d<<i;//����������ȥ2^n*divisor
            }
        }
        return negative ? -result : result;//��������ȡ��
    }

    public int divide(int dividend,int divisor){
        boolean flag1=false;
        boolean flag2=false;
        int dividend1 = Math.abs(dividend);
        int divisor1 = Math.abs(divisor);
        if(dividend <0 ){
            flag1=true;
        }
        if(divisor<0){
            flag2=true;
        }
        int sum=0;
        int resu=0;
        while(sum<dividend1){
            sum+=divisor1;
            if(sum>dividend1){
                break;
            }
            resu++;
        }
       if(flag1 && flag2){
           return resu;
       }
       if((flag1 ==true && flag2==false) || (flag1 ==false && flag2==true)){
           return  -1*resu;
       }
       return  resu;
    }
}
