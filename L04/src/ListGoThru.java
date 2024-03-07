import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ListGoThru {
    public static void main(String[] args) {
        Collection<Integer> collection = List.of(1, 2, 3, 4, 5);

        // 1 Iterator
        Iterator<Integer> iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        // for each
        for (Integer value : collection) {
            System.out.print(value + " ");
        }
        System.out.println();

        // stream API
        collection.stream()
                .forEach(value -> System.out.print(value + " "));

        System.out.println();

        collection.stream()
                .map(e -> e + " ")
                .forEach(System.out::print);
    }
}