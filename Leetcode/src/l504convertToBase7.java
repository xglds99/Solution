public class l504convertToBase7 {

    public static void main(String[] args) {
        l504convertToBase7 l504convertToBase7=new l504convertToBase7();
        System.out.println(l504convertToBase7.convertToBase7(-7));
    }

    public String convertToBase7(int nums){
        Boolean isFlag=true;
        StringBuilder sb=new StringBuilder("");
        if(nums==0){
            return "0";
        }
        if(nums<0){
            isFlag=false;
            nums=(-1)*nums;
        }
        while(nums!=0){
            sb.append(nums % 7);
            nums/=7;
        }
        sb.reverse();
        if(isFlag){
            return sb.toString();
        }else {
            return  "-"+sb.toString();
        }
    }
}
