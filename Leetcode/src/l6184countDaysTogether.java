import org.junit.Test;

public class l6184countDaysTogether {
    int []months = new int[]{0,31,28,31,30,31,30,31,31,30,31,30,31};

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {

        //arriveAlice = "08-15", leaveAlice = "08-18", arriveBob = "08-16", leaveBob = "08-19"
        //
        //来源：力扣（LeetCode）
        //链接：https://leetcode.cn/problems/count-days-spent-together
        //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
        int []map = new int[13];
        for (int i= 1;i < 13;i++){
            if (i == 2){
                map[i] = 28;
            }else if (i == 4 || i == 6 || i ==9 || i ==11){
                map[i] = 30;
            }else {
                map[i] = 31;
            }
        }
        String arriveLate = arriveAlice.compareTo(arriveBob) > 0 ? arriveAlice : arriveBob;
        String leaveFront = leaveAlice.compareTo(leaveBob) > 0 ? leaveBob : leaveAlice;
        if (arriveLate.compareTo(leaveFront) > 0){
            return 0;
        }
        int days = 0;
        for (int i = Integer.parseInt(arriveLate.substring(0, 2)); i < Integer.parseInt(leaveFront.substring(0,2)); i++){
            days +=map[i];
        }
        int del = Integer.parseInt(leaveFront.substring(3, 5)) - Integer.parseInt(arriveLate.substring(3,5));
        return days + del + 1;

    }

    /**
     * 获取日期是某一年的第几天
     * @param date
     * @return
     */
    public int get(String date){
        int res = 0;
        int i = Integer.parseInt(date.substring(0, 2));
        int j = Integer.parseInt(date.substring(3, 5));
        for (int k = 1; k < i ; k++) {
            res += months[k];
        }
        return res + j;
    }
    public int countDaysTogether_1(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob){
        int a = get(arriveAlice);
        int b = get(leaveAlice);
        int c = get(arriveBob);
        int d = get(leaveBob);

        return Math.max(0,Math.min(b,d) - Math.max(a,c) + 1);
    }

    @Test
    public void test(){
        String arrive  = "08-05";
        String leave = "09-01";
        System.out.println(get(arrive));
        System.out.println(arrive.compareTo(leave));
        String[] split = arrive.split("-");
        for (String s: split){
            System.out.println(Integer.valueOf(s));
        }
        System.out.println(countDaysTogether("08-05", "08-09", "08-07", "08-09"));
    }
}
