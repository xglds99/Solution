/**
 * @author xgl
 * @date 2023/6/25 7:50
 */
public class l1401 {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int x = (x1 + x2) /2;
        int y = (y1 + y2) /2;
        if (distance(xCenter,yCenter,x,y) <= radius)return true;
        for (int i = x1; i <= x2 ; i++) {
            if (distance(xCenter, yCenter, i, y2) <= radius)return true;
        }
        for (int i = x1; i <= x2 ; i++) {
            if(distance(xCenter, yCenter, i, y1) <= radius)return true;
        }
        for (int i = y1; i <= y2 ; i++) {
            if (distance(xCenter,yCenter, x1,i) <= radius)return true;
        }
        for (int i = y1; i <= y2 ; i++) {
            if (distance(xCenter,yCenter, x2,i) <= radius)return true;
        }

        return false;
    }


    public int distance(int x1, int y1, int x2, int y2) {
        int x = Math.abs(x1 - x2);
        int y = Math.abs(y1 - y2);
        return (int) Math.sqrt(x * x + y * y);
    }
}
