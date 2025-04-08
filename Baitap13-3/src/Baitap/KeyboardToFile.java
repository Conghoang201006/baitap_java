package Baitap;

import java.io.*;

public class KeyboardToFile {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileWriter writer = new FileWriter("output.txt")) {

            System.out.println("Nhập nội dung (nhập 'exit' để kết thúc): ");
            String line;
            while (!(line = reader.readLine()).equalsIgnoreCase("exit")) {
                writer.write(line + "\n");
            }

            System.out.println("Dữ liệu đã được lưu vào output.txt!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

