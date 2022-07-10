import java.util.HashMap;
import java.util.Map;

public class l677MapSum {

    public static void main(String[] args) {
    MapSum mapSum=new MapSum();
    mapSum.insert("MapSum",10);
    mapSum.insert("Mapsi",20);
        int ma = mapSum.sum("MapS");
        System.out.println(ma);
    }
}

class MapSum{

    Map<String, Integer>  map=new HashMap<>();
    public MapSum(){
    }

    public  void insert(String key,int value){
    this.map.put(key,value);
    }

    public  int sum(String prefix){
        int resu=0;
        for(String key:map.keySet()){
            if(key.startsWith(prefix)){
                resu+=map.get(key);
            }
        }
              return resu;
    }
}