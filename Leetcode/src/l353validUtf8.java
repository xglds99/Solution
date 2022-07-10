import org.junit.Test;

public class l353validUtf8 {
    @Test
    public  void test(){
        int data[]=new int[]{10};
        boolean b = validUtf8(data);
        System.out.println(b);
    }
    public boolean validUtf8(int[] data) {
        String[] str = new String[data.length];
        boolean flag = true;
        for (int i = 0; i < data.length; i++) {
            str[i] = Integer.toBinaryString(data[i]);
            if (str[i].length() < 8) {
                while (str[i].length() < 8) {
                    str[i] = 0 + str[i];
                }
            }
            System.out.println(str[i]);
        }
        int index = 0;
        for (int i = 0; i < 8; i++) {
            if (str[0].charAt(i) == 49) {
                index++;
            } else {
                break;
            }
        }
        if(index==0){
            return false;
        }
        if(index==1){
            if (str[0].charAt(0) != 48) {
                return false;
            }else {
                return true;
            }
        }
        for (int i = 1; i < index ; i++) {
            System.out.println(str[i].charAt(0) +" " +str[i].charAt(1) );
            System.out.println(str[i].charAt(0) != 49);
            System.out.println(str[i].charAt(1) != 48);
            if (str[i].charAt(0) != 49 || str[i].charAt(1) != 48) {
                flag = false;
                break;
            }
        }
        if (flag) {
            return true;
        } else {
            return false;
        }
    }
}
