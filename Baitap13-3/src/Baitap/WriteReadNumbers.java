package Baitap;

import java.io.*;

public class WriteReadNumbers {
    public static void main(String[] args) {
        String fileName = "numbers.dat";

        // Ghi danh sách số nguyên vào file
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            dos.writeInt(10);
            dos.writeInt(20);
            dos.writeInt(30);
            dos.writeInt(40);
            dos.writeInt(50);
            System.out.println("Ghi danh sách số vào file thành công!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Đọc lại danh sách số nguyên từ file
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            System.out.println("Các số trong file:");
            while (dis.available() > 0) {
                System.out.println(dis.readInt());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

