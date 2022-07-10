public class l169majorityElement {

    public static int   getMajorityElement(int nums[]){
        int  majority=-1;
        int count=0;
        for(int num :nums){
            if(count==0){
                majority=num;
                count++;
            }
           if(num==majority){
               count++;
           }
           else {
               count--;
           }
        }
        return  majority;
    }

    public static void main(String[] args) {
        int []nums= new int []{1,3,5,2};
        System.out.println(getMajorityElement(nums));
    }
}
