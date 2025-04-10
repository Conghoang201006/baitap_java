package Ex1_6;

public class Ex1_6Account {
    private String id;
    private String name;
    private int balance;
    public Ex1_6Account(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public Ex1_6Account(String id, String name, int balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getBalance() {
        return balance;
    }
    public int credit(int amount) {
        if (amount > 0) {
            balance += amount;
        }
        return balance;
    }
    public int debit(int amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Amount exceeded balance");
        }
        return balance;
    }
    public int transferTo(Ex1_6Account another, int amount) {
        if (amount <= balance) {
            this.debit(amount);
            another.credit(amount);
        } else {
            System.out.println("Amount exceeded balance");
        }
        return balance;
    }
    @Override
    public String toString() {
        return "Account[id=" + id + ", name=" + name + ", balance=" + balance + "]";
    }
}