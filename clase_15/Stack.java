import java.util.Random;
import java.io.IOException;

public class Stack {
    static Thread push;
    static Thread pop;
    static Thread watcher;
    static int counter = 0;
    static char[] array;

    public static void main(String[] args) {
        array = new char[10];

        push = new Thread(() -> {
            Random random = new Random();
            while (true) {
                int flag = random.nextInt(2);
                System.out.println("Hilo push");
                System.out.printf("flag: %b\n", flag);
                if (flag == 1) {
                    if (counter < 10) {
                        array[counter] = 'a';
                        counter++;
                    }
                }
                try {
                    Thread.sleep(1000); // Espera un segundo antes de la siguiente operación
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        pop = new Thread(() -> {
            Random random = new Random();
            while (true) {
                int flag = random.nextInt(2);
                System.out.println("Hilo pop");
                System.out.printf("flag: %b\n", flag);
                if (flag == 1) {
                    if (counter != 0) {
                        counter--;
                    }
                }
                try {
                    Thread.sleep(1000); // Espera un segundo antes de la siguiente operación
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        watcher = new Thread(() -> {
            while (true) {
                try {
                    ProcessBuilder processBuilder = new ProcessBuilder("clear");
                    Process process = processBuilder.inheritIO().start();
                    process.waitFor();
                    // int exitCode = process.waitFor();
                    // if (exitCode == 0) {
                    //     System.out.println("Terminal screen cleared successfully.");
                    // } else {
                    //     System.err.println("Failed to clear the terminal screen.");
                    // }
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print("Pila: ");
                for (int i = 0; i < counter; i++) {
                    System.out.print(array[i] + " ");
                }
                System.out.println();
                System.out.printf("Tope: %d\n", counter);

                try {
                    Thread.sleep(1000); // Espera un segundo antes de la siguiente operación
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        push.start();
        pop.start();
        watcher.start();
        // push.interrupt();
        // pop.interrupt();
        // watcher.interrupt();
    }
}
