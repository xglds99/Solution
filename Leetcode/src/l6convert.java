public class l6convert {

    public static void main(String[] args) {
    String s="PAYPALISHIRING";
        String s1 = new l6convert().convert(s, 3);
        System.out.println(s1);

    }

    public  String convert(String s,int nums){
        StringBuffer[] sbf = new StringBuffer[nums];
        char []chars=s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            sbf[(i+1)%nums].append(chars[i]);
        }
        String resu="";
        for(int j=0;j<nums;j++){
            resu+=sbf[j];
        }
        return resu;
    }
}
