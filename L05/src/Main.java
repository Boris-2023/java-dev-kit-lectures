public class Main {
    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName());

        for (int i = 0; i < 5; i++) {
            new MyThread().start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(new MyRunnable()).start();
        }

        // через лямбду
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                System.out.println("3.  Hello from " + Thread.currentThread());
            }).start();
        }

    }
}