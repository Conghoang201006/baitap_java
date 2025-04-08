package Baitap;

import java.io.File;

public class ListFilesInDirectory {
    public static void main(String[] args) {
        File folder = new File("C:\\TestFolder"); // Đổi đường dẫn thành thư mục cần kiểm tra

        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();
            System.out.println("Danh sách file trong thư mục:");
            for (File file : files) {
                System.out.println(file.getName());
            }
        } else {
            System.out.println("Thư mục không tồn tại!");
        }
    }
}
