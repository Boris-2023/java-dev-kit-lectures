import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class LinkedList_ {
    public static void main(String[] args) {
        Collection<String> collection = List.of("privet", "2", "3", "4", "Hello!");

        LinkedList<String> linkedList = new LinkedList<>(); // empty list
        LinkedList<String> linkedListFromCollection = new LinkedList<>(collection); // empty list
    }
}
