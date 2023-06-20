package dynamicprogramming.ÏßÐÔDP;

public class A {
    public int distanceTraveled(int mainTank, int additionalTank) {
        if (mainTank < 5)return mainTank * 10;
        int res = 0;
        int i = 0;
        while(mainTank > 0){
            res += 10;
            mainTank --;
            i++;
            if(i % 5 == 0){
                if (additionalTank > 0) {
                    additionalTank--;
                    mainTank++;
                }

            }
        }
        return  res;
    }
}
