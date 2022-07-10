import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.LinkedList;

public class l499constructRectangle {
    public static void main(String[] args) {
        int[] nums = constructRectangle(1221212);
        for(int num:nums){
            System.out.println(num);
        }
    }
    public static   int[] constructRectangle(int area){

        for ( int width=(int)Math.sqrt(area); width >0 ; width--) {
            if(area % width ==0){
                return  new int[]{area/width,width};
            }
        }
        return null;
    }

    @Test
    public  void test(){
        InetAddress address = null;
        try {
            address = InetAddress.getByName("www.hrbeu.edu.cn");
        }
        catch (UnknownHostException e) {
            System.exit(2);
        }
        System.out.println(address.getHostName() + "=" + address.getHostAddress());
        System.exit(0);
    }
    @Test
    public  void test1(){
        LinkedList linkedList = new LinkedList();

    }
}
