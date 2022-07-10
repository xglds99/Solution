import org.junit.Test;

import java.util.*;

/**
 * 使用一个哈希表记录 \textit{list}_1list
 * 中每个餐厅对应的索引下标，然后遍历 \textit{list}_2list，如果 {list}_2list中的餐厅存在于哈希表中，那么说明该餐厅是两人共同喜爱的，计算它的索引和。如果该索引和比最小索引和小，则清空结果，将该餐厅加入结果中，
 * 该索引和作为最小索引和；如果该索引和等于最小索引和，则直接将该餐厅加入结果中。
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

