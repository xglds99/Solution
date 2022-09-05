public class l1582numSpecial {



    public int numSpecial(int[][] mat) {
        int ans = 0;
        for(int i = 0 ;i < mat.length; i++){
            for(int j = 0; j< mat[0].length;j++){
                if(isSpecial(mat,i,j))
                    ans++;
            }
        }
        return ans;

    }

    public boolean isSpecial(int [][]mat,int i,int j){
        if(mat[i][j] == 0)
            return false;
        for(int m = 0; m < mat[0].length; m++){
            if(mat[i][m] == 1 && m!=j)
                return false;
        }
        for(int n = 0; n<mat.length ;n++){
            if(mat[n][j] == 1 && n!= i)
                return false;
        }
        return true;
    }
}
