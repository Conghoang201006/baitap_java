public class ThreadPriorityExample {
    public static void main(String[] args) {
        Thread highPriorityThread = new Thread(() -> {
            while (true) System.out.println("Luồng ưu tiên cao");
        });
        Thread lowPriorityThread = new Thread(() -> {
            while (true) System.out.println("Luồng ưu tiên thấp");
        });

        highPriorityThread.setPriority(Thread.MAX_PRIORITY);
        lowPriorityThread.setPriority(Thread.MIN_PRIORITY);

        highPriorityThread.start();
        lowPriorityThread.start();
    }
}