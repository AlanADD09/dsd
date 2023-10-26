//Proyecto 3 -- Dominguez Duran Alan Axel -- 4CM11
import java.io.*;
import java.util.Scanner;

public class Logs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filename = "Logs.txt";
        // Integer count = 0;

        System.out.print("Enter the number of logs: ");
        Integer n = Integer.parseInt(scanner.nextLine());
        scanner.close();

        while (true) {
            // if (count == 10000) {
            //     break;
            // }
            try {
                FileWriter writer = new FileWriter(filename, true);
                for (int i = 0; i < n; i++) {
                    writer.write(Utils.generatePhoneNumber() + ", " + Utils.getCURP() + ", " + Utils.getRandomEducationLevel() + ", " + Utils.generateAge() + "\n");
                }
                writer.close();
                System.out.println("Strings saved to file " + filename);
                // count++;
            } catch (IOException e) {
                System.out.println("An error occurred while saving the strings to file.");
                e.printStackTrace();
            }   
        }
    }
}