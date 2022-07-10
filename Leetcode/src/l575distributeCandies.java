public class l575distributeCandies {
    public static void main(String[] args) {
        int []nums=new int[]{1,1,2,3};
        System.out.println(distributeCandies(nums));
    }
    public static int distributeCandies(int []candies){
        int n=candies.length;
        int resu=1;
        int i=1;
        for(;i<candies.length;i++){
            if(candies[i]!=candies[i-1]){
                resu++;
            }
        }
        return  resu>(n/2)? (n/2):resu;
    }
}
