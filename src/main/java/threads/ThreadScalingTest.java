package threads;

public class ThreadScalingTest {

    static final int THREAD_COUNT = 150000; // you can change this

    public static void main(String[] args) throws Exception {
        System.out.println("\n=== NORMAL THREADS ===");
        runTest(false);

        System.out.println("\n=== VIRTUAL THREADS ===");
        runTest(true);
    }

    private static void runTest(boolean virtual) throws Exception {
        long start = System.currentTimeMillis();

        Thread[] threads = new Thread[THREAD_COUNT];

        for (int i = 0; i < THREAD_COUNT; i++) {
            Runnable task = () -> {
                fakeDbCall();   // simulate blocking IO
            };

            if (virtual) {
                threads[i] = Thread.ofVirtual().unstarted(task);
            } else {
                threads[i] = new Thread(task);
            }
        }

        for (Thread t : threads) t.start();
        for (Thread t : threads) t.join();

        long end = System.currentTimeMillis();
        System.out.println((virtual ? "Virtual" : "Normal") +
                " threads took: " + (end - start) + " ms");
    }

    private static void fakeDbCall() {
        try {
            Thread.sleep(2000); // simulate slow DB call
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
