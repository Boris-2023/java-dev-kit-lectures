import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ArrayList_ {
    public static void main(String[] args) {
        Collection<Integer> collection = List.of(1, 2, 3, 4, 5);

        ArrayList<Integer> list = new ArrayList<>(collection);
        // [] <- 1
        // [_], [1] <- 2
        // [1], [_ _], [1 _], [1 2] <- 3
        // [1 2], [_ _ _ _], [1 2 _ _], [1 2 3 _] <- 4
        // [1 2 3 4] - сложность O(1)

        // [1 2 3 4 5] <- 7, index 2 - сложность O(n):
        // [_ _ _ _ _ _ _ _ _ _] расширение
        // [1 2 3 4 5 _ _ _ _ _] копирование в новый массив
        // [1 2 3 3 4 5 _ _ _ _] копирование части после индекса вставки
        // [1 2 7 3 4 5 _ _ _ _] замена элемента

        ArrayList<Integer> listPresetCapacity = new ArrayList<>(100);
    }
}
