//Proyecto 3 -- Dominguez Duran Alan Axel -- 4CM11
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class DataReader {

    public static Map<String, Integer> readData(String filePath) {
        Map<String, Integer> data = new HashMap<>();

        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));

            for (String line : lines) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String escolaridad = parts[2].trim();
                    data.put(escolaridad, data.getOrDefault(escolaridad, 0) + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }

    public static List<String> getCURPs(String filePath) {
        List<String> curps = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));

            for (String line : lines) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String curp = parts[1].trim();
                    curps.add(curp);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return curps;
    }

    public static Map<String, String> getCURPsAndScholarship(String filePath) {
        Map<String, String> curpsAndEscolaridad = new HashMap<>();

        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));

            for (String line : lines) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String curp = parts[1].trim();
                    String escolaridad = parts[2].trim();
                    curpsAndEscolaridad.put(curp, escolaridad);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return curpsAndEscolaridad;
    }

    public static Map<String, Integer> getScholarshipAndAge(String filePath) {
        Map<String, Integer> escolaridadAndAge = new HashMap<>();

        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));

            for (String line : lines) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String escolaridad = parts[2].trim();
                    int edad = Integer.parseInt(parts[3].trim());
                    escolaridadAndAge.put(escolaridad, edad);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return escolaridadAndAge;
    }

    public static void main(String[] args) {
        String filePath = "Logs.txt";
        Map<String, Integer> data = readData(filePath);
        List<String> curps = getCURPs(filePath);
        Map<String, String> curpsAndEscolaridad = getCURPsAndScholarship(filePath);
        Map<String, Integer> escolaridadAndAge = getScholarshipAndAge(filePath);

        System.out.println("CURPs:");
        for (String curp : curps) {
            System.out.println(curp);
        }

        // Aquí puedes imprimir los datos de escolaridad y CURPs para verificar que se hayan leído correctamente
        for (Map.Entry<String, Integer> entry : data.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Imprimir CURPs y escolaridades
        System.out.println("CURPs y Escolaridades:");
        for (Map.Entry<String, String> entry : curpsAndEscolaridad.entrySet()) {
            System.out.println("CURP: " + entry.getKey() + ", Escolaridad: " + entry.getValue());
        }

        // Imprimir Escolaridades y Edades
        System.out.println("Escolaridades y Edades:");
        for (Map.Entry<String, Integer> entry : escolaridadAndAge.entrySet()) {
            System.out.println("Escolaridad: " + entry.getKey() + ", Edad: " + entry.getValue());
        }
    }
}
