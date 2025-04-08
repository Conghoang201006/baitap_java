package Baitap;

import java.io.*;

class FileReaderThread extends Thread {
    private String fileName;

    public FileReaderThread(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            System.out.println("Nội dung file: " + fileName);
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file " + fileName);
        }
    }
}

public class MultiFileReader {
    public static void main(String[] args) {
        String[] fileNames = {"input1.txt", "input2.txt"};

        for (String fileName : fileNames) {
            new FileReaderThread(fileName).start();
        }
    }
}
