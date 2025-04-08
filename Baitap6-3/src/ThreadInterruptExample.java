public class ThreadInterruptExample {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Luồng đang chạy...");
                try { Thread.sleep(500); } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // Đánh dấu lại
                }
            }
            System.out.println("Luồng đã bị dừng.");
        });

        t.start();
        try { Thread.sleep(3000); } catch (InterruptedException e) {}

        t.interrupt(); // Dừng luồng sau 3 giây
    }
}