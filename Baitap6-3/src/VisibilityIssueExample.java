public class VisibilityIssueExample {
    private static volatile boolean flag = true;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (flag) {}
            System.out.println("Luồng t1 thấy flag đã thay đổi!");
        });

        Thread t2 = new Thread(() -> {
            try { Thread.sleep(2000); } catch (InterruptedException e) {}
            flag = false; // Thay đổi giá trị flag
            System.out.println("Luồng t2 thay đổi flag thành false.");
        });

        t1.start();
        t2.start();
    }
}