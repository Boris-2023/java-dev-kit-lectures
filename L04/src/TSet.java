import java.util.Comparator;
import java.util.TreeSet;

public class TSet {
    public static void main(String[] args) {
        TreeSet defaultConstructor = new TreeSet();
        TreeSet fromCollection = new TreeSet(defaultConstructor);

        TreeSet withComparator = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        });
    }
}
