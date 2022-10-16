public class l927threeEqualParts {


        public int[] threeEqualParts(int[] arr) {
            int sum=0;
            for (int j : arr) {
                sum += j;
            }
            if(sum==0){return new int[]{0,2};}
            if(sum%3!=0){return new int[]{-1,-1};}
            sum/=3;
            int r=arr.length-1,l=0;
            while(arr[r]==0){r--;}
            int end=r;
            int zero=arr.length-1-r;//最后一个数末尾0的个数，其他俩数的末尾0应该不少
            int count=0;
            while(count<sum){
                count+=arr[l];
                l++;
            }
            //此时的l是第一组1的末尾后边
            r=l;
            while(count<sum*2){
                count+=arr[r];
                r++;
            }
            //此时的r是第二组1的末尾后边
            //先验证末尾0是否数量足够：
            for(int i=l;i<l+zero;i++){if(arr[i]==1){return new int[]{-1,-1};}}
            for(int i=r;i<r+zero;i++){if(arr[i]==1){return new int[]{-1,-1};}}
            //再验证其他位是否一致：
            count=0;
            for(int i=0;count<sum;i++){
                if(arr[end-i]!=arr[r-1-i]||arr[end-i]!=arr[l-1-i]){return new int[]{-1,-1};}
                count+=arr[end-i];
            }
            return new int[]{l+zero-1,r+zero};
        }

}
