/**
 * @ClassName l640
 * @Description
 * @Author xgl
 * @Date 2023/7/6 14:00
 * @Version 1.0
 */
public class l640 {
    public String solveEquation(String equation) {
        String[] equations = equation.split("=");
        int i = 0;
        int n = equations[0].length();
        char[] cs1 = equations[0].toCharArray();
        int ln = 0;
        int lx = 0;
        while(i < n){
            StringBuilder sb = new StringBuilder();
            sb.append(cs1[i++]);
            while(i < n && cs1[i] != '-' && cs1[i] != '+'){
                sb.append(cs1[i++]);
            }
            if (sb.indexOf("x") == -1){
                ln += Integer.parseInt(sb.toString());
            }else {
                if (sb.length() == 1 || (sb.length() == 2 && sb.charAt(0) == '+')){
                    lx ++;
                }else if(sb.length() == 2 && sb.charAt(0) == '-'){
                    lx --;
                }else {
                    lx += Integer.parseInt(sb.substring(0, sb.length() - 1));
                }
            }
        }
        i = 0;
        char[] cs2 = equations[1].toCharArray();
        n = cs2.length;
        int rx = 0;
        int rn = 0;
        while(i < n){
            StringBuilder sb = new StringBuilder();
            sb.append(cs2[i++]);
            while(i < n && cs2[i] != '-' && cs2[i] != '+'){
                sb.append(cs2[i++]);
            }
            if (sb.indexOf("x") == -1){
                rn += Integer.parseInt(sb.toString());
            }else {
                if (sb.length() == 1 || (sb.length() == 2 && sb.charAt(0) == '+')){
                    rx ++;
                }else if(sb.length() == 2 && sb.charAt(0) == '-'){
                    rx --;
                }else {
                    rx += Integer.parseInt(sb.substring(0, sb.length() - 1));
                }
            }
        }
        System.out.println(ln);
        System.out.println(lx);
        System.out.println(rn);
        System.out.println(rx);
        rn *= -1;
        rx *= -1;
        return "x=" + (ln - rn) / (rx - lx);
    }
}
