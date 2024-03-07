package parallel;

public class Main {
    public static void main(String[] args) {

        Thread tic = new Thread(new TicTak("["));
        Thread tak = new Thread(new TicTak("]"));

        tic.start();
        tak.start();

    }
}
