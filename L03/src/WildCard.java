public class WildCard {
    public static class TBox<T> {
        public static final TBox EMPTY_BOX = new TBox<>();
        private T value;

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        static <T> TBox<T> emptyBox() {
            return (TBox<T>) EMPTY_BOX;
        }

        @Override
        public String toString() {
            return value.toString();
        }

    }

    private static class Animal {
        protected String name;

        protected Animal(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return this.getClass().getSimpleName() + " with name " + name;
        }
    }

    public static class Cat extends Animal {
        protected Cat(String name) {
            super(name);
        }
    }

    public static class Dog extends Animal {
        protected Dog(String name) {
            super(name);
        }
    }

    static void printInfo(TBox<? extends Animal> animalInBox) {
        System.out.println("Info on the animal: " + animalInBox);
    }

    public static void main(String[] args) {
        TBox<Cat> catInBox = TBox.emptyBox();
        catInBox.setValue(new Cat("Vasya"));
        printInfo(catInBox);

        TBox<Dog> dogInBox = TBox.emptyBox();
        dogInBox.setValue(new Dog("Kuzya"));
        printInfo(dogInBox);
    }
}
