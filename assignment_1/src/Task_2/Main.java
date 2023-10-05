package Task_2;

public class Main {
    public static void main(String[] args) {
        int numThreads = 7;
        Thread[] threads = new Thread[numThreads];

        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(() -> {
                Singleton s = Singleton.getInstance();
                System.out.println("Singleton Instance Hashcode: " + s.hashCode());
            });
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
