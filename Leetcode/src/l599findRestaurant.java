import org.junit.Test;

import java.util.*;

/**
 * ʹ��һ����ϣ���¼ \textit{list}_1list
 * ��ÿ��������Ӧ�������±꣬Ȼ����� \textit{list}_2list����� {list}_2list�еĲ��������ڹ�ϣ���У���ô˵���ò��������˹�ͬϲ���ģ��������������͡�����������ͱ���С������С������ս�������ò����������У�
 * ����������Ϊ��С�����ͣ�����������͵�����С�����ͣ���ֱ�ӽ��ò����������С�
 */
public class l599findRestaurant {
    @Test
    public void test() {
        String[] list1 = new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        String[] restaurant = findRestaurant(list1, list2);
        System.out.println(Arrays.toString(restaurant));

    }

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        int indexSum=Integer.MAX_VALUE;
        List<String> list=new ArrayList<>();
        for (int i = 0; i < list2.length; i++) {
            if(map.containsKey(list2[i])){
                int j=map.get(list2[i]);
                if(i  + j < indexSum){
                    list.clear();
                    list.add(list2[i]);
                    indexSum = i + j;
                }else if( i + j == indexSum){
                    list.add(list2[i]);
                }
            }
        }
        return list.toArray(new String[list.size()]);
    }
}

