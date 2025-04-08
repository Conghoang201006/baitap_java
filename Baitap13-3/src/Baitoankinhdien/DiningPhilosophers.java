package Baitoankinhdien;

import java.util.concurrent.Semaphore;

class Chopstick {
    private final Semaphore semaphore = new Semaphore(1); // Mỗi chiếc đũa chỉ có thể được 1 người dùng
    
    public boolean pickUp() {
        return semaphore.tryAcquire(); // Lấy đũa nếu có thể
    }

    public void putDown() {
        semaphore.release(); // Trả đũa lại bàn
    }
}

class Philosopher extends Thread {
    private final int id;
    private final Chopstick leftChopstick;
    private final Chopstick rightChopstick;

    public Philosopher(int id, Chopstick left, Chopstick right) {
        this.id = id;
        this.leftChopstick = left;
        this.rightChopstick = right;
    }

    private void think() throws InterruptedException {
        System.out.println("Triết gia " + id + " đang suy nghĩ...");
        Thread.sleep((int) (Math.random() * 1000));
    }

    private void eat() throws InterruptedException {
        System.out.println("Triết gia " + id + " đang ăn...");
        Thread.sleep((int) (Math.random() * 1000));
    }

    @Override
    public void run() {
        try {
            while (true) {
                think(); // Suy nghĩ trước khi ăn
                
                // Lấy đũa theo thứ tự để tránh deadlock
                if (leftChopstick.pickUp()) {
                    if (rightChopstick.pickUp()) {
                        eat(); // Ăn nếu có cả hai đũa
                        rightChopstick.putDown(); // Đặt đũa phải xuống
                    }
                    leftChopstick.putDown(); // Đặt đũa trái xuống
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Triết gia " + id + " bị gián đoạn!");
        }
    }
}

public class DiningPhilosophers {
    public static void main(String[] args) {
        int numPhilosophers = 5;
        Chopstick[] chopsticks = new Chopstick[numPhilosophers];
        Philosopher[] philosophers = new Philosopher[numPhilosophers];

        // Khởi tạo đũa
        for (int i = 0; i < numPhilosophers; i++) {
            chopsticks[i] = new Chopstick();
        }

        // Khởi tạo triết gia
        for (int i = 0; i < numPhilosophers; i++) {
            philosophers[i] = new Philosopher(i, chopsticks[i], chopsticks[(i + 1) % numPhilosophers]);
            philosophers[i].start();
        }
    }
}
