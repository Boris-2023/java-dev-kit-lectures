import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

// Integer, Integer
public class HMap {
    private int capacity;
    private ArrayList<LinkedList<Integer>> map;

    //_ _ _ _ _ _ _ _ _
    public HMap() {
        capacity = 100;
        map = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            map.add(new LinkedList<>());
        }
    }

    public void put(Integer key, Integer value) {
        int code = key.hashCode() % capacity;
        LinkedList<Integer> list = map.get(code);
        if (!list.contains(value)) {
            list.add(value);
        }
    }

    public static void main(String[] args) {

        HashMap<Integer, Integer> map1 = new HashMap<>();

        // Map iterations
        Map<String, Integer> map2 = Map.of("Hello", 1, "World", 2);

        // for each
        for (var entry : map2.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println();
        for(String s: map2.keySet()){
            System.out.println(s + ": " + map2.get(s));
         }

        // stream
        System.out.println();
        map2.forEach((k,v) -> System.out.println(k + ": " + v));
    }
}
